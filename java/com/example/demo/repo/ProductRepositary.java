package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepositary extends JpaRepository<Product, Integer>{

	@Query(value = "SELECT * FROM testdb.product p WHERE p.cart_id = :cartId", nativeQuery = true)
	List<Product> findAllBycartId(@Param("cartId") int cartId);

	@Query(value = "SELECT * FROM testdb.product p WHERE p.cart_id = (select cart_id from testdb.customer_order c where c.custorder_id= :orderId)", nativeQuery = true)
	List<Product> findAllProductByOrderId(@Param("orderId") int orderId);
}
