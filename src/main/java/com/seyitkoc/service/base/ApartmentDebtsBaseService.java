package com.seyitkoc.service.base;

import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.repository.ApartmentDebtsRepository;
import com.seyitkoc.specification.ApartmentDebtsSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ApartmentDebtsBaseService {
    private final ApartmentDebtsRepository apartmentDebtsRepository;
    private final ApartmentDebtsSpecification apartmentDebtsSpecification;

    public ApartmentDebtsBaseService(ApartmentDebtsRepository apartmentDebtsRepository, ApartmentDebtsSpecification apartmentDebtsSpecification) {
        this.apartmentDebtsRepository = apartmentDebtsRepository;
        this.apartmentDebtsSpecification = apartmentDebtsSpecification;
    }

    public Page<ApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<ApartmentDebts> specification = Specification.where(apartmentDebtsSpecification.byApartmentAccountId(accountId))
                .and(apartmentDebtsSpecification.byPaid(isPaid))
                .and(apartmentDebtsSpecification.byConfirmed(isConfirmed));
        return apartmentDebtsRepository.findAll(specification, pageRequest);
    }

    public Page<ApartmentDebts> getApartmentDebtsByDebtId(Long debtId, Boolean isPaid, Boolean isConfirmed, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<ApartmentDebts> specification = Specification.where(apartmentDebtsSpecification.byDebtId(debtId))
                .and(apartmentDebtsSpecification.byPaid(isPaid))
                .and(apartmentDebtsSpecification.byConfirmed(isConfirmed));

        return apartmentDebtsRepository.findAll(specification, pageRequest);
    }
}
