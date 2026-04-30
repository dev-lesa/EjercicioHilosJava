/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Luis
 */
import BaseDatos.BDNumeros;
import Clases.Numeros;
import Clases.BuscadorHilo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogNumeros {

    BDNumeros objBDNumeros = new BDNumeros();

    private List<BuscadorHilo> ultimosHilos = new ArrayList<>();

    public List<Numeros> ListarTodos() throws ClassNotFoundException, SQLException {
        List<Numeros> listaNumeros = new ArrayList<>();
        ResultSet rs = objBDNumeros.ListarTodos();

        while (rs.next()) {
            Numeros num = new Numeros(
                    rs.getInt("idFila"),
                    rs.getInt("Numeroscol0"),
                    rs.getInt("Numeroscol1"),
                    rs.getInt("Numeroscol2"),
                    rs.getInt("Numeroscol3"),
                    rs.getInt("Numeroscol4"),
                    rs.getInt("Numeroscol5")
            );
            listaNumeros.add(num);
        }
        rs.close();
        return listaNumeros;
    }

    public int ObtenerTotal() throws ClassNotFoundException, SQLException {
        int total = 0;
        ResultSet rs = objBDNumeros.ObtenerTotal();

        while (rs.next()) {
            total = rs.getInt("total");
        }
        rs.close();
        return total;
    }

    public int BuscarCuantas(int numeroBuscar, int cantHilos)
            throws ClassNotFoundException, SQLException, InterruptedException {

        List<Numeros> listaCompleta = ListarTodos();
        BuscadorHilo.resetTotal();
        ultimosHilos.clear();

        int tamPorHilo = listaCompleta.size() / cantHilos;

        for (int i = 0; i < cantHilos; i++) {
            int inicio = i * tamPorHilo;
            int fin = (i == cantHilos - 1) ? listaCompleta.size() : inicio + tamPorHilo;

            List<Numeros> subLista = new ArrayList<>(listaCompleta.subList(inicio, fin));
            BuscadorHilo hilo = new BuscadorHilo("Hilo " + (i + 1), subLista, numeroBuscar);
            ultimosHilos.add(hilo);
        }

        for (BuscadorHilo h : ultimosHilos) {
            h.start();
        }

        for (BuscadorHilo h : ultimosHilos) {
            h.join();
        }

        return BuscadorHilo.getTotalEncontrados();
    }

    public List<BuscadorHilo> getUltimosHilos() {
        return ultimosHilos;
    }
}
