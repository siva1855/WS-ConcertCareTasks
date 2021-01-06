package com.concertcare.sivatask.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodRestController {

	/* Department---fallback methods if time exits it will executed */
	@RequestMapping(value = "/departmentservicefallback", method = RequestMethod.GET, consumes = "application/json")
	public String departmentServiceFallBack() {
		return "DepartmentService is Taking Longer Than Expected...please Try again Later";
	}

	/* User----- fallback methods if time exits it will executed */
	@RequestMapping(value = "/userservicefallback", method = RequestMethod.GET, consumes = "application/json")
	public String userServiceFallBack() {
		return "UserService is Taking Longer Than Expected...please Try again Later";
	}

}
