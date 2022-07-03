package com.petarjk.springboot.restapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petarjk.springboot.restapi.entity.User;
import com.petarjk.springboot.restapi.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public Page<User> findPaginated(Pageable pageable) {

		Page<User> users = userService.listAllByPage(pageable);

		return users;
	}

}
