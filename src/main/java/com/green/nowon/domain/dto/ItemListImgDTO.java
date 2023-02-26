package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.ItemListImg;

import lombok.Getter;

@Getter
public class ItemListImgDTO {
	
	private long no;
	private String orgName;
	private String newName;
	private String url;
	private boolean defImg;
	
	private String imgUrl; //편의필드

	public ItemListImgDTO(ItemListImg e) {
		this.no = e.getNo();
		this.orgName = e.getOrgName();
		this.newName = e.getNewName();
		this.url = e.getUrl();
		this.defImg = e.isDefImg();
		this.imgUrl = url+newName;
	}
	
	

}
