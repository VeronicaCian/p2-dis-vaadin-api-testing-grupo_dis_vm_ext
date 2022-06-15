package com.practica2DIS_EXTR.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Disco_Duro {

    @JsonProperty("tipo_disco")
    private String tipodisco;

    @JsonProperty("capacidad")
    private String capacidad;

    private Disco_Duro(){

    }

    public Disco_Duro(String tipodisco, String capacidad){
        this.capacidad = capacidad;
        this.tipodisco = tipodisco;
    }

    public String getTipodisco() {
        return tipodisco;
    }

    public void setTipodisco(String tipodisco) {
        this.tipodisco = tipodisco;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
}
