package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.MemberInsertDTO;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.SignService;

@Service
public class SignServiceProcess implements SignService{
	
	@Autowired
	private MemberEntityRepository repo;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public void save(MemberInsertDTO dto) {
		repo.save(dto.toEntity(pe)
				.addRole(MyRole.USER));
		
	}

	
}
