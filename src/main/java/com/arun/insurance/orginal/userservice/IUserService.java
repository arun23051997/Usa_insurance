package com.arun.insurance.orginal.userservice;

import java.util.List;
import java.util.Optional;

import com.arun.insurance.orginal.dto.UserAndMailDetailsDTO;
import com.arun.insurance.orginal.entity.UserModel;

public interface IUserService {

	UserModel userFindByEmail(String n);

	String registrationUser_WithSendMail(UserAndMailDetailsDTO userAndMailDetailsDTO);

	List<UserModel> getAllRecords();

	Optional<UserModel> getRecordById(Long n);

	String userUpdate(Long n,UserModel userObj);

	String userDelete(Long n);

}
