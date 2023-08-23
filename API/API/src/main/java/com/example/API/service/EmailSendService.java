package com.example.API.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailSendService {

	String send(MultipartFile[] file, String to, String[] cc, String subject, String body);

}
