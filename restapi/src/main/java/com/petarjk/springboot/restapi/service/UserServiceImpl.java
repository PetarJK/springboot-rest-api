package com.petarjk.springboot.restapi.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User findById(int theId) {

		Optional<User> result = userRepository.findById(theId);

		User theUser = null;

		if (result.isPresent()) {
			theUser = result.get();
		} else {
			throw new RuntimeException("User with id - " + theId + " not found.");
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {

		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {

		userRepository.deleteById(theId);
	}

	@Override
	public List<User> search(String query) {

		return userRepository.search(query);
	}

}
