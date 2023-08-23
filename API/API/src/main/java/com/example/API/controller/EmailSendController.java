package com.example.API.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.API.service.EmailSendService;

@Controller
@RequestMapping("/api/mail")
@RestController()
@CrossOrigin(origins = "http://localhost:3000")
public class EmailSendController {
	
	private EmailSendService emailSendService;
	
	
	
	public EmailSendController(EmailSendService emailSendService) {
		super();
		this.emailSendService = emailSendService;
	}



	@PostMapping("/send")
	public String sendMail(@RequestParam(value="file", required=false)MultipartFile[] file,String to,String[] cc,String subject,String body)
	{
		
		return emailSendService.send(file,to,cc,subject,body);
	}

}
