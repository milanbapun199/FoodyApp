package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	
}
