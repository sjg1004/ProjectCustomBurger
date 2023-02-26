package com.green.nowon.domain.entity;

import javax.persistence.Entity;
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
@Table(name = "burger_cart_item")
@Entity
public class CartItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private int count;//구매수량
	
	@JoinColumn
	@ManyToOne
	private CartEntity cart;
	
	@JoinColumn
	@ManyToOne
	private ItemEntity item;
	
	public CartItemEntity updateCount(int count) {
		this.count += count;
		return this;
	}
	
}
