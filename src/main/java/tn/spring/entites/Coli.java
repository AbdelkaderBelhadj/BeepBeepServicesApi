package tn.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @ToString @AllArgsConstructor
public class Coli implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	
	private User user;
	private String destinataire;
	
	private int telephone;
	@ManyToOne(fetch = FetchType.EAGER)
	
	private Ville ville;
	@NotEmpty
	private String adresse;
	
	private double prix;
	private int qte=1;
	private String etat;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	private Date dateUpdated;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chauffeur_id")
	private Chauffeur chauffeur;
	
}
