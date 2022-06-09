package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipos {

    @JsonProperty("id_Equipo")
    private int id_Equipo;

    @JsonProperty("Tipo")
    private String Tipo;

    @JsonProperty("Marca")
    private String Marca;

    @JsonProperty("Uso")
    private String Uso;


    private Equipos(){

    }
    public Equipos(int id_Equipo, String Tipo, String Marca, String Uso) {
        this.id_Equipo = id_Equipo;
        this.Tipo = Tipo;
        this.Marca = Marca;
        this.Uso = Uso;
    }

    public int getId_Equipo() {
        return id_Equipo;
    }

    public void setId_Equipo(int id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        Uso = uso;
    }
}
