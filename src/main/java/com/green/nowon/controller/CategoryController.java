package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.service.CategoryService;
import com.green.nowon.service.impl.CategoryServiceProcess;

import lombok.Getter;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/admin/reg-category")
	public String category() {
		return "/admin/reg-category";
	}
	
	@ResponseBody
	@GetMapping("/admin/reg-category/{text}")
	public boolean regCategory(@PathVariable String text) {
		
		return service.regCategory(text);
	}
	//admin 상품등록 페이지
	@GetMapping("/admin/category")
	public String fistCategory(Model model) {
		service.firstCategory(model);
		return "/admin/category";
	}
	
	@GetMapping("/menu-list2/{parentNo}")
	public String fistCategoryList(@PathVariable long parentNo, Model model) {
		service.fistCategoryList(parentNo, model);
		return "/admin/ul-category2";
	}
	//리스트 페이지로 뿌려주기
	@GetMapping("/menu-list/{parentNo}")
	public String listCategory(@PathVariable long parentNo, Model model) {
		service.listCategory(parentNo, model);
		return "/admin/ul-category";
	}
	
	@PostMapping("/admin/reg-category")
	public String category(String name) {
		service.save(name);
		return "/admin/reg-category";
		
	}
}
