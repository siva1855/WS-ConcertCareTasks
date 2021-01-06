package com.concertcare.sivatask.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.concertcare.sivatask.feignclient.UserFeignClient;
import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.service.UserService;
import com.concertcare.sivatask.template.UserDepartmentResponseTemplate;
import com.concertcare.sivatask.vo.DepartmentVO;

@RestController
@RequestMapping(value = "/userservice", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private UserFeignClient userFeignClient;

	/* producer ----- get all records */
	@RequestMapping(value = "/alldata", method = RequestMethod.GET, consumes = "application/json")
	public List<DepartmentVO> getAll() {
		return userFeignClient.getData();
	}

	/* producer ----- get one record */
	@RequestMapping(value = "/onedata/{userId}", method = RequestMethod.GET, consumes = "application/json")
	public UserDepartmentResponseTemplate getUserWithDepartment(@PathVariable("userId") Integer userId) {
		logger.info("Inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
	}

	/* save data */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		ResponseEntity<String> responseEntity = null;
		try {
			Integer userId = userService.saveUser(user);
			responseEntity = new ResponseEntity<String>(userId + "-saved", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("Unable to Save", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return responseEntity;
	}

	/* get all records */
	@RequestMapping(value = "/all", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> getAllStudents() {
		ResponseEntity<?> response = null;
		try {
			List<User> list = userService.getAllUsers();
			if (list != null && !list.isEmpty())
				response = new ResponseEntity<List<User>>(list, HttpStatus.OK);
			else
				response = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* get one record */
	@RequestMapping(value = "/one/{userId}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> getOneStudent(@PathVariable("userId") Integer userId) {
		ResponseEntity<?> response = null;
		try {
			Optional<User> opt = userService.getOneUser(userId);
			if (opt.isPresent())
				response = new ResponseEntity<User>(opt.get(), HttpStatus.OK);
			else
				response = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* remove one record */
	@RequestMapping(value = "/remove/{userId}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<String> deleteStudent(@PathVariable("userId") Integer userId) {
		ResponseEntity<String> response = null;
		try {
			boolean exist = userService.isExist(userId);
			if (exist) {
				userService.deleteUser(userId);
				response = new ResponseEntity<String>(userId + "-removed", HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>(userId + "-Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* update one record */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> updateStudent(@RequestBody User user) {
		ResponseEntity<String> response = null;
		try {
			boolean exist = userService.isExist(user.getUserId());
			if (exist) {
				userService.saveUser(user);
				response = new ResponseEntity<String>(user.getUserId() + "-Updated", HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>(user.getUserId() + "-Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Update", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

}
