package com.green.nowon.service;

import org.springframework.ui.Model;

public interface CategoryService {

	void save(String name);

	boolean regCategory(String text);

	void firstCategory(Model model);

	void listCategory(Long parentNo, Model model);

	void fistCategoryList(Long parentNo,Model model);

}
