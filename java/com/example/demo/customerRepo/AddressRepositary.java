package com.example.demo.customerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.customerEntity.Address;

@Repository
public interface AddressRepositary extends JpaRepository<Address, Long>{
	@Query(value = "SELECT * from testdb.address a where a.address_id=(SELECT distinct delivery_address_id from testdb.merchant_request mr where mr.cart_id= (select cart_id from testdb.customer_order co where co.custorder_id=:orderId))", nativeQuery = true)
	Address findAddressByOrderId(@Param("orderId") int orderId);


	  @Query(value = "SELECT * from testdb.address a where a.address_id in (SELECT distinct delivery_address_id from testdb.merchant_request mr where mr.merchant_id=:merchantId))", nativeQuery = true)
	  List<Address> findDeliveryAddressBymerchantId(@Param("merchantId") int merchantId);

}