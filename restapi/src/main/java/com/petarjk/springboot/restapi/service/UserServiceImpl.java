package com.petarjk.springboot.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petarjk.springboot.restapi.dao.UserRepository;
import com.petarjk.springboot.restapi.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> listAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

}
