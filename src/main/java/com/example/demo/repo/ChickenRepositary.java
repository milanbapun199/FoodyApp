package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Chicken;
import com.example.demo.entity.User;

public interface ChickenRepositary extends JpaRepository<Chicken, Long>{

	Optional<Chicken> findByMerchantId(Long merchantId);

	boolean existsByMerchantId(long merchantId);

}
