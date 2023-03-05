package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerOrder;

public interface OrderRepositary extends JpaRepository<CustomerOrder, Integer>{

}
