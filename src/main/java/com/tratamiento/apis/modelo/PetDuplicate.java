package com.tratamiento.apis.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tratamiento.apis.modelo.Pet;

public class PetDuplicate {
	
	private List<String> names = new ArrayList<String>();
private List<Pet> pets = new ArrayList<Pet>();
private Integer contador;
	
	public PetDuplicate() {
		
	}
	
	public PetDuplicate(List<Pet> pets) {
		super();
	this.pets = pets;
		
	}
	
	
	public void identifyDuplicate(List<Pet> pets) {
		
		Map<String, Integer> contadores = new HashMap<>();

		for(Pet onePet: pets){
		  Integer contador = contadores.get(onePet.getNombre());
		  contadores.put(onePet.getNombre(), contador == null ? 1 : ++contador);
		}

		for(String petName: contadores.keySet()) {
		    System.out.println("petName: " + petName+", cantidad: "+contadores.get(petName));
		}
		
		
		
		
		
		
	}
	
}
	