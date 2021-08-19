package org.perscholas.seattle_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/logoutSuccess")
	public String showLogoutSuccessPage() {
		return "logout_success";
	}
}
