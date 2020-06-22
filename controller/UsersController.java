package com.cimb.tokolapak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cimb.tokolapak.dao.UserRepo;
import com.cimb.tokolapak.entity.User;
import com.cimb.tokolapak.utility.EmailUtil;

@RestController
@RequestMapping ("/users")

public class UsersController {

	@Autowired 
	private UserRepo userRepo;
	
	private PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private EmailUtil emailUtil;
	
	@PostMapping
	public User registerUser(@RequestBody User user) {
	
		String encodePassword = pwEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
		emailUtil.sendEmail(user.getEmail(), "Email Verification","<h1>Thanks for Joining us</h1>\n "
				+ "<a href=\"http://localhost:8080/activate?email=" + user.getEmail() + "\">CLICK HERE</a> This is for email verification");
		
		return userRepo.save(user);
	
	}
	
	@PostMapping ("/login")
	public User loginUser (@RequestBody User user) {
		User findUser = userRepo.findByUsername(user.getUsername()).get();
		
		if (pwEncoder.matches(user.getPassword(), findUser.getPassword())) {
			return findUser;
		}
		return findUser;
	}
	
	@PostMapping ("/sendemail")
	public String sendEmailTesting () {
		this.emailUtil.sendEmail("farrasammar06@gmail.com", "Testing", "Ini Email <h1>Google ga bener</h1>");
		return "email sent";
	}
	
}
	
