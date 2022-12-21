package com.anavarros.connect4;

import java.util.Random;

/**
 * @author Alberto Navarro
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
        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == O) {
                    cntO++;
                } else if (m[i][j] == X) {
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
        if (columna > 0 || columna < m.length -1 ) {
            for (int i = 0; i < m.length - 1; i++) {
                if (m[columna][i] != X && m[columna][i] != O) {
                    return true;
                }
            }
        }
        return false;
    }

    public void inserta(char ficha, int columna) {
        estaColumnaLibre(columna);
        //columna de 0 a 6
        for (int i = 0; i < 6; i++) {
            if (m[columna][i] == L) {
                m[columna][i] = ficha;
                contador++;
                return;
            }
        }
    }


    public boolean estaLleno() {
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if(hay4Horizontales(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(m[columna+i][fila] == jugador){
                cnt++;
                if(cnt == 4){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ganaVertical(char jugador) {
        for (int i = 0; i < 7; i++) {
            // 7 = {0...6}
            for (int j = 0; j < 4-1; j++) {
                if(hay4Verticales(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(m[columna][fila+i] == jugador){
                cnt++;
                if(cnt == 4){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(hay4DiagonalesArriba(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(m[columna+i][fila+i] == jugador){
                cnt++;
                if(cnt == 4){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = 5; j > 2; j--) {
                if(hay4DiagonalesAbajo(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(m[columna+i][fila-i] == jugador){
                cnt++;
                if(cnt == 4){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaFinalizado() {
        return gana(X) || gana(O) || estaLleno();
    }

}
