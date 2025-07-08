package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.debt.DtoDebt;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IApartmentService {
    void createApartmentsForBuilding(Building building, Long apartmentCount);

    // Read Operation
    DtoApartment getApartmentById(String token, Long apartmentId);

    // Nested Resources (Sub-resources)
    DtoApartmentAccount getAccountByApartmentId(String token, Long apartmentId);
    Page<DtoAnnouncement> getAllAnnouncementsByApartmentIdAndFilter(Long apartmentId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy, Boolean isRead, int page, int size, String sortBy, String sortDirection, String token);
    Page<DtoDebt> getAllDebtsByApartmentIdAndFilter(Long apartmentId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token);

    // Special Operations
    DtoApartment setApartmentOwner(String token, Long apartmentId, Long userId);
    DtoApartment setApartmentTenant(String token, Long apartmentId, Long userId);



    Apartment getApartmentById(Long apartmentId);

}
