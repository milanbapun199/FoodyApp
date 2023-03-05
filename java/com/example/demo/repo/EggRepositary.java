package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Egg;
import com.example.demo.entity.User;

public interface EggRepositary extends JpaRepository<Egg, Long>{

	Optional<Egg> findByMerchantId(Long merchantId);

	boolean existsByMerchantId(long merchantId);

	 public List<Egg> findAll();
		

}
