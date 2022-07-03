package com.petarjk.springboot.restapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petarjk.springboot.restapi.entity.User;

public interface UserService {

	Page<User> listAllByPage(Pageable pageable);

}
