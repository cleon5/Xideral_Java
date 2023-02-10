package com.obs;

public class Principal {
	public static void main(String[] args) {
		Cajero cajero = new Cajero();
		
		Observer cuenta1 = new Cuenta(66,cajero,"Fulano");
		Observer cuenta2 = new Cuenta(111,cajero,"Mengano");
		Observer cuenta3 = new Cuenta(88,cajero,"Pedro");

		//cajero.show();
		cajero.click();
		System.out.println("---------");

		cuenta1.deposito(10);
		System.out.println("---------");
		cuenta2.retiro(20);
		System.out.println("---------");
		cuenta3.retiro(30);
		System.out.println("---------");
		
		
		
		
	}
}
