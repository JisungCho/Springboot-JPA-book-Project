package com.cos.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.cos.book.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	//SELECT * FROM USER WHERE USERNAME = 1
	Optional<User> findByUsername(String username);
}
