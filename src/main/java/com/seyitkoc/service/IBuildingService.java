package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IBuildingService {
    // CRUD
    String saveBuilding(DtoBuildingIU dtoBuildingIU);
    Page<DtoBuilding> getAllBuildings(int page, int size, String sortBy, String sortDirection);
    DtoBuilding getBuildingById(String token, Long buildingId);
    String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token);
    String deleteBuilding(Long id);

    // Nested Resources
    Page<DtoApartment> getAllApartmentsByBuildingId(
            String token, Long buildingId, int page, int size, String sortBy, String sortDirection);

    Page<DtoAnnouncement> getAnnouncementsByBuildingId(
            String token, Long buildingId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            String createdBy, int page, int size, String sortBy, String sortDirection);

    Page<DtoBuildingAccount> getAllBuildingAccountsByBuildingId(
            Long buildingId, int year, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoPoll> getAllPollsByBuildingId(
            Long buildingId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            boolean isFinished, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(
            Long buildingId, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoDebt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt,
            LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoTransaction> getAllTransactionsByBuildingIdAndFilter(
            String token, Long id, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection);

    DtoDue getDueByBuildingId(Long buildingId, String token);


    // Special Operations
    String updateBuildingStatus(Long id, String status);
    DtoBuilding changeManager(Long buildingId, Long managerId);

    //
    Building getBuildingById(Long buildingId);


}
