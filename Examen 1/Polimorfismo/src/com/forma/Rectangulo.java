package com.forma;

public class Rectangulo extends Forma{
	//Constructor de la figura
	public Rectangulo(int x, int y) {
		super(x, y);
	}

	@Override
	public int calculaArea() {
		int result = x*y;//Se calcula el area de la figura
		return result;
	}

	@Override
	public int calculaPerimetro() {
		int result = x+x+y+y; //Se calcula el perimetro de la figura
		return result;
	}
	
	
}
