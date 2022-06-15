package com.practica2DIS_EXTR.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Licencia_Libre {

    @JsonProperty("NombreSL")
    public String NombreSL;

    @JsonProperty("VersionSL")
    public String VersionSL;



    private Licencia_Libre(){

    }

    public Licencia_Libre(String nombreSL, String versionSL){
        this.VersionSL = versionSL;
        this.NombreSL = nombreSL;

    }



    public String getVersionSL() {
        return VersionSL;
    }

    public void setVersionSL(String versionSL) {
        this.VersionSL = versionSL;
    }

    public String getNombreSL() {
        return NombreSL;
    }

    public void setNombreSL(String nombreSL) {
        this.NombreSL = nombreSL;
    }
}
