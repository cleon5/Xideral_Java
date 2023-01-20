	package com.sinSingleton;

public class Conexion {
	//Atributos
   private String nombre; //Nombre de la conexion
   static int contador; //Contador para el numero de conexiones
   private static Conexion conexion; //Objeto conexion

   public Conexion (String nombre ){
	   this.nombre = nombre;
	   contador++; //Aumento del contador en el constructor
   }

	public static Conexion getInstance (String name){
         return conexion;    // se retorna el objecto conexion
     }
	//Getter del nombre de la conexion
    public String getNombre() {
    	return nombre;
}

}
