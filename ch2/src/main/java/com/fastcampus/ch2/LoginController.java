package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception{
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		// 1. id�� pwd�� Ȯ��
		if(!loginChech(id,pwd)) {
			// 2-1. ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� ����", "utf-8");
		}
		// 2-2. id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�
		if(rememberId) {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}else {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		// 1. ��Ű�� ����
//		Cookie cookie = new Cookie("id", id);
		// 2. ���信 ����
//		response.addCookie(cookie);
		// 3. Ȩ���� �̵�
		return "redirect:/";
	}

	private boolean loginChech(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
