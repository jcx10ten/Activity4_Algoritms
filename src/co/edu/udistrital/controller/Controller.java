package co.edu.udistrital.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.model.AlgoritmosOrdenamiento;
import co.edu.udistrital.model.CasosLista;

public class Controller {
	
	private AlgoritmosOrdenamiento algoritmo;
	private CasosLista casosLista;
	private List<Integer> lista;
	
	public Controller() {
		lista = new ArrayList<>();
	}

	public void tiempoBurbuja(List<Integer> lista , int n) {
		
		//Peor caso
        lista = casosLista.inversoCaso(lista, n);		
		long InicialTimeA = System.nanoTime();
        algoritmo.burbuja(lista);        
        long FinalTimeA = System.nanoTime();
        
        //Mejor Caso
        lista = casosLista.ordenadoCaso(lista, n);		
		long InicialTimeB = System.nanoTime();
        algoritmo.burbuja(lista);        
        long FinalTimeB = System.nanoTime();
        
        //Caso Promedio
        lista = casosLista.promedioCaso(lista, n);		
		long InicialTimeC = System.nanoTime();
        algoritmo.burbuja(lista);        
        long FinalTimeC = System.nanoTime();   
        
	}
	
	public void tiempoShell(List<Integer> lista , int n) {
		
		//Peor caso
        lista = casosLista.inversoCaso(lista, n);		
		long InicialTimeA = System.nanoTime();
        algoritmo.shell(lista);       
        long FinalTimeA = System.nanoTime();
        
        //Mejor caso
        lista = casosLista.ordenadoCaso(lista, n);		
		long InicialTimeB = System.nanoTime();
        algoritmo.shell(lista);       
        long FinalTimeB = System.nanoTime();
        
        //Caso Promedio
        lista = casosLista.promedioCaso(lista, n);		
		long InicialTimeC = System.nanoTime();
        algoritmo.shell(lista);       
        long FinalTimeC = System.nanoTime();   
        
	}
	
	public void tiempoQuickSort(List<Integer> lista , int n) {
		
		//Peor caso
        lista = casosLista.inversoCaso(lista, n);		
		long InicialTimeA = System.nanoTime();
        algoritmo.quickSort(lista);       
        long FinalTimeA = System.nanoTime();
        
        //Mejor caso
        lista = casosLista.ordenadoCaso(lista, n);		
		long InicialTimeB = System.nanoTime();
        algoritmo.quickSort(lista);       
        long FinalTimeB = System.nanoTime();
        
        //Caso Promedio
        lista = casosLista.promedioCaso(lista, n);		
		long InicialTimeC = System.nanoTime();
        algoritmo.quickSort(lista);       
        long FinalTimeC = System.nanoTime(); 
        
	}
	
	public void tiempoRadix(List<Integer> lista , int n){
		
		//Peor caso
        lista = casosLista.inversoCaso(lista, n);		
		long InicialTimeA = System.nanoTime();
        algoritmo.radix(lista);       
        long FinalTimeA = System.nanoTime();
        
        //Mejor caso
        lista = casosLista.ordenadoCaso(lista, n);		
		long InicialTimeB = System.nanoTime();
        algoritmo.radix(lista);       
        long FinalTimeB = System.nanoTime();
        
        //Caso Promedio
        lista = casosLista.promedioCaso(lista, n);		
		long InicialTimeC = System.nanoTime();
        algoritmo.radix(lista);       
        long FinalTimeC = System.nanoTime(); 
        
	}
	
}
