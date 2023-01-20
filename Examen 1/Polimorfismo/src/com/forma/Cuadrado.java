package com.forma;

public class Cuadrado extends Forma {
	//Constructor de la figura
	public Cuadrado(int x, int y) {
		super(x, y);
	}

	@Override
	public int calculaArea() {
		int result = x*x;//Area = Lado por lado
		return result;
	}

	@Override
	public int calculaPerimetro() {
		int result = 4*x; //Se calcula el perimetro de la figura
		return result;
	}
	
}
