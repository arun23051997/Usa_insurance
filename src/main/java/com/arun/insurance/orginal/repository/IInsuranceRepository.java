package com.arun.insurance.orginal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.insurance.orginal.entity.InsuranceModel;

@Repository
public interface IInsuranceRepository extends JpaRepository<InsuranceModel,Long>{

}
