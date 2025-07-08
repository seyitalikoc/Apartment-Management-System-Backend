package com.seyitkoc.specification;

import com.seyitkoc.entity.ApartmentDebts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ApartmentDebtsSpecification {

    public Specification<ApartmentDebts> byApartmentAccountId(Long accountId) {
        return ((root, query, criteriaBuilder) -> {
            if (accountId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("apartmentAccount").get("id"), accountId);
        });
    }

    public Specification<ApartmentDebts> byDebtId(Long debtId) {
        return ((root, query, criteriaBuilder) -> {
            if (debtId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("debt").get("id"), debtId);
        });
    }

    public Specification<ApartmentDebts> byPaid(Boolean isPaid) {
        return ((root, query, criteriaBuilder) -> {
            if (isPaid == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("paid"), isPaid);
        });
    }

    public Specification<ApartmentDebts> byConfirmed(Boolean isConfirmed) {
        return ((root, query, criteriaBuilder) -> {
            if (isConfirmed == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("confirmed"), isConfirmed);
        });
    }



}
