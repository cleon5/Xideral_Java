package com.obs;

public class Cuenta extends Observer {

	private float saldo;
	private String nombre;

	public Cuenta(float saldo, Subject sb, String nombre) {
		super(sb);
		this.saldo = saldo;
		this.nombre = nombre;
		sb.attach(this);
	}

	@Override
	void deposito(float cant) {
		saldo += cant;
		sb.notificar();
	}

	@Override
	void retiro(float cant) {
		saldo -= cant;
		sb.notificar();
	}

	void Mensaje() {
		//System.out.println("Nuevo movimiento, tiene $" + saldo);
		System.out.println(toString());	
	}

	@Override
	void update() {
		Mensaje();

	}

	public String toString() {
		return " La cuenta de " + nombre + " tiene $" + saldo;

	}

}
