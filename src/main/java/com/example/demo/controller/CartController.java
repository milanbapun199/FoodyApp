package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartRequest;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repo.CartRepositary;
import com.example.demo.repo.ProductRepositary;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

	@Autowired
	private CartRepositary cartRepositary;

	@Autowired
	private ProductRepositary productRepositary;

	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody CartRequest cartRequest) {
		return cartRepositary.save(cartRequest.getCart());
	}
	
	@GetMapping("/getCartId") 
	public String getCartId(@RequestParam("customerId") String customerId) {
		 Cart existing_cart=cartRepositary.findByCustomerIdAndCartStatus(Integer.parseInt(customerId),"unpaid");
		 if(existing_cart!=null) {
			 return Integer.toString(existing_cart.getCartId());
		 }
		return "no_cart_id";
	}
	
	  @PutMapping("/cartUpdate") public Cart updateCart(@RequestBody CartRequest cartRequest) {
		  Cart updateCart=cartRequest.getCart();
		  List<Product> products = cartRequest.getCart().getProducts();
		  System.out.println(products);
		  List<Product> findAllProducts = productRepositary.findAllBycartId(updateCart.getCartId());
		  findAllProducts.addAll(products);
		 updateCart.setProducts(findAllProducts);
			 System.out.println(updateCart);
//			 return null;
		  return cartRepositary.save(updateCart);
	  }
	 

	@GetMapping("/findAllOrders")
	public List<Cart> findAllOrders() {
		return cartRepositary.findAll();
	}
	
	@GetMapping("/getCartDetails") 
	public Cart getCartDetails(@RequestParam("customerId") String customerId) {
		 Cart existing_cart=cartRepositary.findByCustomerIdAndCartStatus(Integer.parseInt(customerId),"unpaid");
		 System.out.println(existing_cart);
		 if(existing_cart == null) {
		 }
		return existing_cart;
	}
	
	@GetMapping("/getCartProductCount") 
	// THis API is ment for displaying the count of product.
	public int getCartProductCount(@RequestParam("customerId") String customerId) {
		 Cart existing_cart=cartRepositary.findByCustomerIdAndCartStatus(Integer.parseInt(customerId),"unpaid");
		 List<Product> products = existing_cart.getProducts();
		return products.size();
	}
	
	@GetMapping("/deleteProduct") 
	public int deleteProduct(@RequestParam("productId") String productId) {
		int deleteByPid = cartRepositary.deleteByPid(Integer.parseInt(productId));
		return deleteByPid;
	}

}
