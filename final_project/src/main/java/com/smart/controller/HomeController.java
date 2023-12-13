package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.entity.User;
import com.smart.helper.Message;
import com.smart.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Registration");
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","login");
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,Model model,HttpSession session) {
		try {
			
			user.setRole("admin");
			user.setEnabled(true);
			
			System.out.println("Agreement "+true);
			System.out.println("User "+user);
			
			User result=this.userRepo.save(user);

			model.addAttribute("user",new User());
			System.out.println(user);
			
			session.setAttribute("message", new Message("Succesfully register","alert-sucess"));
			return "login";
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("something went wrong","alert-danger"));
			return "login";
		}
		
	}
}
