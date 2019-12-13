package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
