package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Pantalla {

    @JsonProperty("Diagonal")
    public int Diagonal;

    @JsonProperty("Resolucion")
    public String Resolucion;

    private  Pantalla(){

    }

    public  Pantalla (int diagonal, String resolucion){
        this.Diagonal = diagonal;
        this.Resolucion = resolucion;
    }

    public int getDiagonal() {
        return Diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.Diagonal = diagonal;
    }

    public String getResolucion() {
        return Resolucion;
    }

    public void setResolucion(String resolucion) {
        this.Resolucion = resolucion;
    }
}
