package com.seyitkoc.service;

import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.debt.Debt;

import java.util.List;

public interface IApartmentDebtService {
    void setDebtToApartments(Debt debt, Building building, List<Long> apartmentIds);
    void updateApartmentDebts(Debt debt, Building building, List<Long> newApartmentIds);
    String paidDebt(String token, Long apartmentDebtId); // it returns apartmentDebt's dto
    String confirmDebtPayment(Long apartmentDebtId, String token); // it returns apartmentDebt's dto
}
