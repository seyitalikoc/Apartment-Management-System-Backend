package com.seyitkoc.repository;

import com.seyitkoc.entity.BuildingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BuildingAccountRepository extends JpaRepository<BuildingAccount, Long>, JpaSpecificationExecutor<BuildingAccount> {

}
