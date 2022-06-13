package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hardware {

    @JsonProperty("Procesador")
    public String procesador;

    @JsonProperty("Memoria")
    public double memoria;

    @JsonProperty("Disco_Duro")
    public Disco_Duro discoduro;

    @JsonProperty("Pantalla")
    public Pantalla pantalla;

    private Hardware(){

    }

    public Hardware(String procesador, double memoria, Disco_Duro discoduro, Pantalla pantalla){
        this.pantalla = pantalla;
        this.procesador = procesador;
        this.memoria = memoria;
        this.discoduro = discoduro;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }

    public Disco_Duro getDiscoduro() {
        return discoduro;
    }

    public void setDiscoduro(Disco_Duro discoduro) {
        this.discoduro = discoduro;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
