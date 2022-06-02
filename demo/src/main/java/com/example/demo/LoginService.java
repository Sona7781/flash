package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateUser(String user, String password)
	{
		return user.equalsIgnoreCase(password);
	}

}
