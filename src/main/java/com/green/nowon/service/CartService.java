package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.CartItemSaveDTO;

public interface CartService {

	void cartItem(Model model, String email);

	void save(CartItemSaveDTO dto, String email);

}
