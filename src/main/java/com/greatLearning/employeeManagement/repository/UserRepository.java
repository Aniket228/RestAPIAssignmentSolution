package com.greatLearning.employeeManagement.repository;

import com.greatLearning.employeeManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT user from User user where user.username=?1")
    public User getUserByUsername(String username);

    Optional<User> findByUsername(String username);
}