package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pantalla {

    @JsonProperty("Diagonal")
    public int diagonal;

    @JsonProperty("Resolucion")
    public String resolucion;

    private  Pantalla(){

    }

    public  Pantalla (int diagonal, String resolucion){
        this.diagonal = diagonal;
        this.resolucion = resolucion;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
}
