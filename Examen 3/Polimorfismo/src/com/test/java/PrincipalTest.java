package com.test.java;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forma.Circulo;
import com.forma.Cuadrado;
import com.forma.Forma;
import com.forma.Rectangulo;
import com.forma.Triangulo;

class PrincipalTest {
	
	@Test
	@DisplayName("Test de perimetro de cuadrado")
	void testCuadrado() {
		int valor1 = 5;
		double perimetro;
		
		Forma cuadrado = new Cuadrado(valor1, valor1);
		perimetro = valor1*4;
		assertEquals(perimetro, cuadrado.calculaPerimetro()) ;
	}
	
	@Test
	@DisplayName("Test de perimetro de rectangulo")
	void testRectangulo() {
		int valor1 = 5;
		int valor2 = 7;
		double perimetro;
		
		Forma rectangulo = new Rectangulo(valor1, valor2);
		perimetro = (valor1*2)+(valor2*2);
		assertEquals(perimetro, rectangulo.calculaPerimetro()) ;
	}
	
	@Test
	@DisplayName("Test de perimetro de triangulo")
	void testTriangulo() {
		int valor1 = 5;
		int valor2 = 5;
		double perimetro;
		
		Forma triangulo = new Triangulo(valor1, valor2);
		perimetro = valor1*3;
		assertEquals(perimetro, triangulo.calculaPerimetro()) ;
	}
	
	@Test
	@DisplayName("Test de perimetro de circulo")
	void testCirculo() {
		int valor1 = 5;
		int valor2 = 10;
		double perimetro;
		
		Forma circulo = new Circulo(valor1, valor2);
		perimetro = 3.1416*valor2;
		assertEquals(perimetro, circulo.calculaPerimetro()) ;
	}

	
	@Test
	@DisplayName("Test de area de cuadrado")
	void testCuadradoArea() {
		int valor1 = 5;
		double area;
		
		Forma cuadrado = new Cuadrado(valor1, valor1);
		area = valor1*valor1;
		assertEquals(area, cuadrado.calculaArea()) ;
	}
	
	@Test
	@DisplayName("Test de area de rectangulo")
	void testRectanguloArea() {
		int valor1 = 5;
		int valor2 = 7;
		double area;
		
		Forma rectangulo = new Rectangulo(valor1, valor2);
		area = valor1*valor2;
		assertEquals(area, rectangulo.calculaArea()) ;
	}
	
	@Test
	@DisplayName("Test de area de triangulo")
	void testTrianguloArea() {
		double valor1 = 3;
		double valor2 = 5;
		double area;
		
		Forma triangulo = new Triangulo(valor1, valor2);
		area = ((valor1*valor2)/2);
		System.out.println(area);
		assertEquals(area, triangulo.calculaArea()) ;
	}
	
	@Test
	@DisplayName("Test de area de circulo")
	void testCirculoArea() {
		int valor1 = 5;
		int valor2 = 10;
		double area;
		
		Forma circulo = new Circulo(valor1, valor2);
		area = 3.1416*(valor1*valor1);
		assertEquals(area, circulo.calculaArea()) ;
	}
	
	@Test
	@DisplayName("Test del toString")
	void testToString() {
		int valor1 = 5;
		int valor2 = 10;
		
		Forma rec = new Rectangulo(valor1, valor2);
		System.out.println(rec.toString());
		assertTrue(rec.toString().contains("Rectangulo"));
	}
}
