package com.green.nowon.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long>{

	Optional<CategoryEntity> findByParentNoNullAndName(String name);


	List<CategoryEntity> findByParentNoIsNullOrderByNameAsc();


	List<CategoryEntity> findByParentNoOrderByNameAsc(Long parentNo);

	

}
