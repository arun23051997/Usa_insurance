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

import com.arun.insurance.orginal.dto.UserAndMailDetailsDTO;
import com.arun.insurance.orginal.entity.UserModel;
import com.arun.insurance.orginal.userservice.IUserService;

@RestController // == @Controller //@ResponseBody
@RequestMapping("/userhomepage")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping("/registration")
	public String userDeatailsSave(@RequestBody UserAndMailDetailsDTO userAndMailDetailsDTO) {
		
		return iUserService.registrationUser_WithSendMail(userAndMailDetailsDTO);
	}

	@GetMapping("/userFindByEmail/{email}")
	public UserModel userFindByEmail(@PathVariable(value = "email") String n) {
		return iUserService.userFindByEmail(n);
	}

	@GetMapping("/getAllRecords")
	public List<UserModel> getAllRecords() {
		System.out.println("home");
		return iUserService.getAllRecords();
	}

	@GetMapping("/getrecordById/{id}")
	public Optional<UserModel> getRecord(@PathVariable(value = "id") Long n) {
		return iUserService.getRecordById(n);
	}

	@PutMapping("/updateUserRecord/{id}")
	public String updateRecord(@PathVariable(value = "id") Long n,@RequestBody UserModel userObj) {

		return iUserService.userUpdate(n,userObj);
	}

	@DeleteMapping("/deleteUserRecord/{id}")
	public String deleteUserRecord(@PathVariable(value = "id") Long n) {

		return iUserService.userDelete(n);
	}

}
