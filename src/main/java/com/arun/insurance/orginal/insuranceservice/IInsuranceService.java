package com.arun.insurance.orginal.insuranceservice;

import java.util.List;
import java.util.Optional;

import com.arun.insurance.orginal.entity.InsuranceModel;

public interface IInsuranceService {

	String registerInsuranceUser(InsuranceModel insuranceObj);

	String deleteInsuranceUser(Long n);

	String updateInsuranceUser(Long n,InsuranceModel insuranceObj);

	Optional<InsuranceModel> getUserById(Long n);

	List<InsuranceModel> getAllInsuranceUser();

}
