package Arcade;

public class Injector {
	static int contador;
	//Metodo para inyectar Maquina al jugador
	static Jugador inyectarMaquina(String jugador,String maquina) {
		//Contador para el numero de la maquina que se asigno
		contador++;
		//Comparador para elegir el tipo de maquina a asignar
		if (maquina == "tragamonedas")
			return new Jugador(jugador, new Tragamonedas("Tragamonedas #"+contador)); //Se concatena el contador en el nombre de la maquina
		if (maquina == "pinball")
			return new Jugador(jugador, new Pinball("Pinball #"+contador));
		else
			return new Jugador(jugador, new StreetFighter("Street Fighter #"+contador));
	}
}
