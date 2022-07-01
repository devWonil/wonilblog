package com.tencoding.wonilblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tencoding.wonilblog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// spring JPA 네이밍 전략
	// SELECT * FROM user WHERE username = ?1 AND password = ?2;
	User findByUsernameAndPassword(String username, String password);
}
