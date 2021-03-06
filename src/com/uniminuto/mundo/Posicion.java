package com.uniminuto.mundo;

public class Posicion {
    private int x;
    private int y;
    private boolean ocupado;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
        this.ocupado = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
