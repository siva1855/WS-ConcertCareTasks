package com.concertcare.sivatask.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.model.UserRequest;
import com.concertcare.sivatask.model.UserResponse;
import com.concertcare.sivatask.service.UserService;
import com.concertcare.sivatask.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	// it will verify user name and password
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id = userService.saveUser(user);
		return ResponseEntity.ok("User is saved with id :: " + id);
	}

	// validate login user
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginCheck(@RequestBody UserRequest userRequest) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUname(), userRequest.getUpassword()));
		// genarate Token
		String token = jwtUtils.generateToken(userRequest.getUname());
		// give response

		return ResponseEntity.ok(new UserResponse("SUCCESS", token));

	}

}
