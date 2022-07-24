package com.greatLearning.employeeManagement.service;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RolesRepository rolesRepository;

    @Autowired
    public RoleServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Transactional
    public List<Role> findAll() {
        return rolesRepository.findAll();
    }

    @Transactional
    public Role findById(int id) {
        return this.rolesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role Id: " + id + " not found !"));
    }

    @Transactional
    public void save(Role role) {
        rolesRepository.save(role);
    }

    @Transactional
    public void deleteById(int id) {
        rolesRepository.deleteById(id);
    }

    @Transactional
    public Role findByName(String name) {
        return this.rolesRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role Name"));
    }
}