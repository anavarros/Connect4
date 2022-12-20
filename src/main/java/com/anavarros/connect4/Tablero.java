package com.anavarros.connect4;

import java.util.Random;

/**
 * @author Nombre Apellido
 */
public class Tablero {

    public final static char O = 'O';
    public final static char X = 'X';
    public final static char L = ' ';
    private final static int W = 7;
    private final static int H = 6;
    private int contador;
    private char turno;
    private final int ancho;
    private final int alto;
    private final char[][] m;

    public Tablero() {
        contador = 0;
        turno = O;
        ancho = W;
        alto = H;
        m = new char[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                m[i][j] = L;
            }
        }
    }

    public Tablero(char[][] m) {
        //TODO: Tablero(m)
        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[j].equals(O)) {
                    cntO++;
                } else if (m[j].equals(X)) {
                    cntX++;
                } else {
                    cntX += 0;
                    cntO += 0;
                }
            }
            if (m[i].equals(O)) {
                cntO++;
            } else if (m[i].equals(X)) {
                cntX++;
            } else {
                cntX += 0;
                cntO += 0;
            }
        }
        contador = cntX + cntO;
        if (cntX > cntO){
            turno = O;
        } else {
            turno = X;
        }
        ancho = W;
        alto = H;
        this.m = m;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getContador() {
        return contador;
    }

    public char[][] getMatriz(){
        return m;
    }

    public char getTurno() {
        return turno;
    }

    public void iniciaTurno() {
        Random rnd = new Random();
        int num = rnd.nextInt(2);
        if (num == 0) {
            turno = O;
        } else if (num == 1){
            turno = X;
        }
    }

    public void cambiaTurno() {
        if (turno == X) {
            turno = O;
        } else if (turno == O) {
            turno = X;
        }
    }

    public boolean estaColumnaLibre(int columna) {
        //TODO: estaColumnaLibre
        int esCierto = 0;
        if (columna >= 0 || columna < m.length - 1) {
            return false;
        }
        for (int i = 0; i < m[0].length - 1; i++) {
            if (m[i].equals(L)) {
                 esCierto = 1;
            }
        }
        if (esCierto == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void inserta(char ficha, int columna) {
        //TODO: insertar
        estaColumnaLibre(columna);
        m[W][H] = ficha;
        contador++;
     }

    public boolean estaLleno() {
        //TODO: estaLleno
        return contador == alto*ancho;
    }

    public boolean gana(char jugador) {
        boolean b;
        b = ganaHorizontal(jugador);
        b = b || ganaVertical(jugador);
        b = b || ganaDiagonalArriba(jugador);
        b = b || ganaDiagonalAbajo(jugador);
        return b;
    }

    private boolean ganaHorizontal(char jugador) {
        //TODO: ganaHorizontal
        boolean b = false;
        return b;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
        //TODO: hay4Horizontales
        return true;
    }

    private boolean ganaVertical(char jugador) {
        //TODO: ganaVertical
        boolean b = false;
        return b;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        //TODO: hay4Verticales
        return true;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        //TODO: ganaDiagonalArriba
        boolean b = false;
        return b;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesArriba
        return true;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        //TODO: ganaDiagonalAbajo
        boolean b = false;
        return b;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesAbajo
        return true;
    }

    public boolean estaFinalizado() {
        //TODO: finalizado
        return false;
    }

}
