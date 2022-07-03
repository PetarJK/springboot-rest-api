package com.petarjk.springboot.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petarjk.springboot.restapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
