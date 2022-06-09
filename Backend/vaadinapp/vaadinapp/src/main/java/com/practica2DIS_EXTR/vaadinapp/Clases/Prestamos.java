package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prestamos {

    @JsonProperty("id")
    private int id;

    @JsonProperty("Usuario_Id")
    private int Usuario_Id;

    @JsonProperty("Fecha_Inicio_Prestamo")
    private String Fecha_Inicio_Prestamo;

    @JsonProperty("Fecha_Fin_Prestamo")
    private String Fecha_Fin_Prestamo;

    @JsonProperty("Fecha_Real_Dev")
    private String Fecha_Real_Dev;

    @JsonProperty("Comentarios")
    private String Comentarios;


    private Prestamos(){

    }
    public Prestamos(int id, int Usuario_Id, String Fecha_Inicio_Prestamo, String Fecha_Fin_Prestamo, String Fecha_Real_Dev, String Comentarios) {
        this.id = id;
        this.Usuario_Id = Usuario_Id;
        this.Fecha_Inicio_Prestamo = Fecha_Inicio_Prestamo;
        this.Fecha_Fin_Prestamo = Fecha_Fin_Prestamo;
        this.Fecha_Real_Dev = Fecha_Real_Dev;
        this.Comentarios = Comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        Usuario_Id = usuario_Id;
    }

    public String getFecha_Inicio_Prestamo() {
        return Fecha_Inicio_Prestamo;
    }

    public void setFecha_Inicio_Prestamo(String fecha_Inicio_Prestamo) {
        Fecha_Inicio_Prestamo = fecha_Inicio_Prestamo;
    }

    public String getFecha_Fin_Prestamo() {
        return Fecha_Fin_Prestamo;
    }

    public void setFecha_Fin_Prestamo(String fecha_Fin_Prestamo) {
        Fecha_Fin_Prestamo = fecha_Fin_Prestamo;
    }

    public String getFecha_Real_Dev() {
        return Fecha_Real_Dev;
    }

    public void setFecha_Real_Dev(String fecha_Real_Dev) {
        Fecha_Real_Dev = fecha_Real_Dev;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }
}
