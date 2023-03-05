package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customerEntity.Address;
import com.example.demo.customerEntity.Customer;
import com.example.demo.customerRepo.AddressRepositary;
import com.example.demo.customerRepo.CustomerRepositary;
import com.example.demo.entity.Cart;
import com.example.demo.entity.MerchantRequest;
import com.example.demo.entity.CustomerOrder;
import com.example.demo.entity.Product;
import com.example.demo.repo.CartRepositary;
import com.example.demo.repo.MerchantRequestRepositary;
import com.example.demo.repo.OrderRepositary;

@Service
public class MerchantRequestServiceImpl implements MerchantRequestService{
	
	@Autowired
	MerchantRequestRepositary merchantRequestRepositary;
	
	@Autowired
	CartRepositary cartRepositary;
	
	@Autowired
	OrderRepositary orderRepositary;
	
	@Autowired
	AddressRepositary addressRepositary;
	
	@Autowired
	CustomerRepositary customerRepositary;

	@Override
	public String buyProducts(String cartId, int deliveryAddressId) {
		//here we get the cart by passing cartId
		Cart cart = cartRepositary.findById(Integer.parseInt(cartId)).orElse(null);
		List<Product> products = cart.getProducts();
		List<MerchantRequest> allMerchantRequests= new ArrayList<>();
		//Here  getting all products of different merchant and put into a List
		for(Product p: products) {
			MerchantRequest merchantRequest=new MerchantRequest();
			merchantRequest.setMerchantId(p.getMerchantId());
			merchantRequest.setCustomerId(cart.getCustomerId());
			merchantRequest.setCartId(cart.getCartId());
			merchantRequest.setpId(p.getPid());
			merchantRequest.setProductStatus("unpaid");
			merchantRequest.setDeliveryAddressId(deliveryAddressId);
			allMerchantRequests.add(merchantRequest);
		}
		//save all record into merchant_request table
		List<MerchantRequest> merchantRequestData = merchantRequestRepositary.saveAll(allMerchantRequests);
		//save order data into order table
		CustomerOrder order=new CustomerOrder();
		order.setCartId(Integer.parseInt(cartId));
		order.setOrderStatus("received");
		CustomerOrder customerOrder = orderRepositary.save(order);
		cartRepositary.updateCartStatus(Integer.parseInt(cartId));
		return Integer.toString(customerOrder.getCustorderId());
	}

	@Override
	public void getMerchantRequest(int merchantId) {
		List<Customer> customerInfo = customerRepositary.getCustomerInfo(merchantId);
//		System.out.println(customerInfo);
//		List<Address> findDeliveryAddressBymerchantId = addressRepositary.findDeliveryAddressBymerchantId(merchantId);
//		System.out.println(findDeliveryAddressBymerchantId);
		List<Cart> cartInfo = cartRepositary.getProductInfo(merchantId);
		for(Cart c: cartInfo) {
			List<Product> products = c.getProducts();
			for(Product p: products) {
				if(p.getMerchantId() == merchantId) {
//					System.out.println(p);
				}
			}
		}
		System.out.println(cartInfo);
		
	}
}
