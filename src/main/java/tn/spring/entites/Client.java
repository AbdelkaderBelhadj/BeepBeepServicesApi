package tn.spring.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
@JsonTypeName("CLIENT")
//@DiscriminatorValue("CLIENT")
public class Client extends User{
	public Client( @Email String email, @NotEmpty String username, String password,
			Ville ville, Date dateJointure) {
		super( email, username, password, ville, dateJointure);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getType() {
	    return "CLIENT";
	}
	
	

}
