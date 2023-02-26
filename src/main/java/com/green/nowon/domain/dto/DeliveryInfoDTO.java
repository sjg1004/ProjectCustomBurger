package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.DeliveryEntity;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class DeliveryInfoDTO {
	
	private long no;
	
	private boolean base;
	private String addressName;
	private String receiverName;
	private String phoneNumber;
	
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	
	public DeliveryEntity toEntity() {
		return DeliveryEntity.builder()
				.addressName(addressName)
				.receiverName(receiverName)
				.phoneNumber(phoneNumber)
				.postcode(postcode)
				.roadAddress(roadAddress)
				.jibunAddress(jibunAddress)
				.detailAddress(detailAddress)
				.extraAddress(extraAddress)
				.build();
	}
	
}
