package com.YtSpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/admin/home")
	public String handleAdmin() {
		return "admin home";
	}
	
	@GetMapping("/user/home")
	public String handleUser() {
		return "user home";
	}
}
