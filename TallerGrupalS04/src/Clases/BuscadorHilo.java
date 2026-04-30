/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Luis
 */
import java.util.List;

public class BuscadorHilo extends Thread {
    // variable compartida entre todos los hilos
    private static volatile int totalEncontrados = 0;

    private List<Numeros> subLista;
    private int numeroBuscar;
    private int conteoLocal = 0;

    public BuscadorHilo(String nombre, List<Numeros> subLista, int numeroBuscar) {
        super(nombre);
        this.subLista = subLista;
        this.numeroBuscar = numeroBuscar;
    }

    @Override
    public void run() {
        for (Numeros num : subLista) {
            if (num.getNumeroscol0() == numeroBuscar) conteoLocal++;
            if (num.getNumeroscol1() == numeroBuscar) conteoLocal++;
            if (num.getNumeroscol2() == numeroBuscar) conteoLocal++;
            if (num.getNumeroscol3() == numeroBuscar) conteoLocal++;
            if (num.getNumeroscol4() == numeroBuscar) conteoLocal++;
            if (num.getNumeroscol5() == numeroBuscar) conteoLocal++;
        }

        synchronized (BuscadorHilo.class) {
            totalEncontrados += conteoLocal;
        }
    }

    public int getConteoLocal() {
        return conteoLocal;
    }

    public int getTamSubLista() {
        return subLista.size();
    }

    public static int getTotalEncontrados() {
        return totalEncontrados;
    }

    public static void resetTotal() {
        totalEncontrados = 0;
    }
}
