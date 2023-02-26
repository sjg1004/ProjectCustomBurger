package com.green.nowon.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.green.nowon.domain.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
public class MyUserDetails extends User {

	private String email;
	private String name;
	private String nickName;

	public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	public MyUserDetails(MemberEntity entity) {
		this(entity.getEmail(), entity.getPass(), entity.getRoles()
				.stream()
				.map(myRole->new SimpleGrantedAuthority(myRole.getRole()))
				.collect(Collectors.toSet()));
		
		this.email=entity.getEmail();
		this.name=entity.getName();
		this.nickName=entity.getNickName();
	}

}
