package com.tencoding.wonilblog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tencoding.wonilblog.model.RoleType;
import com.tencoding.wonilblog.model.User;
import com.tencoding.wonilblog.repository.UserRepository;

public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dummy/users")
	public List<User> 전체사용자검색(){
		return userRepository.findAll();
	}
	
	// 페이징 처리
	@GetMapping("/dummy/user")
	public Page<User> pageList(@PageableDefault(size =10, sort="id", direction = Direction.DESC)Pageable pageable){
		Page<User> pageUser = userRepository.findAll(pageable);
		return pageUser;
	}
	
	@PostMapping("/dummy/join")
	public String join(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException(id + " 해당 유저는 없는 사용자입니다");
		});
		
		return user;
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User reqUser) {
		
		// select 해와서 추가적인 처리
		User userEntity = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException(id + " 해당 유저는 없는 사용자입니다");
		});
		
		// --> DB 저장 // username 없다
		userEntity.setPassword(reqUser.getPassword());
		userEntity.setEmail(reqUser.getEmail());
		
		return null;
	}
	
	@DeleteMapping("dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return "해당 유저는 없습니다";
		}
		return id + "는 삭제되었습니다";
	}
	
	
}
