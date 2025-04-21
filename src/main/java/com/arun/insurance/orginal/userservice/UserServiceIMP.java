package com.arun.insurance.orginal.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.arun.insurance.orginal.dto.UserAndMailDetailsDTO;
import com.arun.insurance.orginal.entity.UserModel;
import com.arun.insurance.orginal.password.PasswordCreation;
import com.arun.insurance.orginal.repository.IUserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceIMP implements IUserService {

	@Autowired
	PasswordCreation passwordCreation;
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Autowired
	SimpleMailMessage bbb;
	
	@Autowired
	private JavaMailSender javamailsender;

	@Value("${spring.mail.username}")
	private String fromMail;

	public String registrationUser_WithSendMail(UserAndMailDetailsDTO userAndMailDetailsDTO) {
		try {	
//			PasswordCreation exm = new PasswordCreation();
			String psw = passwordCreation.secureRandomPassword(7);
			System.out.println("The password : " + psw);
			UserModel userObj = userAndMailDetailsDTO.getUserObj();
			userObj.setPassword(psw);
		//userAndMailDetailsDTO.getUserObj().setPassword(psw);

			System.out.println("The passwoe af : " + psw);
//			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			bbb.setFrom(fromMail);
			System.out.println("From mail " + fromMail);
			bbb.setSubject(userAndMailDetailsDTO.getMailstructure().getSubject());
			bbb.setText(userAndMailDetailsDTO.getMailstructure().getMessage() + "   "
				+ userAndMailDetailsDTO.getUserObj().getPassword());
			bbb.setTo(userAndMailDetailsDTO.getUserObj().getEmail());

			javamailsender.send(bbb);
			System.out.println("successfull mail sended");

			iUserRepository.save(userAndMailDetailsDTO.getUserObj());
			return userObj.getFirstName() +" "+userObj.getLastName()+" your account is created !";
	}
		catch(DataIntegrityViolationException  e){
			return "Dublicate Entry,Account Not Created Please Retry!";
				}
		catch (Exception e) {

			return "Account Not Created Please Retry!";}
		
		
}
	public List<UserModel> getAllRecords() {
		return iUserRepository.findAll();
	}

	public Optional<UserModel> getRecordById(Long n) {
		return iUserRepository.findById(n);
	}

	@Override
	public UserModel userFindByEmail(String n) {
		return iUserRepository.findByEmail(n);
	}

	public String userUpdate(Long n,UserModel userObj) {
		Optional<UserModel>  willUpdate  = iUserRepository.findById(n);
		Boolean isEnabled=willUpdate.get().isEnabled();
		if(willUpdate.isPresent() && isEnabled == true ) {
			willUpdate.get().setFirstName(userObj.getFirstName());
		iUserRepository.save(willUpdate.get());
		return "Update Successfull";
		}
		else {
			return "With out verified not allowed!";
		}
		
	}

	public String userDelete(Long n) {

		try {
			Optional<UserModel> getinfor = iUserRepository.findById(n);
			UserModel existingDetail = getinfor.get();
			iUserRepository.deleteById(n);
			return existingDetail.getFirstName()+ " is Successfully Deleted";
		} catch (EntityNotFoundException ex) {

			return "Entity not found for ID: " + n;
		} catch (Exception e) {

			return "Deletion failed due to an unexpected error";
		}
	}

}
