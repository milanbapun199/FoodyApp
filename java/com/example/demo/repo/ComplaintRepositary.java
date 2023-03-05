package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Complaint;

public interface ComplaintRepositary extends JpaRepository<Complaint, Long>{

}
