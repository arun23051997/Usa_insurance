package com.arun.insurance.orginal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.insurance.orginal.entity.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByEmail(String n);

}
