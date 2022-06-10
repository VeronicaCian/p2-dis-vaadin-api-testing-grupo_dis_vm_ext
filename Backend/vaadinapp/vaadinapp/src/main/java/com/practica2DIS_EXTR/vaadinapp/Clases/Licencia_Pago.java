package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Licencia_Pago {

    @JsonProperty("NombreSP")
    private String nombreSP;

    @JsonProperty("VersionSP")
    private String versionSP;

    @JsonProperty("TipoSP")
    private String tipoSP;

    private Licencia_Pago(){

    }

    public Licencia_Pago(String nombreSP, String versionSP,String tipoSP){
        this.versionSP = versionSP;
        this.nombreSP = nombreSP;
        this.tipoSP = tipoSP;
    }

    public String getTipoSP() {
        return tipoSP;
    }

    public void setTipoSP(String tipoSP) {
        this.tipoSP = tipoSP;
    }

    public String getVersionSP() {
        return versionSP;
    }

    public void setVersionSP(String versionSP) {
        this.versionSP = versionSP;
    }

    public String getNombreSP() {
        return nombreSP;
    }

    public void setNombreSP(String nombreSP) {
        this.nombreSP = nombreSP;
    }
}
