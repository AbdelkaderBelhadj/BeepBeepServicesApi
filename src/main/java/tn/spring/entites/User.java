package tn.spring.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE",length = 10) 

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.EXISTING_PROPERTY,
        property="role")

@JsonSubTypes({
        @Type(name="ADMIN", value=Admin.class),
        @Type(name="CHAUFFEUR", value=Chauffeur.class),
        @Type(name="CLIENT", value=Client.class)})

public abstract class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	@Column(unique = true)
	private String username;
	
	@NotEmpty
	private String password;
	
	@ManyToOne
	private Ville ville;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateJointure;
	

	public User(@Email String email, @NotEmpty String username, String password,
			Ville ville, Date dateJointure) {
		super();
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.ville = ville;
		this.dateJointure = dateJointure;
		
		
	}
	
	@JsonProperty("role")
	public abstract String getType();
	
	
	
	
}
