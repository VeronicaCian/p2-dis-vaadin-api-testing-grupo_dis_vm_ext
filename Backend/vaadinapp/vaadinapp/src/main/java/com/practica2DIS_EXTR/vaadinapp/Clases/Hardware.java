package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hardware {

    @JsonProperty("Procesador")
    private String procesador;

    @JsonProperty("Memoria")
    private double memoria;

    @JsonProperty("Disco_Duro")
    private Disco_Duro discoduro;

    @JsonProperty("Pantalla")
    private Pantalla pantalla;

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
