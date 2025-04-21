package com.arun.insurance.orginal.dto;

import com.arun.insurance.orginal.entity.UserModel;
import com.arun.insurance.orginal.mail.MailStructure;

public class UserAndMailDetailsDTO {

	private UserModel userObj;
	private MailStructure mailstructure;

	public UserModel getUserObj() {
		return userObj;
	}

	public void setUserObj(UserModel userObj) {
		this.userObj = userObj;
	}

	public MailStructure getMailstructure() {
		return mailstructure;
	}

	public void setMailstructure(MailStructure mailstructure) {
		this.mailstructure = mailstructure;
	}
}
