package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enquiry;

public interface EnquiryRepositary extends JpaRepository<Enquiry, Long>{

}
