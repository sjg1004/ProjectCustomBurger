package com.green.nowon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.CategoryEntity;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.service.CategoryService;

@Service
public class CategoryServiceProcess implements CategoryService {

	@Autowired
	private CategoryEntityRepository repo;
	
	
	@Override
	public void save(String name) {
		CategoryEntity cate=repo.findByParentNoNullAndName(name).orElse(repo.save(CategoryEntity.builder().name(name).build()));
		//CategoryEntity cate=repo.save(CategoryEntity.builder().name(name).build());
	}

	@Override
	public boolean regCategory(String text) {
		Optional<CategoryEntity> result= repo.findByParentNoNullAndName(text);
		if(result.isEmpty())
			return true;
		return false;
	
	}

	@Override
	public void firstCategory(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("list", repo.findByParentNoIsNullOrderByNameAsc());
	}

	@Override
	public void listCategory(Long parentNo, Model model) {
		if(parentNo.intValue()==0)parentNo=null;
		model.addAttribute("list", repo.findByParentNoOrderByNameAsc(parentNo));
		
	}

	@Override
	public void fistCategoryList(Long parentNo,Model model) {
		/* if(parentNo.intValue()==0)parentNo=null; */
		model.addAttribute("list", repo.findByParentNoIsNullOrderByNameAsc());
		
	}

}
