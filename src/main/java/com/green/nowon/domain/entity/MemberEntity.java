package com.green.nowon.domain.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_mem", sequenceName = "seq_mem", initialValue = 1, allocationSize = 1)
@Table(name = "burger_member")
@Entity
public class MemberEntity extends BaseDateEntity{
	
	@Id
	@GeneratedValue(generator = "gen_mem", strategy = GenerationType.SEQUENCE)
	private long mno;
	
	@Column(nullable = true, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String pass;
	
	
	private String name;
	
	private String nickName; //사용여부 검토중
	
	private String birth; //사용여부 검토중
	
	@Column(nullable = false) 
	private String tel; //사용여부 검토중
	
	
	
	@Builder.Default
	@CollectionTable(name = "my_role")
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<MyRole> roles=new HashSet<>();
	public MemberEntity addRole(MyRole role) {
		roles.add(role);
		return this;
	}
}
