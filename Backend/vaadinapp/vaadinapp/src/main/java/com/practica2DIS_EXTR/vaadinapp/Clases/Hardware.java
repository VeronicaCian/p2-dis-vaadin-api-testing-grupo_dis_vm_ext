package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Hardware {

    @JsonProperty("Procesador")
    public String   Procesador;

    @JsonProperty("Memoria")
    public double Memoria;

    @JsonProperty("Disco_Duro")
    public Disco_Duro Disco_Duro;

    @JsonProperty("Pantalla")
    public Pantalla Pantalla;

    private Hardware(){

    }

    public Hardware(String procesador, double memoria, Disco_Duro discoduro, Pantalla pantalla){
        this.Pantalla = pantalla;
        this.Procesador = procesador;
        this.Memoria = memoria;
        this.Disco_Duro = discoduro;
    }

    public Pantalla getPantalla() {
        return Pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.Pantalla = pantalla;
    }

    public double getMemoria() {
        return Memoria;
    }

    public void setMemoria(double memoria) {
        this.Memoria = memoria;
    }

    public Disco_Duro getDiscoduro() {
        return Disco_Duro;
    }

    public void setDiscoduro(Disco_Duro discoduro) {
        this.Disco_Duro = discoduro;
    }

    public String getProcesador() {
        return Procesador;
    }

    public void setProcesador(String procesador) {
        this.Procesador = procesador;
    }
}
