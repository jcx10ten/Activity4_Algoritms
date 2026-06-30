package co.edu.udistrital.view;

import java.util.Scanner;

public class VentanaPrincipal {
	
    private final Scanner scanner = new Scanner(System.in);
    
    public int pedirTamano() {
        System.out.print("Tamano del arreglo (N): ");
        return leerEntero();
    }
 
    public int pedirAlgoritmo() {
        System.out.println("1. Burbuja  2. Radix  3. Shell  4. QuickSort");
        System.out.print("Algoritmo: ");
        return leerEntero();
    }
 
    public void mostrarResultados(String algoritmo, int tamano,
                                   double tiempoMejor, double tiempoPeor, double tiempoPromedio) {
        System.out.printf("%-10s %-10d %-10.3f Mejor%n", algoritmo, tamano, tiempoMejor);
        System.out.printf("%-10s %-10d %-10.3f Peor%n", algoritmo, tamano, tiempoPeor);
        System.out.printf("%-10s %-10d %-10.3f Promedio%n", algoritmo, tamano, tiempoPromedio);
    }
 
    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Numero invalido, intente de nuevo: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
 
    public void cerrar() {
        scanner.close();
    }
