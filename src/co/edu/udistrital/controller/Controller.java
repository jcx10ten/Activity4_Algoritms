package co.edu.udistrital.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.model.AlgoritmosOrdenamiento;
import co.edu.udistrital.model.CasosLista;
import co.edu.udistrital.view.VentanaPrincipal;

public class Controller {

	private AlgoritmosOrdenamiento algoritmo;
	private CasosLista casosLista;
	private List<Integer> lista;
	private VentanaPrincipal ventana;

	public Controller() {
		casosLista = new CasosLista();
		algoritmo = new AlgoritmosOrdenamiento();
		ventana = new VentanaPrincipal();
		Run();
	}

	public void Run() {
		lista = new ArrayList<>();

		int opc ;
		do{
			int n = ventana.pedirTamano();
			opc = ventana.pedirAlgoritmo();
			switch (opc) {
			case 1:
				tiempoBurbuja(lista,n);
				break;

			case 2:
				tiempoRadix(lista,n);
				break;

			case 3:
				tiempoShell(lista,n);
				break;

			case 4:
				tiempoQuickSort(lista,n);
				break;

			default:
				break;

			}
			
		}while(opc!=0);
		

	}

	public void tiempoBurbuja(List<Integer> lista, int n) {

		// Peor caso
		lista = casosLista.inversoCaso(lista, n);
		long InicialTimeA = System.nanoTime();
		algoritmo.burbuja(lista);
		long FinalTimeA = System.nanoTime();

		// Mejor Caso
		lista = casosLista.ordenadoCaso(lista, n);
		long InicialTimeB = System.nanoTime();
		algoritmo.burbuja(lista);
		long FinalTimeB = System.nanoTime();

		// Caso Promedio
		lista = casosLista.promedioCaso(lista, n);
		long InicialTimeC = System.nanoTime();
		algoritmo.burbuja(lista);
		long FinalTimeC = System.nanoTime();

		long tiempoPeor = FinalTimeA - InicialTimeA;
		long tiempoMejor = FinalTimeB - InicialTimeB;
		long tiempoProm = FinalTimeC - InicialTimeC;

		ventana.mostrarResultados("Burbuja", n, tiempoMejor, tiempoPeor, tiempoProm);

	}

	public void tiempoShell(List<Integer> lista, int n) {

		// Peor caso
		lista = casosLista.inversoCaso(lista, n);
		long InicialTimeA = System.nanoTime();
		algoritmo.shell(lista);
		long FinalTimeA = System.nanoTime();

		// Mejor caso
		lista = casosLista.ordenadoCaso(lista, n);
		long InicialTimeB = System.nanoTime();
		algoritmo.shell(lista);
		long FinalTimeB = System.nanoTime();

		// Caso Promedio
		lista = casosLista.promedioCaso(lista, n);
		long InicialTimeC = System.nanoTime();
		algoritmo.shell(lista);
		long FinalTimeC = System.nanoTime();

		long tiempoPeor = FinalTimeA - InicialTimeA;
		long tiempoMejor = FinalTimeB - InicialTimeB;
		long tiempoProm = FinalTimeC - InicialTimeC;

		ventana.mostrarResultados("Shell", n, tiempoMejor, tiempoPeor, tiempoProm);

	}

	public void tiempoQuickSort(List<Integer> lista, int n) {

		// Peor caso
		lista = casosLista.inversoCaso(lista, n);
		long InicialTimeA = System.nanoTime();
		algoritmo.quickSort(lista);
		long FinalTimeA = System.nanoTime();

		// Mejor caso
		lista = casosLista.ordenadoCaso(lista, n);
		long InicialTimeB = System.nanoTime();
		algoritmo.quickSort(lista);
		long FinalTimeB = System.nanoTime();

		// Caso Promedio
		lista = casosLista.promedioCaso(lista, n);
		long InicialTimeC = System.nanoTime();
		algoritmo.quickSort(lista);
		long FinalTimeC = System.nanoTime();

		long tiempoPeor = FinalTimeA - InicialTimeA;
		long tiempoMejor = FinalTimeB - InicialTimeB;
		long tiempoProm = FinalTimeC - InicialTimeC;

		ventana.mostrarResultados("QuickSort", n, tiempoMejor, tiempoPeor, tiempoProm);

	}

	public void tiempoRadix(List<Integer> lista, int n) {

		// Peor caso
		lista = casosLista.inversoCaso(lista, n);
		long InicialTimeA = System.nanoTime();
		algoritmo.radix(lista);
		long FinalTimeA = System.nanoTime();

		// Mejor caso
		lista = casosLista.ordenadoCaso(lista, n);
		long InicialTimeB = System.nanoTime();
		algoritmo.radix(lista);
		long FinalTimeB = System.nanoTime();

		// Caso Promedio
		lista = casosLista.promedioCaso(lista, n);
		long InicialTimeC = System.nanoTime();
		algoritmo.radix(lista);
		long FinalTimeC = System.nanoTime();

		long tiempoPeor = FinalTimeA - InicialTimeA;
		long tiempoMejor = FinalTimeB - InicialTimeB;
		long tiempoProm = FinalTimeC - InicialTimeC;

		ventana.mostrarResultados("Radix", n, tiempoMejor, tiempoPeor, tiempoProm);

	}

}
