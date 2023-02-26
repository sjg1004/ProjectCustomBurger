package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.CartItemEntity;

import lombok.Getter;

@Getter
public class CartItemListDTO {
	
	private long no; //cariItem_no
	private int count; //구매수량
	
	private int dPrice; //배송비
	
	private ItemListDTO item;

	public CartItemListDTO(CartItemEntity e) {
		this.no = e.getNo();
		this.count = e.getCount();
		this.dPrice = 3000;
		this.item = new ItemListDTO(e.getItem());
	}
	
	

}
