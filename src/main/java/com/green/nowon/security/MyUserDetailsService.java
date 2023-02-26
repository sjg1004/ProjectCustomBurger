package com.green.nowon.security;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberEntityRepository repo;

	
	/*
	 * @Override public MyUserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { MemberEntity
	 * entity=repo.findByEmail(username).orElseThrow(()->new
	 * UsernameNotFoundException("존재하지 않는 이메일"));
	 * 
	 * Set<SimpleGrantedAuthority> authorities=entity.getRoles() .stream()
	 * .map(myRole->new SimpleGrantedAuthority(myRole.getRole()))
	 * .collect(Collectors.toSet()); return new MyUserDetails(username,
	 * entity.getPass(), authorities); }
	 */
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new MyUserDetails(
				repo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("존재하지 않은 이메일")));
	}

}
