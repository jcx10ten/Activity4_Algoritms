package co.edu.udistrital.view;

import java.util.Scanner;

/**
 * Vista de consola de la aplicación. Se encarga de toda la interacción
 * directa con el usuario: solicitar datos (tamaño del arreglo, algoritmo
 * a probar) y mostrar los resultados de las mediciones de tiempo.
 */

public class VentanaPrincipal {
	
    private final Scanner scanner = new Scanner(System.in);
    
    /**
     * Solicita al usuario el tamaño (n) del arreglo a generar,
     * validando que la entrada sea un número entero.
     *
     * @return el tamaño del arreglo ingresado por el usuario
     */
    
    public int pedirTamano() {
        System.out.print("\nTamano del arreglo (N): ");
        return leerEntero();
    }
    
    /**
     * Muestra el menú de algoritmos disponibles y solicita al usuario
     * elegir uno mediante su número correspondiente.
     * @return la opción de algoritmo ingresada por el usuario
     */
    
    public int pedirAlgoritmo() {
        System.out.println("1. Burbuja  2. Radix  3. Shell  4. QuickSort");
        System.out.print("Algoritmo: ");
        return leerEntero();
    }
    
    /**
     * Muestra por consola los tiempos de ejecución medidos para un
     * algoritmo dado, en sus tres escenarios: mejor caso, peor caso
     * y caso promedio.
     *
     * @param algoritmo      nombre del algoritmo evaluado 
     * @param n              tamaño del arreglo utilizado en la medición
     * @param tiempoMejor    tiempo de ejecución en el mejor caso
     * @param tiempoPeor     tiempo de ejecución en el peor caso
     * @param tiempoPromedio tiempo de ejecución en el caso promedio
     */
 
    public void mostrarResultados(String algoritmo, int n,
                                   long tiempoMejor, long tiempoPeor, long tiempoPromedio) {
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Mejor caso: "+ tiempoMejor);
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Peor caso: "+ tiempoPeor);
        System.out.printf("\n Algoritmo: "+ algoritmo+ ", n: " + n + ", T. Caso promedio: "+ tiempoPromedio);
    }
 
    /**
     * Lee un número entero desde la entrada estándar, validando
     * la entrada y solicitando de nuevo el valor si no es un
     * entero válido.
     *
     * @return el valor entero leído desde la consola
     */
    
    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("\nNumero invalido, intente de nuevo: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    
    /**
     * Cierra el usado para leer la entrada del usuario.
     */
    
    public void cerrar() {
        scanner.close();
    }

    }
