package com.tratamiento.apis;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tratamiento.apis.consumo.ConsumoAPI;
import com.tratamiento.apis.modelo.Pet;
import com.tratamiento.apis.modelo.PetDuplicate;

@SpringBootApplication
public class ApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisApplication.class, args);
		ConsumoAPI con = new ConsumoAPI();
		PetDuplicate pd = new PetDuplicate();
		String user;
		List<Pet> pets;
		
		user = con.createUser();
		
		con.getUser(user);
		
		pets = con.getSoldPets();
		pd.identifyDuplicate(pets);
	
		
		
	}

}
