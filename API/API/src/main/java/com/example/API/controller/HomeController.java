package com.example.API.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/api")
@RestController()
public class HomeController {

	@GetMapping("/home")
	public String home()
	{
		return "Welcome to NucleusTeq";
	}
	
	
}
