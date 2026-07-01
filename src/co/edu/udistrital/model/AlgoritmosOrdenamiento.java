package co.edu.udistrital.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *	Contiene los algoritmos de ordenamiento implementados para el análisis
 *	comparativo de tiempos de ejecución: Burbuja, Shell, QuickSort y Radix.
 */

public class AlgoritmosOrdenamiento {

	/**
     * Ordena la lista de forma descendente usando el algoritmo de Burbuja,
     * comparando e intercambiando elementos adyacentes en cada pasada.
     * Incluye una bandera de optimización que detiene el algoritmo
     * si en una pasada completa no hubo ningún intercambio.
     *
     * @param lista lista de enteros a ordenar
     */
	
    public void burbuja(List<Integer> lista) {
        int n = lista.size();
        boolean huboIntercambio;
 
        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;
 
            for (int j = 0; j < n - 1 - i; j++) {
                if (lista.get(j) < lista.get(j + 1)) {
                    Collections.swap(lista, j, j + 1);
                    huboIntercambio = true;
                }
            }
 
            if (!huboIntercambio) {
                break;
            }
        }
    }

    /**
     * Ordena la lista de forma descendente usando el algoritmo de Shell,
     * una variante de Insertion Sort que compara elementos separados
     * por un "gap" que se va reduciendo progresivamente a la mitad.
     *
     * @param lista lista de enteros a ordenar; se modifica directamente (in-place)
     */
    public void shell(List<Integer> lista) {
        int n = lista.size();
 
        for (int gap = n / 2; gap > 0; gap /= 2) {
 
            for (int i = gap; i < n; i++) {
                int actual = lista.get(i);
                int j = i;
 
                while (j >= gap && lista.get(j - gap) < actual) {
                    lista.set(j, lista.get(j - gap));
                    j -= gap;
                }
 
                lista.set(j, actual);
            }
        }
    }
 
    /**
     * Ordena la lista de forma descendente usando el algoritmo QuickSort.
     * Este llama a slowSort(); para que realice la recursion
     * @param lista lista de enteros a ordena
     */

    public void quickSort(List<Integer> lista) {
        if (lista.size() > 1) {
        	slowSort(lista, 0, lista.size() - 1);
        }
    }
    
    /**
     * Ordena recursivamente el rango [izquierda, derecha] de la lista,
     * dividiendo la lista mediante particiones alrededor de un pivote.
     *
     * @param lista     lista de enteros sobre la que se realiza el ordenamiento
     * @param izquierda índice inicial del rango a ordenar
     * @param derecha   índice final del rango a ordenar
     */
 
    private void slowSort(List<Integer> lista, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int posPivote = particionar(lista, izquierda, derecha);
            slowSort(lista, izquierda, posPivote - 1);
            slowSort(lista, posPivote + 1, derecha);
        }
    }
    
    /**
     * Particiona la sublista alrededor de un pivote elegido aleatoriamente,
     * ubicando los elementos mayores al pivote a su izquierda y los menores
     * a su derecha. La elección aleatoria evita el peor caso de recursión
     * profunda cuando la lista ya está ordenada.
     *
     * @param lista     la lista de enteros sobre la que se realiza la partición
     * @param izquierda índice inicial del rango a particionar
     * @param derecha   índice final del rango a particionar
     * @return el índice final donde quedó ubicado el pivote luego de particionar
     */
 
    private int particionar(List<Integer> lista, int izquierda, int derecha) {
    
        int pivoteIdx = izquierda + new Random().nextInt(derecha - izquierda + 1);
        Collections.swap(lista, pivoteIdx, derecha);
        
        int pivote = lista.get(derecha);
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (lista.get(j) > pivote) {
                i++;
                Collections.swap(lista, i, j);
            }
        }

        Collections.swap(lista, i + 1, derecha);
        return i + 1;
    }
    
    /**
     * Ordena la lista de forma descendente usando el algoritmo Radix Sort y
     * agrupa los elementos por dígito (unidades, decenas, centenas, etc.)
     * al final invierte el resultado para mantener el orden descendente.
     *
     * @param lista lista de enteros a ordenar; se modifica directamente (in-place)
     */
    
    public void radix(List<Integer> lista) {
        int n = lista.size();
        if (n == 0) {
            return;
        }
 
        int max = obtenerMaximo(lista);
 
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(lista, exp);
        }
 
        Collections.reverse(lista);
    }
 
    /**
     * Obtiene el valor máximo de la lista, usado para determinar cuántas
     * pasadas por dígito se necesitan en Radix Sort.
     *
     * @param lista lista de enteros de la cual se busca el máximo
     * @return el mayor valor encontrado en la lista
     */
    
    private int obtenerMaximo(List<Integer> lista) {
        int max = lista.get(0);
        for (int valor : lista) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }
    
    /**
     * Ordena la lista de forma estable según el dígito correspondiente
     * a la posición usando el algoritmo Counting Sort.
     *
     * @param lista lista de enteros a reordenar según el dígito actual
     * @param exp   potencia de 10 que indica la posición del dígito a evaluar
     *              (1 = unidades, 10 = decenas, 100 = centenas, etc.)
     */
 
    private void countingSortPorDigito(List<Integer> lista, int exp) {
        int n = lista.size();
        int[] salida = new int[n];
        int[] conteo = new int[10];
 
        for (int i = 0; i < n; i++) {
            int digito = (lista.get(i) / exp) % 10;
            conteo[digito]++;
        }
 
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }
 
        for (int i = n - 1; i >= 0; i--) {
            int digito = (lista.get(i) / exp) % 10;
            salida[conteo[digito] - 1] = lista.get(i);
            conteo[digito]--;
        }
 
        for (int i = 0; i < n; i++) {
            lista.set(i, salida[i]);
        }
    }
}
