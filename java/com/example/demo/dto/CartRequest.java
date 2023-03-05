package com.example.demo.dto;

import com.example.demo.entity.Cart;

public class CartRequest {

		private Cart cart;
		
		
		public CartRequest() {
			// TODO Auto-generated constructor stub
		}

		public CartRequest(Cart cart) {
			super();
			this.cart = cart;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		@Override
		public String toString() {
			return "CartRequest [cart=" + cart + "]";
		}
		
}
