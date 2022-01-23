package tn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.dto.VilleRepository;
import tn.spring.entites.Ville;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VilleRestApi {
	@Autowired
	private VilleRepository villeRepository;
	
	@PostMapping("/villes")
	public void save(@RequestBody Ville ville) {
		villeRepository.save(ville);
	}
	
	@GetMapping("/villes")
	public List<Ville> getAllVilles(){
		return villeRepository.findAll();
	}

}
