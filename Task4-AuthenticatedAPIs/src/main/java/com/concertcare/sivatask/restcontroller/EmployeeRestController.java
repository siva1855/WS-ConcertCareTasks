package com.concertcare.sivatask.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.concertcare.sivatask.model.Employee;
import com.concertcare.sivatask.service.EmployeeService;

@Controller
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployees = employeeService.getAllEmployees();
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@RequestMapping("/new")
	public String newEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute(employee);
		return "new_employee";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/edit/{employeeId}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "employeeId") Integer employeeId) {
		ModelAndView modelAndView = new ModelAndView("edit_employee");
		Employee employee = employeeService.getOneEmployee(employeeId);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteStudentPage(@PathVariable(name = "employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/";
	}

}
