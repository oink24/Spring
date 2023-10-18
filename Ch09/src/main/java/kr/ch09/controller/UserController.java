package kr.ch09.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch09.entity.UserEntity;
import kr.ch09.service.UserService;

@Log4j2
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/login")
	public String login(Model model, String success) {
		model.addAttribute("success", success);
		return "/user/login";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	@PostMapping("/user/register")
	public String register(UserEntity user) {

		log.info("회원가입 role : " + user.getRole());
		service.insertUser(user);
		return "/user/register";
	}
	
	@GetMapping("/user/loginSuccess")
	public String loginSuccess() {
		return "/user/loginSuccess";
	}
}
