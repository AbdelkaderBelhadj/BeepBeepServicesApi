package tn.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.dto.ColiRepository;
import tn.spring.dto.UserRepository;
import tn.spring.dto.VilleRepository;
import tn.spring.entites.Coli;
import tn.spring.entites.User;
import tn.spring.entites.Ville;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ColiRestApi {
	@Autowired
	private ColiRepository coliRepisitory;
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private UserRepository usreRepository;
	
	@GetMapping("/colis")
	public List<Coli> getAllColis(){
		return coliRepisitory.findAll();
	}
	
	@GetMapping("/colis/{username}")
	public List<Coli> getAllColisByClient(@PathVariable String username){
		User u=usreRepository.findByUsername(username);
		return coliRepisitory.findByUser(u);
	}
	
	@PostMapping("/colis")
	public void save(@RequestBody Coli coli) {
		Ville ville =villeRepository.findById(coli.getVille().getId()).get();
		coli.setVille(ville);
		User user=usreRepository.findByUsername(coli.getUser().getUsername());
		System.out.println(user);
		coli.setUser(user);
		String x="CA";
		Random rand = new Random();   
		int rand_int= rand.nextInt(1000); 
		String reference=x+rand_int; 
		coli.setDateCreated(new Date());
		coli.setReference(reference);
		coli.setEtat("En cours");
		coliRepisitory.save(coli);
	}
	
	@GetMapping("/colis/client/{username}")
	public List<Object> colisparclient(@PathVariable String username){
		User user=usreRepository.findByUsername(username);
		return coliRepisitory.nbrColiByClient(user);
	}
	
	@GetMapping("/colis/admin")
	public List<Object> colisparAdmin(){
		
		return coliRepisitory.nbrColiByAdmin();
	}
	
	@DeleteMapping("/colis/{id}")
	public void delete(@PathVariable long id) {
		coliRepisitory.deleteById(id);
	}
	
	@GetMapping("/colis/byid/{id}")
	public Coli getColiById(@PathVariable long id) {
		return coliRepisitory.findById(id).get();
	}
	
	@GetMapping("/colis/get/{id}")
	public Coli getColi(@PathVariable long id) {
		return coliRepisitory.findById(id).get();
	}
	
	@PutMapping("/colis/{id}")
	public void updateColi(@RequestBody Coli coli,@PathVariable long id) {
		
		coli.setId(id);
		coliRepisitory.save(coli); 
	}
}
