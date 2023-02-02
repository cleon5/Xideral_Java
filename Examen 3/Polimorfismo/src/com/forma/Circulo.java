package com.forma;

public class Circulo extends Forma{
	//Constructor de la figura
	public Circulo(double x, double y) {
		super(x, y);
	}

	@Override
	public double calculaArea() {
		double result = 3.1416*(x*x); //Area = pi por radio al cuadrado
		return result;
	}

	@Override
	public double calculaPerimetro() {
		double result = 3.1416*y; //Perímetro = pi por diámetro.
		return result;
	}

}
