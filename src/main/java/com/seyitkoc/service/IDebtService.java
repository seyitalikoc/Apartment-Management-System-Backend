package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.Due;
import org.springframework.data.domain.Page;

public interface IDebtService {
    void createDueDebt(Due due);

    DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU);

    DtoDebt updateDebt(String token, Long debtId, DtoDebtIU dtoDebtIU);

    DtoDebt getDebtById(String token, Long debtId);

    String deleteDebt(String token, Long debtId);

    Page<DtoApartmentDebts> getApartmentDebtsByDebtIdAndFilter(
            Long debtId, Boolean isPaid, Boolean isConfirm, int page, int pageSize,
            String sortBy, String sortDirection, String token);
}
