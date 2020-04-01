package com.example.demoSSH.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSSH.util.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/geeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Wrold") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
