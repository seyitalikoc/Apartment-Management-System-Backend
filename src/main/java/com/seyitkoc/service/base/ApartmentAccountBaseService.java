package com.seyitkoc.service.base;

import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.repository.ApartmentAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApartmentAccountBaseService {
    private final ApartmentAccountRepository apartmentAccountRepository;

    public ApartmentAccountBaseService(ApartmentAccountRepository apartmentAccountRepository) {
        this.apartmentAccountRepository = apartmentAccountRepository;
    }

    public Page<ApartmentAccount> getAccountsByBuildingId(
            Long buildingId, int page, int pageSize, String sortBy, String sortDirection){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return apartmentAccountRepository.findAllByBuildingId(buildingId, pageable);
    }

}
