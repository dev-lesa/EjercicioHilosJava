/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

/**
 *
 * @author Luis
 */
import Logica.LogNumeros;
import Clases.Numeros;
import Clases.BuscadorHilo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws ClassNotFoundException {
        LogNumeros objLogNumeros = new LogNumeros();
        Scanner entrada = new Scanner(System.in);

        try {
            int total = objLogNumeros.ObtenerTotal();
            System.out.println("Registros en BD: " + total + "\n");

            List<Numeros> listaNumeros = objLogNumeros.ListarTodos();

            System.out.println("ID      Col0        Col1        Col2        Col3        Col4        Col5");
            System.out.println("------------------------------------------------------------------------");

            int contador = 0;
            for (Numeros num : listaNumeros) {
                if (contador < listaNumeros.size()) {
                    System.out.printf("%-8d%-12d%-12d%-12d%-12d%-12d%-12d%n",
                            num.getIdFila(),
                            num.getNumeroscol0(),
                            num.getNumeroscol1(),
                            num.getNumeroscol2(),
                            num.getNumeroscol3(),
                            num.getNumeroscol4(),
                            num.getNumeroscol5());
                    contador++;
                }
            }

            System.out.println("\nbusqueda con hilos");
            System.out.print("ingrese numero a buscar del 1 al 20: ");
            int numeroBuscar = entrada.nextInt();

            System.out.print("cantidad de hilos de 2 a 5: ");
            int cantHilos = entrada.nextInt();

            int tamPorHilo = total / cantHilos;
            System.out.println("\n dividiendo " + total + " filas entre " + cantHilos + " hilos");
            for (int i = 0; i < cantHilos; i++) {
                int inicio = i * tamPorHilo;
                int fin = (i == cantHilos - 1) ? total : inicio + tamPorHilo;
                System.out.println("Hilo " + (i + 1) + " tiene filas [" + inicio + " a " + (fin - 1) + "]");
            }
            System.out.println();

            int N = objLogNumeros.BuscarCuantas(numeroBuscar, cantHilos);

            for (BuscadorHilo h : objLogNumeros.getUltimosHilos()) {
                System.out.println(h.getName() + " termino, encontro " + h.getConteoLocal()
                        + " veces el numero " + numeroBuscar
                        + " en sus " + h.getTamSubLista() + " filas");
            }

            System.out.println("\n  El numero " + numeroBuscar + " aparece " + N + " veces en total");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        entrada.close();
    }
}
