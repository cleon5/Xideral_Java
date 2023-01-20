package Arcade;

public class Jugador {
	String nombre; //Nombre del jugador
	private Maquina maquina; //Tipo de maquina que usara
	
	//Constructor de la clase jugador, donde se agrega el nombre y el tipo de maquina
	public Jugador(String nombre, Maquina maquina) {
		this.nombre = nombre;
		this.maquina = maquina;
	}
	//Metodo toString para mostrar el nombre del jugador
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + "]";
	}
   //Metodo jugar para encender la maquina
	void jugar() {
		System.out.print(nombre +" - ");
		maquina.encender();
	}
	//Metodo para cuando el jugador deje de jugar y apage la maquina
	void irse() {
		System.out.print(nombre +" - ");
		maquina.apagar();
	}
	
	
}
