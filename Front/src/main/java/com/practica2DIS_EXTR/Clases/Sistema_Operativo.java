package com.practica2DIS_EXTR.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Sistema_Operativo {

    //atributos del sistema operativo

    @JsonProperty("nombreSO")
    public String nombreSO;

    @JsonProperty("versionSO")
    public String versionSO;

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
