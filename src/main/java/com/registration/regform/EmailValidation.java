package com.registration.regform;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
@Component
public class EmailValidation {
	
	public static String validateemail(String email) {
		
		if(email==null || email.isEmpty()) {
			
			return "Invalid";
		}
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
							"^[a-zA-Z0-9_+&*-]+)*@"+
							"(?:a-zA-Z0-9-]+\\.)+[a-zA-Z]{8,10}$";
		
		Pattern pattern = Pattern.compile(emailRegex);
		if(pattern.matcher(email).matches()) {
			return "Valid";
		}else {
			return "Invalid";
		}
	}
}
