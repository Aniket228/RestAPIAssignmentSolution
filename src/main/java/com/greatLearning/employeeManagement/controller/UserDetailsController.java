package com.greatLearning.employeeManagement.controller;

import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.service.RoleService;
import com.greatLearning.employeeManagement.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private RoleService roleService;

    @GetMapping("/listUsers")
    public List<User> getAllUsers() {
        return userDetailsServiceImpl.findAll();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userDetailsServiceImpl.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        User user1 = userDetailsServiceImpl.findByUsername(user.getUsername());

        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());

        userDetailsServiceImpl.save(user1);
        return user1;
    }

    @DeleteMapping("/deleteUser/{username}")
    public void deleteUser(@PathVariable String username) {
        User user = userDetailsServiceImpl.findByUsername(username);

        if (user == null)
            throw new RuntimeException("UserName: " + username + " not found");
        userDetailsServiceImpl.deleteById(user.getId());
        System.out.println("Deleted employee - " + username);
    }

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}