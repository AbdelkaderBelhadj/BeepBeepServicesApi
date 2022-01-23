package tn.spring.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @ToString @NoArgsConstructor
//@DiscriminatorValue("CHAUFFEUR")
@JsonTypeName("CHAUFFEUR")
public class Chauffeur extends User{
	private int experience ;
	private double salaire;
	@OneToMany(mappedBy = "chauffeur",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private List<Coli> colis;
	
	public Chauffeur(  String email,  String username, String password,
			Ville ville, Date dateJointure,  int experience,
			double salaire) {
		super( email, username, password, ville, dateJointure);
		this.experience = experience;
		this.salaire = salaire;
	}
	@Override
	public String getType() {
	    return "CHAUFFEUR";
	}
	
	
	
	
	


}
