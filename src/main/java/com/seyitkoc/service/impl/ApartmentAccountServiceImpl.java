package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.repository.ApartmentAccountRepository;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.service.base.ApartmentDebtsBaseService;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApartmentAccountServiceImpl implements IApartmentAccountService {
    private final ApartmentAccountRepository apartmentAccountRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final ApartmentDebtsBaseService apartmentDebtsBaseService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public ApartmentAccountServiceImpl(ApartmentAccountRepository apartmentAccountRepository, IUserService userService, JwtTokenService jwtTokenService, ApartmentAccountMapper apartmentAccountMapper, ApartmentDebtsBaseService apartmentDebtsBaseService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentAccountRepository = apartmentAccountRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.apartmentDebtsBaseService = apartmentDebtsBaseService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }

    @Override
    @Transactional
    public void createAccounts(List<Apartment> apartments) {
        List<ApartmentAccount> apartmentAccounts = apartments.stream().map(apartment ->{
            ApartmentAccount apartmentAccount = new ApartmentAccount();
            apartmentAccount.setApartment(apartment);
            apartmentAccount.setBalance(0.0);
            return  apartmentAccount;
        }).toList();

        apartmentAccountRepository.saveAll(apartmentAccounts);
    }

    @Override
    public DtoApartmentAccount getApartmentAccountDetails(String token, Long accountId) {
        ApartmentAccount apartmentAccount = apartmentAccountRepository.findApartmentAccountById(accountId)
            .orElseThrow(() -> new RuntimeException("Apartment account not found with id: " + accountId));
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));

        try{
            userService.checkUserIsManagerOfBuilding(email, accountId);
        }catch (ApplicationException e){
            try {
                userService.checkUserIsOwnerOrTenantOfApartment(email, accountId);
            }catch (ApplicationException ex) {
                throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You do not have permission to view this account."));
            }
        }
        apartmentAccount.setBalance(apartmentAccount.getBalanceCalculated());
        apartmentAccount.setBalanceUpdatedAt(LocalDateTime.now());
        apartmentAccountRepository.save(apartmentAccount);

        return apartmentAccountMapper.toDto(apartmentAccount);
    }

    @Override
    public Page<DtoApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int pageSize, String sortBy, String sortDirection, String token) {
        ApartmentAccount apartmentAccount = apartmentAccountRepository.findApartmentAccountById(accountId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment account not found with id: " + accountId))
        );
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ",""));
        try{
            userService.checkUserIsManagerOfBuilding(email, apartmentAccount.getApartment().getBuilding().getId());
        }catch (ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentAccount.getApartment().getId());
        }

        return apartmentDebtsBaseService
                .getApartmentDebtsByAccountIdAndFilter(accountId, isPaid, isConfirmed, page, pageSize, sortBy, sortDirection)
                .map(apartmentDebtsMapper::entityToDto);
    }

}
