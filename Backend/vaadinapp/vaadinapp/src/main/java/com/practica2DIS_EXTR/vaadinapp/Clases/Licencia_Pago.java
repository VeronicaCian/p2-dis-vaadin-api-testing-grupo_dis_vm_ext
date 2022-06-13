package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Licencia_Pago {

    @JsonProperty("NombreSP")
    public String NombreSP;

    @JsonProperty("VersionSP")
    public String VersionSP;

    @JsonProperty("TipoSP")
    public String TipoSP;

    private Licencia_Pago(){

    }

    public Licencia_Pago(String nombreSP, String versionSP,String tipoSP){
        this.VersionSP = versionSP;
        this.NombreSP = nombreSP;
        this.TipoSP = tipoSP;
    }

    public String getTipoSP() {
        return TipoSP;
    }

    public void setTipoSP(String tipoSP) {
        this.TipoSP = tipoSP;
    }

    public String getVersionSP() {
        return VersionSP;
    }

    public void setVersionSP(String versionSP) {
        this.VersionSP = versionSP;
    }

    public String getNombreSP() {
        return NombreSP;
    }

    public void setNombreSP(String nombreSP) {
        this.NombreSP = nombreSP;
    }
}
