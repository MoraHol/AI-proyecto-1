package com.uniminuto.mundo;


import com.uniminuto.mundo.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private int dimension;

    private List<Posicion> cuadricula = new ArrayList<>();

    public Tablero(int dimension) {
        this.dimension = dimension;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++)
                cuadricula.add(new Posicion(i, j));
        }

        resetTablero();
    }

    public Integer getReinasColocadas() {
        int i = 0;
        for (Posicion c : cuadricula)
            i += c.isOcupado() ? 1 : 0;

        return i;
    }


    private void resetTablero() {
        for (Posicion c : this.cuadricula)
            c.setOcupado(false);
    }

    public boolean setPosicion(int i, int j) {
        if (i > (this.dimension - 1) || i < 0 || j > (this.dimension - 1) || j < 0)
            return false;


        Posicion posicion = getPosicion(i, j);

        posicion.setOcupado(Validator.validarPosicion(posicion, this));

        return posicion.isOcupado();
    }

    public void quitPosicion(int i, int j) {
        if (i > (this.dimension - 1) || i < 0 || j > (this.dimension - 1) || j < 0)
            return;

        Posicion cuadro = getPosicion(i, j);

        cuadro.setOcupado(false);
    }

    public Posicion getPosicion(int i, int j) {
        Posicion cuadro = null;
        for (Posicion c : cuadricula) {
            if (c.getX() == i && c.getY() == j) {
                cuadro = c;
                break;
            }
        }
        return cuadro;
    }

    public int getDimension() {
        return dimension;
    }
}
