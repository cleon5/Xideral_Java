package Arcade;

public class Pinball implements Maquina{
	//Nombre de la maquina
	String nombre;
	
	//Constructor de la clase trgamonedas, donde se agrega el nombre
	public Pinball(String nombre) {
		this.nombre = nombre;
	}
	//Sobreescritura del metodo encender de la interface
	@Override
	public void encender() {
		System.out.println("Encendio la maquina "+nombre); //Mostrar un mensaje de encendido
	}

	//Sobreescritura del metodo apagar de la interface
	@Override
	public void apagar() {
		System.out.println("Apago la maquina "+nombre);//Mostrar un mensaje de Apagado
		
	}
}
