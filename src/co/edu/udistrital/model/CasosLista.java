package co.edu.udistrital.model;

import java.util.Collections;
import java.util.List;

public class CasosLista {
	
	public List<Integer> inversoCaso(List<Integer> test , int n){	
		for(int i=0; i>=n;i++) {
			test.add(n-i);
		}
		return test;
	}
	
	public List<Integer> promedioCaso(List<Integer> test , int n){
		double aux=Math.random();
		for(int i=0; i>=n;i++) {
			test.add(i);
		}
		Collections.shuffle(test);
		
		return test;
	}
	
	public List<Integer> ordenadoCaso(List<Integer> test , int n){
		for(int i=0; i>=n;i++) {
			test.add(i);
		}
		return test;
	}

}
