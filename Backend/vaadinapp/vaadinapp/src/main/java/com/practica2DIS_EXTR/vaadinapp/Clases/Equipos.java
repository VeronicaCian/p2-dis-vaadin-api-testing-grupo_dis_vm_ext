package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Equipos {

    //atributos de equipos con sus respectivas llamadas a otras clases

    @JsonProperty("id_equipo")
    private int id_equipo;

    @JsonProperty("Tipo")
    private String Tipo;

    @JsonProperty("Marca")
    private  String Marca;

    @JsonProperty("Uso")
    private String Uso;

    @JsonProperty("Sistema_operativo")
    private Sistema_Operativo Sistema_operativo;

    @JsonProperty("Hardware")
    private Hardware Hardware;

    @JsonProperty("Software")
    private Software Software;

    private Equipos(){

    }

    public Equipos(int id_equipo,String Tipo, String Marca, String Uso, Sistema_Operativo Sistema_operativo, Hardware Hardware, Software Software){
        this.id_equipo = id_equipo;
        this.Tipo = Tipo;
        this.Marca = Marca;
        this.Sistema_operativo = Sistema_operativo;
        this.Hardware = Hardware;
        this.Software = Software;
        this.Uso = Uso;
    }

    public Software getSoftware() {
        return Software;
    }

    public void setSoftware(Software software) {
        this.Software = Software;
    }

    public Hardware getHardware() {
        return Hardware;
    }

    public void setHardware(Hardware hardware) {
        this.Hardware = hardware;
    }

    public Sistema_Operativo getSistema_operativo() {
        return Sistema_operativo;
    }

    public void setSistemaoperativo(Sistema_Operativo sistemaoperativo) {
        this.Sistema_operativo = Sistema_operativo;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        this.Uso = Uso;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public int getIdEquipo() {
        return id_equipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.id_equipo = id_equipo;
    }
}