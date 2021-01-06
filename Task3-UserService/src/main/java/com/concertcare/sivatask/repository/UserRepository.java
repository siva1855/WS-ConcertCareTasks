package com.concertcare.sivatask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concertcare.sivatask.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserId(Integer userId);
}
