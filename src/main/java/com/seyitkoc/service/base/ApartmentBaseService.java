package com.seyitkoc.service.base;

import com.seyitkoc.entity.Apartment;
import com.seyitkoc.repository.ApartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApartmentBaseService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentBaseService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public Page<Apartment> getAllApartmentsByBuildingId(Long buildingId, int page, int size, String sortBy, String sortDirection) {
        return apartmentRepository.findAllByBuildingId(buildingId, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }

    public Page<Apartment> getOwnerApartmentsByUserId(Long userId, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return apartmentRepository.findAllByOwner_Id(userId, pageRequest);
    }

    public Apartment getRentedApartmentByUserId(Long id) {
        return apartmentRepository.findApartmentByTenant_Id(id);
    }
}
