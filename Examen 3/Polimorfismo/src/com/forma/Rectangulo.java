package com.forma;

public class Rectangulo extends Forma{
	//Constructor de la figura
	public Rectangulo(double x, double y) {
		super(x, y);
	}

	@Override
	public double calculaArea() {
		double result = x*y;//Se calcula el area de la figura
		return result;
	}

	@Override
	public double calculaPerimetro() {
		double result = x+x+y+y; //Se calcula el perimetro de la figura
		return result;
	}
	
	
}
