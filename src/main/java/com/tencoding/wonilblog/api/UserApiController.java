package com.tencoding.wonilblog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.wonilblog.dto.ResponseDto;
import com.tencoding.wonilblog.model.User;
import com.tencoding.wonilblog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(User user){
		int result = userService.saveUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession httpSession){
//		System.out.println("login 호출됨");
//		// 서비스한테 요청
//		User principal = userService.login(user);
//		// 접근 주체가 정상적으로 username, password 확인! (세션이라는 거대한 메모리에 저장)
//		if(principal != null) {
//			httpSession.setAttribute("principal", principal);
//			System.out.println("세션 정보가 저장되었습니다");
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}
