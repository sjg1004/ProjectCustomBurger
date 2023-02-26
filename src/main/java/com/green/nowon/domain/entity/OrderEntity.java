package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "orders")
@Entity
public class OrderEntity extends BaseDateEntity{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long no;//주문번호

	@Column
	private LocalDateTime orderDate;//주문일
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;//주문현황
	
	@JoinColumn
	@ManyToOne
	private MemberEntity member;//MemberEntity의 FK
	
}
