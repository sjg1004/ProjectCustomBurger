package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.CategoryItemEntity;
import com.green.nowon.domain.entity.ItemEntity;

import lombok.Data;

@Data
public class ItemListDTO {
	
	private long no;
	private String title;
	private int price;
	private int stock;
	
	private int sPrice;
	private int dPrice;
	
	private String defImgUrl;
	
	public ItemListDTO(ItemEntity e) {
		this.no = e.getIno();
		this.title = e.getTitle();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
		sPrice=0;
		dPrice=3000;
		
		
	}
	public ItemListDTO(CategoryItemEntity cie) {
		this(cie.getItem());
	}
}