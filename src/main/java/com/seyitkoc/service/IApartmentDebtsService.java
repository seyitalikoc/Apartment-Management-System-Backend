package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.Debt;

import java.util.List;

public interface IApartmentDebtsService {
    void setDebtToApartments(Debt debt, Building building, List<Long> apartmentIds);
    void updateApartmentDebts(Debt debt, Building building, List<Long> newApartmentIds);
    String paidDebt(String token, Long apartmentDebtId); // it returns apartmentDebt's dto
    String confirmDebtPayment(Long apartmentDebtId, String token); // it returns apartmentDebt's dto

    DtoApartmentDebts getApartmentDebtByFilter(Long id, String token);
}
