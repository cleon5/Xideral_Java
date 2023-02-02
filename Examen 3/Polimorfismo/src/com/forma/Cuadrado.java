package com.forma;

public class Cuadrado extends Forma {
	//Constructor de la figura
	public Cuadrado(double x, double y) {
		super(x, y);
	}

	@Override
	public double calculaArea() {
		double result = x*x;//Area = Lado por lado
		return result;
	}

	@Override
	public double calculaPerimetro() {
		double result = 4*x; //Se calcula el perimetro de la figura
		return result;
	}
	
}
