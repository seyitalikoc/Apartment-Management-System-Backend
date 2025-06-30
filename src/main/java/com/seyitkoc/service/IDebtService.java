package com.seyitkoc.service;

import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IDebtService {
    DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU);

    DtoDebt updateDebt(String token, Long debtId, DtoDebtIU dtoDebtIU);

    Page<DtoDebt> getAllDebtsByBuildingId(
            Long buildingId, String type, String searchingText,
            Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int size, String sortBy, String sortDirection,
            String token);

    Page<DtoDebt> getAllDebtsByApartmentId(
            Long buildingId, Long apartmentId, String type,
            String searchingText, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int size, String sortBy, String sortDirection,
            String token);

    DtoDebt getDebtById(String token, Long debtId);

    String deleteDebt(String token, Long debtId);
}
