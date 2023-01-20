package com.forma;

public class Circulo extends Forma{
	//Constructor de la figura
	public Circulo(int x, int y) {
		super(x, y);
	}

	@Override
	public int calculaArea() {
		int result = (int)3.1416*(x*x); //Area = pi por radio al cuadrado
		return result;
	}

	@Override
	public int calculaPerimetro() {
		int result = (int)3.1416*y; //Perímetro = pi por diámetro.
		return result;
	}

}
