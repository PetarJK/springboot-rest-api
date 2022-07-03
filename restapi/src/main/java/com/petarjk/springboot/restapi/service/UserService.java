package com.petarjk.springboot.restapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petarjk.springboot.restapi.entity.User;

public interface UserService {

	public Page<User> listAllByPage(Pageable pageable);

	public User findById(int theId);

	public void save(User theUser);

	public void deleteById(int theId);

	public List<User> search(String query);

}
