package com.singleton;

public class Modem {
	//Atributos
	   private String nombre; //Nombre de la conexion 
	   static int contador; //Contador para el numero de conexiones
	   private static Modem modem; //Objeto Modem

	   //Constructor de la clase, donde recibe el nombre 
	   private Modem (String nombre ){
		   this.nombre = nombre;
		   contador++;
	   }

		public static Modem getInstance (String name){
	         if(modem==null) //Se comprueba que no haya una conexion al modem
	        	 modem = new Modem(name); // Si no hay una conexion se crea una nueva
	         return modem;// Se retorna el objecto modem
	     }
		//Getter del nombre
	    public String getNombre() {
	    	return nombre;
	    }

}
