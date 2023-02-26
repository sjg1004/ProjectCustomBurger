package com.green.nowon.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.ItemDetailDTO;
import com.green.nowon.domain.dto.ItemInsertDTO;
import com.green.nowon.domain.dto.ItemListDTO;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.domain.entity.CategoryItemEntity;
import com.green.nowon.domain.entity.CategoryItemEntityRepository;
import com.green.nowon.domain.entity.ItemEntity;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.domain.entity.ItemListImgRepository;
import com.green.nowon.service.ItemService;
import com.green.nowon.utils.MyFileUtils;

@Service
public class ItemServiceProcess implements ItemService {
	
	@Value("${file.location.upload}")
	private String locationUpload;
	
	@Value("${file.location.temp}")
	private String locationTemp;
	
	@Autowired
	ItemListImgRepository imgRepo;
	
	@Autowired
	CategoryItemEntityRepository cateItemRepo;
	
	@Autowired
	ItemEntityRepository itemRepo;
	
	@Autowired
	CategoryEntityRepository cateRepo;
	
	@Override
	public void save(ItemInsertDTO dto) {
		
		long[] categoryNo=dto.getCategoryNo();
		dto.toItemEntity();
		
		ItemEntity entity=itemRepo.save(dto.toItemEntity());
		for(long no:categoryNo) {
			cateItemRepo.save(CategoryItemEntity.builder()
					.item(entity)
					.category(cateRepo.findById(no).get())
					.build());
		}
		
		dto.toItemListImgs(entity, locationUpload).forEach(imgRepo::save);
	}
	
	@Override
	public Map<String,String> fileTempUpload(MultipartFile goodsimg) {
		return MyFileUtils.fileUpload(goodsimg, locationTemp);
	}
	
	@Transactional
	@Override
	public void goodsOfCategory(long cateNo, Model model) {
		//카테고리에 해당하는 상품들모두
//		cates=new ArrayList<>();
//		categoryList(cateRepo.findById(cateNo).get());
//		
		model.addAttribute("cate", cateRepo.findById(cateNo).get());
		
		model.addAttribute("list", cateItemRepo.findAllByCategoryNo(cateNo)
				.stream()
				.map(ItemListDTO::new)
				.collect(Collectors.toList()));
	}

	@Transactional
	@Override
	public void detail(long no, Model model) {
		model.addAttribute("detail", itemRepo.findById(no)
				.map(ItemDetailDTO::new)
				.orElseThrow());
		
	}

}
