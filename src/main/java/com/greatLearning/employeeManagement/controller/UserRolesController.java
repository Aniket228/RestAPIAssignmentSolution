package com.greatLearning.employeeManagement.controller;

import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class UserRolesController {
	private RoleService roleService;

    @Autowired
    public UserRolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/listRoles")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/addRole")
    @ResponseStatus(HttpStatus.CREATED)
    public Role addRole(@RequestBody Role role) {
        roleService.save(role);
        return role;
    }

    @DeleteMapping("/deleteRole/{roleName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable String roleName) {
        Role role = roleService.findByName(roleName);

        if (role == null)
            throw new RuntimeException("Role: " + roleName + " not found");
        roleService.deleteById(role.getId());
        System.out.println("Deleted role - " + roleName);
    }
}