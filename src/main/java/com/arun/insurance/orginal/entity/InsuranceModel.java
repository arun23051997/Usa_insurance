package com.arun.insurance.orginal.entity;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "InsuranceDetailsTable")
public class InsuranceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NaturalId(mutable = true)
	@Column(name = "Insurance_number")
	private int insuranceNum;
	
	@Column(name = "Insurance_name")
	private String insuranceName;
	
	@Column(name = "Insurance_type")
	private String insuranceType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getInsuranceNum() {
		return insuranceNum;
	}
	public void setInsuranceNum(int insuranceNum) {
		this.insuranceNum = insuranceNum;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
}	
