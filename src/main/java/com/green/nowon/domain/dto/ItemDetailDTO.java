package com.green.nowon.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.green.nowon.domain.entity.CategoryItemEntity;
import com.green.nowon.domain.entity.ItemEntity;

import lombok.Data;

@Data
public class ItemDetailDTO {
	
	private long no;
	private String title;
	private String content;
	private int price;
	private int stock;
	
	private String defImgUrl;
	
	private List<ItemListImgDTO> imgs;

	public ItemDetailDTO(ItemEntity e) {
		this.no = e.getIno();
		this.title = e.getTitle();
		this.content = e.getContent();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
		imgs=e.getImgs().stream().map(ItemListImgDTO::new).collect(Collectors.toList());
	}
	
	public ItemDetailDTO(CategoryItemEntity cie) {
		this(cie.getItem());
	}
	
	

}
