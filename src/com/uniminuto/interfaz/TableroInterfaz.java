package com.uniminuto.interfaz;

import com.uniminuto.controller.Solucionador;
import com.uniminuto.mundo.Posicion;

public class TableroInterfaz {
    Thread hiloImpresion, hiloSolucion;
    Solucionador solucionador = new Solucionador();



    public void init(int y){
        solucionador.setPosicionInicial(y);
        Runnable runnableSolucion = () -> solucionador.solucionar(1);
        hiloSolucion = new Thread(runnableSolucion);
        Runnable runnableImpresion = () -> {
            while (!solucionador.isSolucionado()){
                imprimirTablero();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hiloImpresion = new Thread(runnableImpresion);
        hiloImpresion.start();
        hiloSolucion.start();
    }


    private void imprimirTablero(){
        String linea = "";
        //Esta parte simplemente imprime el tablero cuando ya colocó las 8 reinas.
        for (int i = 0; i <= (solucionador.getTablero().getDimension()-1); i++)
        {
            for (int j = 0; j <= (solucionador.getTablero().getDimension()-1); j++)
            {
                Posicion c = solucionador.getTablero().getPosicion(i, j);
                linea += c.isOcupado()?"1":"0";
                linea +="|";

            }
            System.out.println(linea);
            linea = "";
        }
        System.out.println();
    }
}
