package com.petarjk.springboot.restapi.rest;

import java.util.List;

import javax.validation.Valid;

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

import com.petarjk.springboot.restapi.dto.UserDTO;
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
	public Page<UserDTO> findPaginated(Pageable pageable) {

		Page<UserDTO> userDTOS = userService.listAllByPage(pageable);

		return userDTOS;
	}

	@GetMapping("/users/{userId}")
	public UserDTO findById(@PathVariable int userId) {

		UserDTO userDTO = userService.findById(userId);

		return userDTO;
	}

	@GetMapping("/users/search")
	public ResponseEntity<List<UserDTO>> search(@RequestParam("query") String query) {

		return ResponseEntity.ok(userService.search(query));
	}

	@PostMapping("/users")
	public UserDTO save(@Valid @RequestBody UserDTO userDTO) {

		UserDTO savedUserDTO = userService.save(userDTO);

		return savedUserDTO;
	}

	@PutMapping("/users")
	public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {

		UserDTO updatedUserDTO = userService.update(userDTO);

		return updatedUserDTO;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {

		userService.deleteById(userId);

		return DELETE_USER_MESSAGE + userId;
	}

}
