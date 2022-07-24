package com.greatLearning.employeeManagement.service;

import com.greatLearning.employeeManagement.entity.Employee;
import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

    public Employee findByEmail(String email);

    public List<Employee> findByFirstName(String firstName);

    public List<Employee> sortByFirstName(String sortOrder);
}