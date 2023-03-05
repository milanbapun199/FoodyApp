package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.customerEntity.Customer;
import com.example.demo.entity.Cart;

public interface CartRepositary extends JpaRepository<Cart, Integer>{
	
	public Cart findByCustomerIdAndCartStatus(int customerId, String cartStatus);

	public Cart findByCustomerId(int customerId);
	
	@Transactional
	@Modifying
	@Query("DELETE Product p WHERE p.pid = ?1")
	public int deleteByPid(int productId);
	
	@Transactional
	@Modifying
	 @Query(value="update testdb.cart c set cart_status=\"pending\"  where c.cart_id= :cartId", nativeQuery=true)
	public void updateCartStatus(int cartId);
	
	@Query(value = "select * from testdb.cart c where c.cart_id in (select distinct cart_id from merchant_request mr where mr.merchant_id=:merchantId);", nativeQuery = true)
	  List<Cart> getProductInfo(@Param("merchantId") int merchantId);

}
