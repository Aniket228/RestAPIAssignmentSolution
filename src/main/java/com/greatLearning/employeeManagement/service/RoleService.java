package com.greatLearning.employeeManagement.service;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    public Role findById(int id);

    public void save(Role role);

    public void deleteById(int id);

    public Role findByName(String name);
}