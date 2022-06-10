package com.practica2DIS_EXTR.vaadinapp.Clases;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
=======
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

>>>>>>> e5e7b24bc52fb6144610b586492af9e98400f874

    private Equipos(){

    }
<<<<<<< HEAD

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
=======
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
>>>>>>> e5e7b24bc52fb6144610b586492af9e98400f874
    }
}
