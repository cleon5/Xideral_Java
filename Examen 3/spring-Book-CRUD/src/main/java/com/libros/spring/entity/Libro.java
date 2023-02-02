package com.libros.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libros")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="estado")
	private String estado;
	
@Override
	public String toString() {
		return "Customer [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", estado=" + estado + "]";
	}
		
}





