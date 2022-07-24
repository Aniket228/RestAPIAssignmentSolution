package com.greatLearning.employeeManagement.service;

import com.greatLearning.employeeManagement.security.MyUserDetails;
import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Could not find user");

        return new MyUserDetails(user);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserName"));
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}    