package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.DeliveryInfoDTO;
import com.green.nowon.domain.dto.DeliveryListDTO;
import com.green.nowon.domain.dto.OrderItemDTO;
import com.green.nowon.domain.dto.OrderItemListDTO;
import com.green.nowon.domain.entity.DeliveryEntityRepository;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.service.OrderService;

@Service
public class OrderServiceProcess implements OrderService {
	
	@Autowired
	private ItemEntityRepository ieRepo;
	
	@Autowired
	private DeliveryEntityRepository deRepo;
	
	@Autowired
	private MemberEntityRepository meRepo;

	@Transactional
	@Override
	public void orderItem(OrderItemDTO dto, Model model) {
		model.addAttribute("list", ieRepo.findById(dto.getItemNo())
				.map(OrderItemListDTO::new)
				.get()
				.count(dto.getCount()));	
		
		
	}

	@Override
	public long deliveryInfoSave(DeliveryInfoDTO dto, String email) {
		return deRepo.save(dto.toEntity()
				.baseAddr(deRepo.countByMember_email(email)==0?true:false)//배송지정보가 없으면 base=true
				.deMember(meRepo.findByEmail(email).orElseThrow()))
				.getNo();//배송지 정보등록 완료후 pk값리턴
	}

	@Override
	public void deliveries(String email, Model model) {
		model.addAttribute("list", deRepo.findAllByMember_email(email).stream()
				.map(DeliveryListDTO::new)
				.collect(Collectors.toList()));
		
	}

	@Override
	public void baseOfdeliveries(String email, Model model) {
		model.addAttribute("base", deRepo.findByBaseAndMember_email(true, email)
				.map(DeliveryListDTO::new)
				.orElseThrow()
				);
		
	}


}
