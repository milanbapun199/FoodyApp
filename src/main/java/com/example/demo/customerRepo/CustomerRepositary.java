package com.example.demo.customerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.customerEntity.Customer;

public interface CustomerRepositary extends JpaRepository<Customer, Long>{

	public Customer findByMobNoOrUserName(String _customerMobNo, String _customerUserName);

	public Customer findByMobNo(String _customerMobNo);

	public Customer findByUserName(String _customerUserName);

	public Customer findByuserName(String userName);
	
	@Query(value = "select * from testdb.customer c where c.customer_id in (select distinct customer_id from testdb.merchant_request mr where mr.merchant_id=:merchantId)", nativeQuery = true)
	  List<Customer> getCustomerInfo(@Param("merchantId") int merchantId);

}
