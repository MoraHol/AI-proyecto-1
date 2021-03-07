package com.uniminuto.controller;

import com.uniminuto.mundo.Tablero;

public class Solucionador {

    private boolean solucionado = false;

    private Tablero tablero;
    public Solucionador(){
        tablero = new Tablero(8);
    }

    public void setPosicionInicial(int y){
        tablero.setPosicion(0,y);
    }

    /**
     * Soluciona el tablero de las ocho reinas
     * @param i posicion de la fila de la reina en donde se esta buscando
     */
    public void solucionar(int i)
    {
        // se recorre el tablero en sus columnas
        for (int j = 0; j <= (tablero.getDimension()-1); j++)
        {
            // se verifica si es esa posicion se puede colocar la reina
            if (tablero.setPosicion(i, j))
            {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // si esta bien procedemos
                solucionar(i+1);
                if (tablero.getReinasColocadas() == tablero.getDimension()){
                    solucionado = true;
                    return;
                }


                tablero.quitPosicion(i,j);
            }
        }
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public Tablero getTablero() {
        return tablero;
    }
}
