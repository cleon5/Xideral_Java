package Arcade;

public class Principal {
	public static void main(String[] args) {

		//Se crean los objectos y se ejecuta 
		Jugador j1 = Injector.inyectarMaquina("Fulano", "tragamonedas");
		j1.jugar();
		
		Jugador j2= Injector.inyectarMaquina("Mengano", "pinball");
		j2.jugar();
		
		Jugador j3 = Injector.inyectarMaquina("Merengano", "Street Figter");
		j3.jugar();
		
	  // Al final se van los jugadores
		j1.irse();
		j2.irse();
		j3.irse();
		 
	}
}
