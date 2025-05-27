package in.sp.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	@GetMapping("/regPage")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	public String OpenRegpage() {
		return "register";
	}
}
