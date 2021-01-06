package com.concertcare.sivatask.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.service.UserService;

@RestController
@RequestMapping("/userdata")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return ResponseEntity.ok("User Data Has Saved Successfully..........");
	}
}
