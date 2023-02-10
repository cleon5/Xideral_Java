package com.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Principal {
    
     public static void main(String []args){
     
        Consumer<Double> inprimir = (x) -> System.out.println("Area de "+ x);
    	List<Double> listaFormas = new ArrayList<>();	
    	
        Forma areaCuadrilateros = (base,altura) -> base*altura;
        Forma perimetroCuadrilatero = (lado1, lado2) -> 2*(lado1 + lado2);
        
        Forma areaTriangulo = (base,altura) -> (base*altura)/2;
        Forma perimetroTriangulo = (base,altura) -> 3*base;
        
        Forma areaCirculo = (radio ,diametro) -> 3.1416*(radio*radio);
        Forma perimetroCirculo = (radio ,diametro) ->  3.1416*diametro;
        
        
        listaFormas.add((double) areaCuadrilateros.ejecuta(6, 4));
        listaFormas.add((double) perimetroCuadrilatero.ejecuta(6, 4));
        listaFormas.add((double) areaTriangulo.ejecuta(4, 4));
        listaFormas.add((double) perimetroTriangulo.ejecuta(4, 4));
        listaFormas.add((double) areaCirculo.ejecuta(5, 10));
        listaFormas.add((double) perimetroCirculo.ejecuta(5, 10));
        
        
        //listaFormas.forEach((n1) -> inprimir.accept(n1));
        
        BiFunction<Double, Double, String> pa = ((x, y) -> "Area de "+ x + " y el perimetro de " + y) ;
        for(int i = 0 ; i<listaFormas.size(); i+=2)
        	System.out.println(pa.apply(listaFormas.get(i), listaFormas.get(i+1)));
		
     }
}
