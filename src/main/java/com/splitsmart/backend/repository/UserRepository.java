package com.splitsmart.backend.repository;

import com.splitsmart.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> { // This repository works with User entities, and the primary key type is Integer.

}
