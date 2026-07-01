package co.edu.udistrital.model;

import java.util.Collections;
import java.util.List;

/**
 * Genera los distintos casos de prueba (mejor, peor y promedio) usados
 * para evaluar el desempeño de los algoritmos de ordenamiento sobre
 * arreglos de N tamaño seleccionado por el usuario
 *
 */

public class CasosLista {
	
	/**
	 * Genera una lista de tamaño n en orden descendente (n, n-1, ..., 1),
	 * representando el peor caso para algoritmos de ordenamiento
	 *
	 * @param test lista que será limpiada y rellenada con los nuevos valores
	 * @param n    cantidad de elementos a generar
	 * @return la misma lista recibida, ya modificada con los valores generados
	 */
	
	public List<Integer> inversoCaso(List<Integer> test , int n){	
		test.clear();
		for(int i=0; i<n;i++) {
			test.add(n-i);
		}
		return test;
	}
	
	/**
	 * Genera una lista de tamaño n con valores del 0 al n-1 y luego
	 * los desordena aleatoriamente, representando el caso promedio
	 * (arreglo desordenado sin ningún patrón particular).
	 *
	 * @param test lista que será limpiada y rellenada con los nuevos valores
	 * @param n    cantidad de elementos a generar
	 * @return la misma lista recibida, ya modificada y desordenada
	 */
	
	public List<Integer> promedioCaso(List<Integer> test , int n){
		test.clear();
		for(int i=0; i<n;i++) {
			test.add(i);
		}
		Collections.shuffle(test);
		
		return test;
	}
	
	/**
	 * Genera una lista de tamaño n en orden ascendente (0, 1, ..., n-1),
	 * representando el mejor caso para algoritmos de ordenamiento
	 * que asumen una entrada ya ordenada.
	 *
	 * @param test lista que será limpiada y rellenada con los nuevos valores
	 * @param n    cantidad de elementos a generar
	 * @return la misma lista recibida, ya modificada con los valores generados
	 */
	
	public List<Integer> ordenadoCaso(List<Integer> test , int n){
		test.clear();
		for(int i=0; i<n;i++) {
			test.add(i);
		}
		return test;
	}

}
