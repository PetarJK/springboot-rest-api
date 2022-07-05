package com.petarjk.springboot.restapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petarjk.springboot.restapi.entity.User;

public interface UserService {

	public Page<User> listAllByPage(Pageable pageable);

	public User findById(int userId);

	public void save(User user);

	public void deleteById(int userId);

	public List<User> search(String query);

}
