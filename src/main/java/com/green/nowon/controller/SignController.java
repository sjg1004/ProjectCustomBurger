package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.MemberInsertDTO;
import com.green.nowon.service.SignService;

@Controller
public class SignController {
	
	@Autowired
	private SignService service;

	@GetMapping("/signin")
		public String signin() {
		
		return "/sign/signin";
	}
	
	@GetMapping("/signup")
		public String signup() {
		return "/sign/signup";
	}
	
	@GetMapping("/signup2")
		public String signup2() {
		return "/sign/signup2";
	}
	
	@PostMapping("/signup2")
		public String signup2(MemberInsertDTO dto) {
		service.save(dto);
		return "/sign/signin";
	}
	@ResponseBody
	@GetMapping("/signin-check")
	public boolean loginCheck(Authentication auth) {
		//로그인했을때는 인증정보확인가능
		//비로그인시 는 null
		return auth==null? false:true;
	}
	
	
}
