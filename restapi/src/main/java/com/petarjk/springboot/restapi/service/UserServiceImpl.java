package com.petarjk.springboot.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petarjk.springboot.restapi.dao.UserRepository;
import com.petarjk.springboot.restapi.entity.User;
import com.petarjk.springboot.restapi.rest.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private final String USER_ID_NOT_FOUND_MESSAGE = "User id not found - ";

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> listAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User findById(int userId) {

		Optional<User> result = userRepository.findById(userId);

		User user = null;

		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new UserNotFoundException(USER_ID_NOT_FOUND_MESSAGE + userId);
		}

		return user;
	}

	@Override
	public void save(User user) {

		userRepository.save(user);
	}

	@Override
	public void deleteById(int userId) {

		Optional<User> result = userRepository.findById(userId);

		if (result.isEmpty()) {
			throw new UserNotFoundException(USER_ID_NOT_FOUND_MESSAGE + userId);
		}

		userRepository.deleteById(userId);
	}

	@Override
	public List<User> search(String query) {

		return userRepository.search(query);
	}

}
