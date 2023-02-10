package com.obs;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	List<Observer> listaObservers = new ArrayList<>();
	
	void attach(Observer o) {
		listaObservers.add(o);
	}

	void detach(Observer o) {
		listaObservers.remove(o);
	}

	void notificar() {
		listaObservers.forEach(o -> o.update());

	}
	void show() {
		System.out.println(listaObservers);
	
	}

}