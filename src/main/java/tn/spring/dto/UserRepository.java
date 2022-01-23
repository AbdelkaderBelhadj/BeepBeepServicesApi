package tn.spring.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.spring.entites.User;



public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	

}
