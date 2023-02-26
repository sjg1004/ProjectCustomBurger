package com.green.nowon.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.nowon.domain.entity.ItemEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemListDTO {
	
	private ItemListDTO item;
	private int count;
	
	private int totPrice;
	
	public OrderItemListDTO count(int count) {
		this.count=count;
		this.totPrice=count*item.getPrice();
		return this;
	}
	
	public OrderItemListDTO(ItemEntity ie) {
		this.item=new ItemListDTO(ie);
	}

}
