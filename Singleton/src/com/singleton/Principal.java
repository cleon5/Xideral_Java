package com.singleton;

public class Principal {
	static public void main(String[] args) {
		//Se instancian los objectos 
		Modem modem1 =Modem.getInstance("Primera");
		Modem modem2 = Modem.getInstance("Segunda");
		   
		//Se imprimen los valores de nombre y contador del objecto Modem
		System.out.println("Contador = "+Modem.contador+" nombre "+ modem1.getNombre());
		System.out.println("Contador = "+modem1.contador+" nombre "+ modem1.getNombre());
		System.out.println("Contador = "+modem2.contador+" nombre "+ modem2.getNombre());
		
		//Siempre que se instancie el objecto, la conexion sera la misma
	} 
}
