package com.nunostudios.securityessentials.controller;

import com.nunostudios.securityessentials.model.Employee;
import com.nunostudios.securityessentials.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final IEmployeeService employeeService;

	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		try {
			return employeeService.findById(id);
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", ex);
		}
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		try {
			return employeeService.update(id, employee);
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", ex);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			employeeService.delete(id);
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", ex);
		}
	}
}
