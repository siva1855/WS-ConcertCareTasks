package com.concertcare.sivatask.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concertcare.sivatask.model.Department;
import com.concertcare.sivatask.service.DepartmentService;

@RestController
@RequestMapping(value = "/departmentservice", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;
		
	/* save data */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> saveDepartment(@RequestBody Department department) {
		ResponseEntity<String> responseEntity = null;
		try {
			Integer departmentId = departmentService.saveDepartment(department);
			responseEntity = new ResponseEntity<String>(departmentId + "-saved", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("Unable to Save", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return responseEntity;
	}

	/* get all records */
	@RequestMapping(value = "/all", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> getAllDepartments() {
		ResponseEntity<?> response = null;
		try {
			List<Department> list = departmentService.getAllDepartments();
			if (list != null && !list.isEmpty())
				response = new ResponseEntity<List<Department>>(list, HttpStatus.OK);
			else
				response = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* get one record */
	@RequestMapping(value = "/one/{departmentId}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> getOneDepartment(@PathVariable("departmentId") Integer departmentId) {
		ResponseEntity<?> response = null;
		try {
			Optional<Department> opt = departmentService.getOneDepartment(departmentId);
			if (opt.isPresent())
				response = new ResponseEntity<Department>(opt.get(), HttpStatus.OK);
			else
				response = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* remove one record */
	@RequestMapping(value = "/remove/{departmentId}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
		ResponseEntity<String> response = null;
		try {
			boolean exist = departmentService.isExist(departmentId);
			if (exist) {
				departmentService.deleteDepartment(departmentId);
				response = new ResponseEntity<String>(departmentId + "-removed", HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>(departmentId + "-Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

	/* update one record */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
		ResponseEntity<String> response = null;
		try {
			boolean exist = departmentService.isExist(department.getDepartmentId());
			if (exist) {
				departmentService.saveDepartment(department);
				response = new ResponseEntity<String>(department.getDepartmentId() + "-Updated", HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>(department.getDepartmentId() + "-Not Exist",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Unable to Update", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}

}
