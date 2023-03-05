package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
public interface UserRepositary extends JpaRepository<User, Long>{

	User findByuserName(String userName);

}
