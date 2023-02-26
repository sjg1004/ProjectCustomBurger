package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.CartItemListDTO;
import com.green.nowon.domain.dto.CartItemSaveDTO;
import com.green.nowon.domain.entity.CartEntity;
import com.green.nowon.domain.entity.CartEntityRepository;
import com.green.nowon.domain.entity.CartItemEntity;
import com.green.nowon.domain.entity.CartItemEntityRepository;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.service.CartService;

@Service
public class CartServiceProcess implements CartService {

	@Autowired
	private CartEntityRepository cartRepo;
	
	@Autowired
	private CartItemEntityRepository cartItemRepo;
	
	@Autowired
	private MemberEntityRepository memberRepo;
	
	@Autowired
	private ItemEntityRepository itemRepo;

	@Transactional
	@Override
	public void cartItem(Model model, String email) {
		model.addAttribute("list", cartItemRepo.findAllByCartMemberEmail(email)
				.stream()
				.map(CartItemListDTO::new)
				.collect(Collectors.toList()));
		
	}
	

	@Transactional
	@Override
	public void save(CartItemSaveDTO dto, String email) {
		//처음저장시 카트 존재하지않음
		CartEntity cart = cartRepo.findByMemberEmail(email)
				.orElseGet(()->cartRepo.save(CartEntity.builder()
						.member(memberRepo.findByEmail(email).orElseThrow())
						.build()));
		
		//존재하지 않으면 카트생성됨
		cartItemRepo.findByCartNoAndItemIno(cart.getNo(), dto.getItemNo())
				.ifPresentOrElse(
						//존재하면 구매수량 증가
						e->e.updateCount(dto.getCount()), 
						//존재하지 않으면 저장
						()->cartItemRepo.save(CartItemEntity.builder()
								.cart(cart)
								.item(itemRepo.findById(dto.getItemNo()).get())
								.count(dto.getCount())
								.build())
				);
		
	}

}