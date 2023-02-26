package com.green.nowon.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.nowon.domain.entity.ItemEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
	
	private long itemNo;
	private int count;


}
