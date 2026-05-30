package com.nunostudios.securityessentials.service;

import com.nunostudios.securityessentials.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);

    List<Employee> findAll();

    Employee findById(Long id);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
