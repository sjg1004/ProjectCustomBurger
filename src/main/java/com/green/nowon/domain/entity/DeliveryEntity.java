package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "delivery")
@Entity
public class DeliveryEntity {
	
	@Id
	private long no;
	
	private boolean base;
	
	@Column(unique = true)
	private String addressName;
	private String receiverName;
	private String phoneNumber;
	
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	
	@JoinColumn
	@ManyToOne
	private MemberEntity member;
	
	public DeliveryEntity deMember(MemberEntity member) {
		this.member=member;
		return this;
	}

	public DeliveryEntity baseAddr(boolean base) {
		this.base=base;
		return this;
	}
	
}
