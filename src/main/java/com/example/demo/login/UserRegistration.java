package com.example.demo.login;
import lombok.Data;


@Data
public class UserRegistration {
	private String username;
	private String password;
	private String confirmPassword;
}
