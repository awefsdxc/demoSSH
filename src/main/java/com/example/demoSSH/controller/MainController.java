package com.example.demoSSH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoSSH.dao.UserRepository;
import com.example.demoSSH.entity.User;

@Controller
@RequestMapping("/demo")
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		userRepository.save(u);
		return "Saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
