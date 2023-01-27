package com.luv2code.web.jdbc;

public class Libro {

	private int id;
	private String nombre;
	private String tipo;
	private String generol;
	private String estado;

	public Libro(String firstName, String lastName, String email,String estado) {
		this.nombre = firstName;
		this.tipo = lastName;
		this.generol = email;
		this.estado = estado;
	}

	public Libro(int id, String firstName, String lastName, String email,String estado) {
		this.id = id;
		this.nombre = firstName;
		this.tipo = lastName;
		this.generol = email;
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String firstName) {
		this.nombre = firstName;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String lastName) {
		this.tipo = lastName;
	}

	public String getGenero() {
		return generol;
	}

	public void setGenero(String email) {
		this.generol = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + nombre + ", lastName=" + tipo + ", email=" + generol + "]";
	}	
}
