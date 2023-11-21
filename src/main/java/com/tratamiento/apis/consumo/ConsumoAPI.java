package com.tratamiento.apis.consumo;

import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tratamiento.apis.modelo.Categoria;
import com.tratamiento.apis.modelo.Pet;
import com.tratamiento.apis.modelo.Tags;
import com.tratamiento.apis.modelo.User;

public class ConsumoAPI {
	
	private String urlString = "https://petstore.swagger.io/v2/";
	private Categoria categoria;
	private Pet pet;
	private Tags tags;
	private URL url;
	private JSONObject result;
	private String res = "";
	private String userToPass = "";
	private List<Pet> pets;
	
	public String createUser() {
	
			try {
				url = new URL(urlString);
				
				Client client = ClientBuilder.newClient();
				
				WebTarget target = client.target(url + "user");
				
				Invocation.Builder solicitud = target.request();
				
				User user = new User();
				user.setId((long)6);
				user.setUsername("usuarioPruebas");
				user.setFirstName("NombrePrueba");
				user.setLastName("ApellidoPrueba");
				user.setEmail("email@gmail.com");
				user.setPassword("testpass");
				user.setPhone("666555444");
				user.setUserStatus(0);
				
				userToPass = user.getUsername();
				
				Gson gson = new Gson();
				String jsonString = gson.toJson(user);
				System.out.println(jsonString);
				Response post = solicitud.post(Entity.json(jsonString));
				 String responseJson = post.readEntity(String.class);
				 
				switch (post.getStatus()) { 
	             case 200:
	                     res = responseJson;
	                     break;
	             default:
	                     res = "Error";
	                     break; 
	                             }
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result = new JSONObject(res);
			
			return userToPass;
		
	}

	public User getUser(String userToFind) {
		
		try {
			url = new URL(urlString);
			
			Client client = ClientBuilder.newClient();
			
			WebTarget target = client.target(url + "user/" + userToFind);
			
			Invocation.Builder solicitud = target.request();
			
			Response get = solicitud.get();
			 String responseJson = get.readEntity(String.class);
			 
			switch (get.getStatus()) { 
             case 200:
                     res = responseJson;
                     break;
             default:
                     res = "Error";
                     break; 
                             }
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = new JSONObject(res);
		
		
		User user = new User();
		user.setId(result.getLong("id"));
		user.setUsername(result.getString("username"));
		user.setFirstName(result.getString("firstName"));
		user.setLastName(result.getString("lastName"));
		user.setEmail(result.getString("email"));
		user.setPassword(result.getString("password"));
		user.setPhone(result.getString("phone"));
		user.setUserStatus(result.getInt("userStatus"));
		
		return user;
		
	}
	
	
public List<Pet> getSoldPets() {
		
		pets = new ArrayList<Pet>();
		try {
			url = new URL(urlString);
			
			Client client = ClientBuilder.newClient();
			
			WebTarget target = client.target(url + "pet/findByStatus?status=sold");
			
			Invocation.Builder solicitud = target.request();
			
			Response get = solicitud.get();
			 String responseJson = get.readEntity(String.class);
			 
			switch (get.getStatus()) { 
             case 200:
                     res = responseJson;
                     break;
             default:
                     res = "Error";
                     break; 
                             }
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = new JSONArray(res);
		
		for (int i=0; i<jsonArray.length(); i++) {
			result = jsonArray.getJSONObject(i);
			pet = new Pet();
			pet.setId(result.getLong("id"));
			pet.setNombre(result.getString("name"));
			System.out.println("La mascota con id " + pet.getId() + " y nombre " + pet.getNombre() + " ha sido vendida");
			pets.add(pet);
		}
		

		return pets;
		
	}


	
	
}
	 
		
		
		
	
	
	
	
	
