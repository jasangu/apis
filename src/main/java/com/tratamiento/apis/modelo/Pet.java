package com.tratamiento.apis.modelo;

public class Pet {
	
	private Long id;
	private Categoria categoria;
	private String nombre;
	private String photoUrl;
	private Tags tags;
	private String status;
	
	public Pet() {
		
	}
	
	public Pet(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}
	public Pet(Long id, String nombre, Categoria categoria, String photoUrl, Tags tags, String status) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.photoUrl = photoUrl;
		this.tags = tags;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getPhotoURL() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}