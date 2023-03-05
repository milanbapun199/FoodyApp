package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MerchantRequest;

@Repository
public interface MerchantRequestRepositary extends JpaRepository<MerchantRequest, Integer>{

}
