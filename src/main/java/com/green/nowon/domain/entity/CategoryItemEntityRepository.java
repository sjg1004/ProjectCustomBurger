package com.green.nowon.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemEntityRepository extends JpaRepository<CategoryItemEntity, Long>{

	List<CategoryItemEntity> findAllByCategoryNo(long cateNo);

}
