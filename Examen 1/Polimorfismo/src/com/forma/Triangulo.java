package com.forma;

public class Triangulo extends Forma {
	//Constructor de la figura
	public Triangulo(int x, int y) {
		super(x, y);
	}

	@Override
	public int calculaArea() {
		int result = (x*y)/2; //Se calcula el area de la figura
		return result;
	}

	@Override
	public int calculaPerimetro() {
		int result = x+x+x; //Se calcula el perimetro de la figura
		return result;
	}

}