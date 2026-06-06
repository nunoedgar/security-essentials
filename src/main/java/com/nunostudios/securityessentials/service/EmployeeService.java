package com.nunostudios.securityessentials.service;

import com.nunostudios.securityessentials.model.Employee;
import com.nunostudios.securityessentials.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements IEmployeeService {
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
	}

	@Override
	public Employee update(Long id, Employee employee) {
		Employee currentEmployee = findById(id);
		currentEmployee.setName(employee.getName());
		currentEmployee.setEmail(employee.getEmail());
		currentEmployee.setCreatedAt(employee.getCreatedAt());
		return employeeRepository.save(currentEmployee);
	}

	@Override
	public void delete(Long id) {
		if (!employeeRepository.existsById(id)) {
			throw new NoSuchElementException("Employee not found with id: " + id);
		}
		employeeRepository.deleteById(id);
	}
}
