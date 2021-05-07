package dev.lnt.controllers;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/logtests")
@CrossOrigin("*")
public class LogTestController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(LogTestController.class);
	
	@GetMapping
	public ResponseEntity<String> testLog(){
		
		logger.info("Accessing testLog controller at " + new Date());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Access successfully!");
	}
	
	@PostMapping
	public ResponseEntity<String> testLogWithError(){
		
		logger.error("Simulate ERROR log from the backend at " + new Date());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Throw exception successfully!");
		
	}
	
}
