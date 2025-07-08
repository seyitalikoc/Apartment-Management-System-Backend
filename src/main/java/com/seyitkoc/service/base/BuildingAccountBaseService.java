package com.seyitkoc.service.base;

import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.specification.BuildingAccountSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BuildingAccountBaseService {
    private final BuildingAccountRepository buildingAccountRepository;
    private final BuildingAccountSpecification buildingAccountSpecification;

    public BuildingAccountBaseService(BuildingAccountRepository buildingAccountRepository, BuildingAccountSpecification buildingAccountSpecification) {
        this.buildingAccountRepository = buildingAccountRepository;
        this.buildingAccountSpecification = buildingAccountSpecification;
    }

    public Page<BuildingAccount> getAllAccountsByBuildingId(Long buildingId, int year, int page, int size, String sortBy, String sortDirection) {
        Specification<BuildingAccount> specification = Specification.where(buildingAccountSpecification.byBuildingId(buildingId))
                .and(buildingAccountSpecification.byYear(year == 0 ? LocalDateTime.now().getYear() : year));

        return buildingAccountRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}
