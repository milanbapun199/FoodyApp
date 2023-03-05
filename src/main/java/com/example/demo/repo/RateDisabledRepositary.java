package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RateDisabled;

@Repository
public interface RateDisabledRepositary extends JpaRepository<RateDisabled, Long>{

//	public boolean deleteBymerchantIdandproductName(Long merchantId, String productName);

}
