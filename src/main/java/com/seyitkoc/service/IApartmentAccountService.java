package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IApartmentAccountService {
    void createAccounts(List<Apartment> apartment);

    DtoApartmentAccount getApartmentAccountDetails(String token, Long accountId);

    Page<DtoApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int pageSize, String sortBy, String sortDirection, String token);
}
