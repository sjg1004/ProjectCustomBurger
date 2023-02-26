package com.green.nowon.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.ItemInsertDTO;
import com.green.nowon.domain.entity.ItemEntity;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.service.ItemService;


@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping("/admin/goods") //상품등록
	public String item() {
		return "admin/goods";
	}
	
	@PostMapping("/admin/goods") //상품등록
	public String item(ItemInsertDTO dto, Model model) {
		service.save(dto);
		return "admin/goods";
	}
	
	@ResponseBody
	@PostMapping("/admin/temp-upload")
	public  Map<String,String> tempUpload(MultipartFile goodsimg) {
		return service.fileTempUpload(goodsimg);
	}
	
	@GetMapping("/item/menu-list")
	public String menuList() {
		
		return "item/menu-list";
	}
	
	@GetMapping("/common/category/{no}/goods")
	public String goodsOfCategory(@PathVariable long no, Model model) {
		service.goodsOfCategory(no, model);
		return "item/list";
	}
		
	@GetMapping("/item/detail/{no}") //상품디테일
	public String detail(@PathVariable long no, Model model) {
		service.detail(no, model);
		return "item/detail";
	}

	
}
