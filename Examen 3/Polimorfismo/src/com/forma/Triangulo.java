package com.forma;

public class Triangulo extends Forma {
	//Constructor de la figura
	public Triangulo(double x, double y) {
		super(x, y);
	}

	@Override
	public double calculaArea() {
		double result = (x*y)/2; //Se calcula el area de la figura
		return result;
	}

	@Override
	public double calculaPerimetro() {
		double result = x+x+x; //Se calcula el perimetro de la figura
		return result;
	}

}