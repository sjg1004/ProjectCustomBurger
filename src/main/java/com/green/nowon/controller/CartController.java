package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.CartItemSaveDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.CartService;


@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@GetMapping("/member/cart")
	public String cartItem(Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) {
		
		service.cartItem(model, myUserDetails.getEmail());
		return "item/cart-item";
	}
	
	//인증이후 처리되는 url
	@ResponseBody
	@PostMapping("/member/cart")
	public void cartItems(CartItemSaveDTO dto, @AuthenticationPrincipal MyUserDetails myUserDetails) {
		
		service.save(dto, myUserDetails.getEmail());
	}
	
}
