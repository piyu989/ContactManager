package com.smart.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.entity.Contact;
import com.smart.entity.User;
import com.smart.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("index")
	public String dashboard(Model model,Principal principal) {	
		model.addAttribute("title","Home");
		return "normal/user_dashboard";
	}
	@GetMapping("logout")
	public String logout(Model model) {		
		model.addAttribute("title","logout");
//		model.addAttribute("contact",new Contact());
		return "home";
	}
	@GetMapping("add-contact")
	public String addContact(Model model) {		
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact",new Contact());
		return "normal/add_contact_form";
	}
}
