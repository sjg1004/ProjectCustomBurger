package com.green.nowon.domain.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListImgRepository extends JpaRepository<ItemListImg, Long>{

	List<ItemListImg> findByDefImg(boolean defImg);


}
