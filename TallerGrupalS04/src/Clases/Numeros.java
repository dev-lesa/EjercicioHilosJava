/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Luis
 */
public class Numeros {
    private int idFila;
    private int Numeroscol0;
    private int Numeroscol1;
    private int Numeroscol2;
    private int Numeroscol3;
    private int Numeroscol4;
    private int Numeroscol5;

    public Numeros() {
    }

    public Numeros(int idFila, int Numeroscol0, int Numeroscol1, int Numeroscol2,
                   int Numeroscol3, int Numeroscol4, int Numeroscol5) {
        this.idFila = idFila;
        this.Numeroscol0 = Numeroscol0;
        this.Numeroscol1 = Numeroscol1;
        this.Numeroscol2 = Numeroscol2;
        this.Numeroscol3 = Numeroscol3;
        this.Numeroscol4 = Numeroscol4;
        this.Numeroscol5 = Numeroscol5;
    }

    public int getIdFila() {
        return idFila;
    }

    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }

    public int getNumeroscol0() {
        return Numeroscol0;
    }

    public void setNumeroscol0(int Numeroscol0) {
        this.Numeroscol0 = Numeroscol0;
    }

    public int getNumeroscol1() {
        return Numeroscol1;
    }

    public void setNumeroscol1(int Numeroscol1) {
        this.Numeroscol1 = Numeroscol1;
    }

    public int getNumeroscol2() {
        return Numeroscol2;
    }

    public void setNumeroscol2(int Numeroscol2) {
        this.Numeroscol2 = Numeroscol2;
    }

    public int getNumeroscol3() {
        return Numeroscol3;
    }

    public void setNumeroscol3(int Numeroscol3) {
        this.Numeroscol3 = Numeroscol3;
    }

    public int getNumeroscol4() {
        return Numeroscol4;
    }

    public void setNumeroscol4(int Numeroscol4) {
        this.Numeroscol4 = Numeroscol4;
    }

    public int getNumeroscol5() {
        return Numeroscol5;
    }

    public void setNumeroscol5(int Numeroscol5) {
        this.Numeroscol5 = Numeroscol5;
    }

    @Override
    public String toString() {
        return "Numeros{" +
                "idFila=" + idFila +
                ", Numeroscol0=" + Numeroscol0 +
                ", Numeroscol1=" + Numeroscol1 +
                ", Numeroscol2=" + Numeroscol2 +
                ", Numeroscol3=" + Numeroscol3 +
                ", Numeroscol4=" + Numeroscol4 +
                ", Numeroscol5=" + Numeroscol5 +
                '}';
    }
}
