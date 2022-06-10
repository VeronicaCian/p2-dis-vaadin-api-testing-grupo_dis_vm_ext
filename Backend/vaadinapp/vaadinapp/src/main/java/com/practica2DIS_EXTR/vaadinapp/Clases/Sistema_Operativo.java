package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sistema_Operativo {

    //atributos del sistema operativo

    @JsonProperty("nombreSO")
    private String nombreSO;

    @JsonProperty("versionSO")
    private String versionSO;

    private Sistema_Operativo(){

    }

    public Sistema_Operativo(String nombreSO, String versionSO){
        this.nombreSO = nombreSO;
        this.versionSO = versionSO;
    }

    //getters y setters

    public String getVersionSO() {
        return versionSO;
    }

    public void setVersionSO(String versionSO) {
        this.versionSO = versionSO;
    }

    public String getNombreSO() {
        return nombreSO;
    }

    public void setNombreSO(String nombreSO) {
        this.nombreSO = nombreSO;
    }
}
