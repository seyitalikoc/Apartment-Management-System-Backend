package com.seyitkoc.service.impl;

import com.seyitkoc.dto.apartment.account.DtoApartmentAccount;
import com.seyitkoc.entity.apartment.Apartment;
import com.seyitkoc.entity.apartment.ApartmentAccount;
import com.seyitkoc.exception.ApplicationException;
import com.seyitkoc.exception.ErrorMessage;
import com.seyitkoc.exception.MessageType;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.repository.ApartmentAccountRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApartmentAccountServiceImpl implements IApartmentAccountService {
    private final ApartmentAccountRepository apartmentAccountRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final ApartmentAccountMapper apartmentAccountMapper;

    public ApartmentAccountServiceImpl(ApartmentAccountRepository apartmentAccountRepository, IUserService userService, JwtTokenService jwtTokenService, ApartmentAccountMapper apartmentAccountMapper) {
        this.apartmentAccountRepository = apartmentAccountRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentAccountMapper = apartmentAccountMapper;
    }

    @Override
    @Transactional
    public void createAccount(Apartment apartment) {
        ApartmentAccount apartmentAccount = new ApartmentAccount();
        apartmentAccount.setApartment(apartment);
        apartmentAccount.setBalance(0.0);
        apartmentAccountRepository.save(apartmentAccount);
    }

    @Override
    public void updateBalance(Long accountId) {
        ApartmentAccount apartmentAccount = apartmentAccountRepository.findApartmentAccountById(accountId)
                .orElseThrow(() -> new RuntimeException("Apartment account not found with id: " + accountId));

        apartmentAccount.setBalance(apartmentAccount.getBalanceCalculated());
        apartmentAccount.setBalanceUpdatedAt(LocalDateTime.now());
        apartmentAccountRepository.save(apartmentAccount);
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

        return apartmentAccountMapper.toDto(apartmentAccount);
    }

    @Override
    public Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(String token, Long buildingId, int page, int size, String sortBy, String sortDirection) {
        userService.checkUserIsManagerOfBuilding(token, buildingId);

        return apartmentAccountRepository.findAllByBuildingId(
                buildingId, PageRequest.of(page, size, Sort.by(sortDirection, sortBy)))
                .map(apartmentAccountMapper::toDto);
    }
}
