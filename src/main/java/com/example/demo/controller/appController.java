package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Employee;

@Controller
public class appController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/log")
	public String login() {return "form";}
	
	@GetMapping("/about")
	public String about(Principal principal,Model model) {
		model.addAttribute("list", principal.getName());
		return "about";
	}
}
