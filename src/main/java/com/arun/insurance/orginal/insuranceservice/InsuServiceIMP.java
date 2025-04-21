package com.arun.insurance.orginal.insuranceservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.arun.insurance.orginal.entity.InsuranceModel;
import com.arun.insurance.orginal.repository.IInsuranceRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class InsuServiceIMP implements IInsuranceService{

	@Autowired
	IInsuranceRepository iInsuranceRepository;
	
	
	
	public String registerInsuranceUser(InsuranceModel insuranceObj) {
		try {
			iInsuranceRepository.save(insuranceObj);
			
			return "Hello "+insuranceObj.getInsuranceName()+" Your account is created!";
		}
		catch(DataIntegrityViolationException  e){
			return "Dublicate Entry,Account Not Created Please Retry!";
				}
		catch(Exception  e){
			return "Somthing Else,Account Not Created Please Retry!";
				}
			
	}

	
	public List<InsuranceModel> getAllInsuranceUser() {
		
		return iInsuranceRepository.findAll();
	}
	
	public Optional<InsuranceModel> getUserById(Long n) {
		
		return iInsuranceRepository.findById(n);
	}
	

	public String updateInsuranceUser(Long n,InsuranceModel updatedDetail) {
		try {
			Optional<InsuranceModel> willUpdate = iInsuranceRepository.findById(n);
			 if (willUpdate.isPresent()) {
				 InsuranceModel existingDetail = willUpdate.get();
		            existingDetail.setInsuranceName(updatedDetail.getInsuranceName());
		            existingDetail.setInsuranceNum(updatedDetail.getInsuranceNum());
		            existingDetail.setInsuranceType(updatedDetail.getInsuranceType());
		            iInsuranceRepository.save(existingDetail);
		            return "Successfully Updated!";}
			 
			 else {
				 return "Data not found";
			 }}
			 
			
		catch(Exception e) {
			return "Somthing Error" + e;
		}
	}




	public String deleteInsuranceUser(Long n) {
		
		
		try {
			Optional<InsuranceModel> getinfor = iInsuranceRepository.findById(n);
			InsuranceModel existingDetail = getinfor.get();
			   iInsuranceRepository.deleteById(n);
		return existingDetail.getInsuranceName()+ " is Successfully Deleted";}
		catch (EntityNotFoundException ex) {
           
            return "Entity not found for ID: " + n;
        } catch (Exception e) {
            
            return "Deletion failed due to an unexpected error";
        }
}


	


}
