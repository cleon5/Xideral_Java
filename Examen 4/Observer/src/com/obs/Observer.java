package com.obs;

public abstract class Observer {
	Subject sb;
	Observer(Subject sb){
		this.sb = sb;
		
	}
	
	abstract void update();
	abstract void deposito(float cant);
	abstract void retiro(float cant);
	
}
