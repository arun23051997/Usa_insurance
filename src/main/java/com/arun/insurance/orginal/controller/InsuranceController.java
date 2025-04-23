	package com.arun.insurance.orginal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.insurance.orginal.entity.InsuranceModel;
import com.arun.insurance.orginal.insuranceservice.IInsuranceService;

@RestController  //  @Controller  //@ResponseBody
@RequestMapping("/insurancehomepage")
public class InsuranceController {

	//@Autowired
	IInsuranceService iInsuranceService;
	
	@PostMapping("/insuranceUserRegistration") 
	public String insuranceUserRegistration(@RequestBody InsuranceModel insuranceObj) {
		return iInsuranceService.registerInsuranceUser(insuranceObj);
	} 
	

	
	
	
	@GetMapping("/getInsuranceUsers")
	public List<InsuranceModel> getUserDetails() {
		return iInsuranceService.getAllInsuranceUser();
	}
	
	
	@GetMapping("/getRecordInsuranceById/{id}") //Read selected one
	public Optional<InsuranceModel> getRecord(@PathVariable (value="id") Long n) {
		return iInsuranceService.getUserById(n);
	}
	
	@PutMapping("/updateInsuranceRecordinsurance/{id}")
	public String updateRecord(@PathVariable (value="id") Long n,@RequestBody InsuranceModel insuranceObj) {
		return iInsuranceService.updateInsuranceUser(n, insuranceObj);
	}
	
	@DeleteMapping("/deleteRecord/{id}")
	public String deleteRecord(@PathVariable (value="id") Long n) {
			
			return iInsuranceService.deleteInsuranceUser(n);
			  
		
	}
}
