package tn.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.dto.UserRepository;
import tn.spring.dto.VilleRepository;
import tn.spring.entites.Admin;
import tn.spring.entites.User;
import tn.spring.entites.Ville;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserRestApi {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VilleRepository villeRepository;
	
	@PostMapping("/users")
	public void saveAdmin(@RequestBody User admin) {
		Ville ville=villeRepository.findById(admin.getVille().getId()).get();
		admin.setVille(ville);
		admin.setDateJointure(new Date());
		userRepository.save(admin);
	}
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
