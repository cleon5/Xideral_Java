package com.forma;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	static public void main (String[] args) {
		
		//Creacion de Arraylist
	       List<Forma> formas = new ArrayList<>();
	       //Agregar Formas
	       formas.add(new Cuadrado(5,5)); //Agragamos la longitud del lado 2 veces
	       formas.add(new Rectangulo(5,7));  //Agragamos la longitud de la base y la altura
	       formas.add(new Triangulo(3,5)); //Agragamos la longitud de la base y la altura
	       formas.add(new Circulo(5,10)); //Agragamos la longitud del radio y el diametro
	       
	       //Bucle para mostrar todas las formas almacenadas en la lista
	       for(Forma forma: formas){
	           System.out.println(forma); //Imprimimos el nombre de la forma y sus medidas
	           int area = forma.calculaArea(); //Almacenamos su area en una variable 
	           int per = forma.calculaPerimetro(); //Almacenamos su perimetro en una variable 
	           System.out.println("Area = "+ area + " Perimetro = "+per); //Imprimimos el resultado de area y Perimetro
	           System.out.println(""); //Imprime un salto de linea
	       }
	}
}
