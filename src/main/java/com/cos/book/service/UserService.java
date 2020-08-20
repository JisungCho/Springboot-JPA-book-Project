package com.cos.book.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.book.model.RoleType;
import com.cos.book.model.User;
import com.cos.book.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void save(User user) {
		String rawPWD = user.getPassword();
		String newPWD = encoder.encode(rawPWD);
		
		user.setPassword(newPWD);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
}
