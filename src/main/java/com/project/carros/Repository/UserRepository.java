package com.project.carros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.carros.Model.User;
 
public interface UserRepository extends JpaRepository<User, Long>{
  
	 User findByLogin(String login);
}
