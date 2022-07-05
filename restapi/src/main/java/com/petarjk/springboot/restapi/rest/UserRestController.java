package com.petarjk.springboot.restapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petarjk.springboot.restapi.entity.User;
import com.petarjk.springboot.restapi.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private final String DELETE_USER_MESSAGE = "Deleted user with id - ";

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

	@GetMapping("/users/{userId}")
	public User findById(@PathVariable int userId) {

		User user = userService.findById(userId);

		return user;
	}

	@GetMapping("/users/search")
	public ResponseEntity<List<User>> search(@RequestParam("query") String query) {

		return ResponseEntity.ok(userService.search(query));
	}

	@PostMapping("/users")
	public User save(@RequestBody User user) {

		user.setId(0);

		userService.save(user);

		return user;
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {

		userService.save(user);

		return user;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {

		userService.deleteById(userId);

		return DELETE_USER_MESSAGE + userId;
	}

}
