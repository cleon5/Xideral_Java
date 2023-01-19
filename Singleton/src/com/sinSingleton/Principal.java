package com.sinSingleton;

public class Principal {
	static public void main(String[] args) {
		//Se instancian los objectos 
		Conexion con1 = new Conexion("Primera");
		Conexion con2 = new Conexion("Segunda");
		Conexion con3 = new Conexion("Tercera");
		   
		//Se imprimen los valores de nombre y contador del objecto conexion
		System.out.println("Conexion #"+con1.contador+" nombre "+ con1.getNombre());
		System.out.println("Conexion #"+con2.contador+" nombre "+ con2.getNombre());
		System.out.println("Conexion #"+con3.contador+" nombre "+ con3.getNombre());
		
	} 
}
