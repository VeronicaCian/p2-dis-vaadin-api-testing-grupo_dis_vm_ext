package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Equipos {

    //atributos de equipos con sus respectivas llamadas a otras clases

    @JsonProperty("id_equipo")
<<<<<<< HEAD
    public int idEquipo;

    @JsonProperty("Tipo")
    public String tipo;

    @JsonProperty("Marca")
    public  String marca;

    @JsonProperty("Uso")
    public String uso;

    @JsonProperty("Sistema_operativo")
    public Sistema_Operativo sistemaoperativo;

    @JsonProperty("Hardware")
    public Hardware hardware;

    @JsonProperty("Software")
    public Software software;
=======
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
>>>>>>> e5be2907c81630faa14e5593c722c2d0895426b8

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
<<<<<<< HEAD
        this.idEquipo = idEquipo;
=======
        this.id_equipo = id_equipo;
>>>>>>> e5be2907c81630faa14e5593c722c2d0895426b8
    }
}