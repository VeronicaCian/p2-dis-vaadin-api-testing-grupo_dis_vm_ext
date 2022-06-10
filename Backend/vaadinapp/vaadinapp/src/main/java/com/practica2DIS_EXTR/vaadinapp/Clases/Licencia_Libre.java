package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Licencia_Libre {

    @JsonProperty("NombreSL")
    private String nombreSL;

    @JsonProperty("VersionSL")
    private String versionSL;



    private Licencia_Libre(){

    }

    public Licencia_Libre(String nombreSL, String versionSL){
        this.versionSL = versionSL;
        this.nombreSL = nombreSL;

    }



    public String getVersionSL() {
        return versionSL;
    }

    public void setVersionSL(String versionSL) {
        this.versionSL = versionSL;
    }

    public String getNombreSL() {
        return nombreSL;
    }

    public void setNombreSL(String nombreSL) {
        this.nombreSL = nombreSL;
    }
}
