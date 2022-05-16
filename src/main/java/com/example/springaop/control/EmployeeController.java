package com.example.springaop.control;

import com.example.springaop.entity.Employee;
import com.example.springaop.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee( @RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}

}
