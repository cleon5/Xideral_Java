package com.forma;

//Clase Abstracta de Formas
abstract public class Forma implements FormaInterface{
    //Atributos
	int x;
    int y;
    
    //Constructor de la clase Forma 
    public Forma (int x, int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public String toString(){
    	//Sobreescritura del metodo toString para mostrar los datos del objecto
        return this.getClass().getSimpleName() + "= [x="+x + ", y="+y+ "]"; 
        
    }
}
