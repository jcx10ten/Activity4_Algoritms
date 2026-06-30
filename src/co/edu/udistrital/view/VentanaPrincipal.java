package co.edu.udistrital.view;

import java.util.Scanner;

public class VentanaPrincipal {
	
    private final Scanner scanner = new Scanner(System.in);
    
    public int pedirTamano() {
        System.out.print("\nTamano del arreglo (N): ");
        return leerEntero();
    }
 
    public int pedirAlgoritmo() {
        System.out.println("1. Burbuja  2. Radix  3. Shell  4. QuickSort");
        System.out.print("Algoritmo: ");
        return leerEntero();
    }
 
    public void mostrarResultados(String algoritmo, int n,
                                   long tiempoMejor, long tiempoPeor, long tiempoPromedio) {
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Mejor caso: "+ tiempoMejor);
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Peor caso: "+ tiempoPeor);
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Caso promedio: "+ tiempoPromedio);
    }
 
    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("\nNumero invalido, intente de nuevo: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
 
    public void cerrar() {
        scanner.close();
    }

    }
