package com.arun.insurance.orginal.password;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;
@Component
public class PasswordCreation {

	public String secureRandomPassword(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
		SecureRandom secureRandom = new SecureRandom();

		StringBuilder password = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int randomIndex = secureRandom.nextInt(characters.length());
			password.append(characters.charAt(randomIndex));
		}

		return password.toString();
	}
}
