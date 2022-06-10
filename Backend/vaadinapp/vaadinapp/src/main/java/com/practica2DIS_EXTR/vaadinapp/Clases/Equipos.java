package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Equipos {

    //atributos de equipos con sus respectivas llamadas a otras clases

    @JsonProperty("id_equipo")
    private int idEquipo;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("Marca")
    private  String marca;

    @JsonProperty("Uso")
    private String uso;

    @JsonProperty("Sistema_operativo")
    private Sistema_Operativo sistemaoperativo;

    @JsonProperty("Hardware")
    private Hardware hardware;

    @JsonProperty("Software")
    private Software software;

    private Equipos(){

    }

    public Equipos(int idEquipo,String tipo, String marca, String uso, Sistema_Operativo sistemaoperativo, Hardware hardware, Software software){
        this.idEquipo = idEquipo;
        this.tipo = tipo;
        this.marca = marca;
        this.sistemaoperativo = sistemaoperativo;
        this.hardware = hardware;
        this.software = software;
        this.uso = uso;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Sistema_Operativo getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(Sistema_Operativo sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}