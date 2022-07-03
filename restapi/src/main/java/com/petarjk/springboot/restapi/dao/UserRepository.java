package com.petarjk.springboot.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.petarjk.springboot.restapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.firstName LIKE CONCAT('%',:query, '%')"
			+ " OR u.lastName LIKE CONCAT('%',:query, '%')")
	public List<User> search(String query);
}
