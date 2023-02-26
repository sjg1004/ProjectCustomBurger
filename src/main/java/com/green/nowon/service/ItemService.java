package com.green.nowon.service;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.ItemInsertDTO;

public interface ItemService {

	void save(ItemInsertDTO dto);

	Map<String, String> fileTempUpload(MultipartFile goodsimg);

	void goodsOfCategory(long no, Model model);

	void detail(long no, Model model);
	
}
