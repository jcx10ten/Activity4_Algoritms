package co.edu.udistrital.model;

import java.util.Collections;
import java.util.List;

public class AlgoritmosOrdenamiento {

    // er bubble.
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
 
    // la concha.
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
 
    // quicksilver.
    public void quickSort(List<Integer> lista) {
        if (lista.size() > 1) {
        	slowSort(lista, 0, lista.size() - 1);
        }
    }
 
    private void slowSort(List<Integer> lista, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int posPivote = particionar(lista, izquierda, derecha);
            slowSort(lista, izquierda, posPivote - 1);
            slowSort(lista, posPivote + 1, derecha);
        }
    }
 
    private int particionar(List<Integer> lista, int izquierda, int derecha) {
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
 
    // el hermano de goku.
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
 
    private int obtenerMaximo(List<Integer> lista) {
        int max = lista.get(0);
        for (int valor : lista) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }
 
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
