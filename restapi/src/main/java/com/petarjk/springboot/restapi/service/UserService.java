package com.petarjk.springboot.restapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petarjk.springboot.restapi.dto.UserDTO;

public interface UserService {

	public Page<UserDTO> listAllByPage(Pageable pageable);

	public UserDTO findById(int userId);

	public List<UserDTO> search(String query);

	public UserDTO save(UserDTO userDTO);

	public UserDTO update(UserDTO userDTO);

	public void deleteById(int userId);

}
