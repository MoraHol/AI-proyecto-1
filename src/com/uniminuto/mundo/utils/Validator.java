package com.uniminuto.mundo.utils;

import com.uniminuto.mundo.Posicion;
import com.uniminuto.mundo.Tablero;

/**
 * Clase de utilidades para la validación de posicones de las reinas en el tablero
 * @author alexis
 */
public class Validator {
    /**
     * Valida si es posible colocar una reina en una cierta posicion
     *
     * @param posicion posicion en la que se quiere colocar la reina
     * @param tablero  tablero en el que se quiere validar
     * @return true si se puede colocar y flase si no se puede colocar
     */
    public static boolean validarPosicion(Posicion posicion, Tablero tablero) {
        return (validaVertical(posicion, tablero) && validaHorizontal(posicion, tablero)
                && validaDiagonalDerecha(posicion, tablero) && validaDiagonalIzquierda(posicion, tablero));
    }

    /**
     * Valida si se puede colocar una reina en sus lineas verticales
     *
     * @param posicion posicion en la que se quiere colocar la reina
     * @param tablero  tablero en el que se quiere validar
     * @return true si se puede colocar y flase si no se puede colocar
     */
    private static boolean validaVertical(Posicion posicion, Tablero tablero) {

        int i = posicion.getX();
        int j = posicion.getY();

        // valida la parte superios
        if (j > 0)
            // recorre el tablero buscando que no hayan reinas
            for (int j2 = j; j2 >= 0; j2--) {
                Posicion c = tablero.getPosicion(i, j2);
                if (c.isOcupado())
                    return false;
            }
        // valida la parte inferior
        if (j < 7)
            // recorre el tablero buscando que no hayan reinas
            for (int j2 = j; j2 <= (tablero.getDimension() - 1); j2++) {
                Posicion c = tablero.getPosicion(i, j2);
                if (c.isOcupado())
                    return false;
            }

        return true;
    }

    /**
     * Valida si se puede colocar una reina en sus lineas horizontales
     *
     * @param posicion posicion en la que se quiere colocar la reina
     * @param tablero  tablero en el que se quiere validar
     * @return true si se puede colocar y flase si no se puede colocar
     */
    private static boolean validaHorizontal(Posicion posicion, Tablero tablero) {
        int i = posicion.getX();
        int j = posicion.getY();
        // valida la parte izquierda
        if (i > 0)
            // recorre el tablero buscando que no hayan reinas
            for (int i2 = i; i2 >= 0; i2--) {
                Posicion c = tablero.getPosicion(i2, j);
                if (c.isOcupado())
                    return false;
            }
        // valida la parte derecha
        if (i < 7)
            // recorre el tablero buscando que no hayan reinas
            for (int i2 = i; i2 <= (tablero.getDimension() - 1); i2++) {
                Posicion c = tablero.getPosicion(i2, j);
                if (c.isOcupado())
                    return false;
            }

        return true;
    }

    /**
     * Valida si se puede colocar una reina en sus diagonales derechas
     *
     * @param posicion posicion en la que se quiere colocar la reina
     * @param tablero  tablero en el que se quiere validar
     * @return true si se puede colocar y flase si no se puede colocar
     */
    private static boolean validaDiagonalDerecha(Posicion posicion, Tablero tablero) {


        int i2, j2;

        int i = posicion.getX();
        int j = posicion.getY();

        if (i != 0 && j != (tablero.getDimension() - 1)) {
            j2 = j;
            // recorre el tablero buscando que no hayan reinas
            for (i2 = i; i2 >= 0; i2--) {
                Posicion c = tablero.getPosicion(i2, j2);
                if (c.isOcupado())
                    return false;
                if (i2 == 0 || j2 == (tablero.getDimension() - 1))
                    break;

                j2++;

            }

        }
        if (i != (tablero.getDimension() - 1) && j != 0) {
            j2 = j;
            // recorre el tablero buscando que no hayan reinas
            for (i2 = i; i2 <= (tablero.getDimension() - 1); i2++) {
                Posicion c = tablero.getPosicion(i2, j2);
                if (c.isOcupado())
                    return false;


                if (i2 == (tablero.getDimension() - 1) || j2 == 0)
                    break;
                j2--;

            }
        }
        return true;
    }

    /**
     * Valida si se puede colocar una reina en sus diagonales izquierdas
     *
     * @param posicion posicion en la que se quiere colocar la reina
     * @param tablero  tablero en el que se quiere validar
     * @return true si se puede colocar y flase si no se puede colocar
     */
    private static boolean validaDiagonalIzquierda(Posicion posicion, Tablero tablero) {
        int i2, j2;

        int i = posicion.getX();
        int j = posicion.getY();

        // si no es la esquina inferior
        if (i != (tablero.getDimension() - 1) && j != (tablero.getDimension() - 1)) {
            j2 = j;
            // recorre el tablero buscando que no hayan reinas
            for (i2 = i; i2 <= (tablero.getDimension() - 1); i2++) {
                Posicion c = tablero.getPosicion(i2, j2);
                if (c.isOcupado())
                    return false;
                if (i2 == (tablero.getDimension() - 1) || j2 == (tablero.getDimension() - 1))
                    break;

                j2++;

            }

        }
        // si no es la esquina superior
        if (i != 0 && j != 0) {
            j2 = j;
            // recorre el tablero buscando que no hayan reinas
            for (i2 = i; i2 >= 0; i2--) {
                Posicion c = tablero.getPosicion(i2, j2);
                if (c.isOcupado())
                    return false;

                if (i2 == 0 || j2 == 0)
                    break;
                j2--;

            }
        }
        return true;
    }
}
