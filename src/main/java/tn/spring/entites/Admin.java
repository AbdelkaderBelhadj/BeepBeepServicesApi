package tn.spring.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
//@DiscriminatorValue("ADMIN")
@JsonTypeName("ADMIN")
public class Admin extends User{
	
	public Admin(@Email String email, @NotEmpty String username, String password, Ville ville, Date dateJointure) {
		super(email, username, password, ville, dateJointure);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getType() {
	    return "ADMIN";
	}
	
	
	
	
	

}
