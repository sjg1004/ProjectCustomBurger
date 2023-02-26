package com.green.nowon.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.MemberEntity;

import lombok.Data;
import lombok.Setter;

@Data
public class MemberInsertDTO {
	
	private String email;
	private String pass;
	private String name;
	private String nickName;
	private String birth;
	private String tel;
	
	//편의메서드
	public MemberEntity toEntity(PasswordEncoder pe) {
		return MemberEntity.builder()
				.email(email).pass(pe.encode(pass)).name(name).nickName(nickName).birth(birth).tel(tel)
				.build();
	}
}
