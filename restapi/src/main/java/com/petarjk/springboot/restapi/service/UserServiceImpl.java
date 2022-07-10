package com.petarjk.springboot.restapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petarjk.springboot.restapi.dao.UserRepository;
import com.petarjk.springboot.restapi.dto.UserDTO;
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
	public Page<UserDTO> listAllByPage(Pageable pageable) {

		Page<User> userPage = userRepository.findAll(pageable);

		Page<UserDTO> dtoPage = userPage.map(user -> new UserDTO(user));

		return dtoPage;
	}

	@Override
	public UserDTO findById(int userId) {

		Optional<User> result = userRepository.findById(userId);

		User user = null;

		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new UserNotFoundException(USER_ID_NOT_FOUND_MESSAGE + userId);
		}

		return new UserDTO(user);
	}

	@Override
	public List<UserDTO> search(String query) {

		return userRepository.search(query).stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public void save(UserDTO userDTO) {

		User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDateOfBirth(),
				userDTO.getPhoneNumber(), userDTO.getEmail());

		userRepository.save(user);
	}

	@Override
	public void update(UserDTO userDTO) {

		User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDateOfBirth(),
				userDTO.getPhoneNumber(), userDTO.getEmail());

		user.setId(userDTO.getId());

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

}
