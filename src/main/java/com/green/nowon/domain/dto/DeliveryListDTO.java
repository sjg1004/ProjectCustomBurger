package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.DeliveryEntity;

import lombok.Getter;

@Getter
public class DeliveryListDTO {
	
	private long no;
	
	private boolean base;
	private String addressName;
	private String receiverName;
	private String phoneNumber;
	
	private String postcode;
	private String roadAddress;
	private String detailAddress;
	private String extraAddress;
	
	public DeliveryListDTO(DeliveryEntity de) {
		this.base = de.isBase();
		this.addressName = de.getAddressName();
		this.receiverName = de.getReceiverName();
		this.phoneNumber = de.getPhoneNumber();
		this.postcode = de.getPostcode();
		this.roadAddress = de.getRoadAddress();
		this.detailAddress = de.getDetailAddress();
		this.extraAddress = de.getExtraAddress();
	}
	
	
	
}
