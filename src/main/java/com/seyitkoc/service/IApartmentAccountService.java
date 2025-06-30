package com.seyitkoc.service;

import com.seyitkoc.dto.apartment.account.DtoApartmentAccount;
import com.seyitkoc.entity.apartment.Apartment;
import org.springframework.data.domain.Page;

public interface IApartmentAccountService {
    void createAccount(Apartment apartment);

    void updateBalance(Long accountId);

    DtoApartmentAccount getApartmentAccountDetails(String token, Long accountId);

    Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(String token, Long buildingId, int page, int size, String sortBy, String sortDirection);
}
