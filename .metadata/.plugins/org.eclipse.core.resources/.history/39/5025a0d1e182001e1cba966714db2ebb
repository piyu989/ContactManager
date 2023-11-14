package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.entity.User;
import com.smart.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/home")
	@ResponseBody
	public String test() {
		User u=new User();
		u.setName("Piyush");
		u.setEmail("adfadfa");
		
		userRepo.save(u);
		
		return "sita ram";
	}
}
