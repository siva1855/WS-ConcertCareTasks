package com.concertcare.sivatask.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodRestController {

	/* Department---fallback methods if time exits it will executed */
	@RequestMapping(value = "/studentservicefallback", method = RequestMethod.GET, consumes = "application/json")
	public String studentServiceFallBack() {
		return "StudentService is Taking Longer Than Expected...please Try again Later";
	}

	/* User----- fallback methods if time exits it will executed */
	@RequestMapping(value = "/consumeruserservicefallback", method = RequestMethod.GET, consumes = "application/json")
	public String consumerUserServiceFallBack() {
		return "ConsumerUserService is Taking Longer Than Expected...please Try again Later";
	}

}
