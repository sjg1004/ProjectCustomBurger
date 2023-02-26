package com.green.nowon.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryEntityRepository extends JpaRepository<DeliveryEntity, Long>{

	long countByMember_email(String email);

	List<DeliveryEntity> findAllByMember_email(String email);

	Optional<DeliveryEntity> findByBaseAndMember_email(boolean base, String email);
	


}
