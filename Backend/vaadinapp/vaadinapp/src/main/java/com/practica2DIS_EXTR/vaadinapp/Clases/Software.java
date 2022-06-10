package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Software {

    @JsonProperty("Licencia_Pago")
    private Licencia_Pago licenciapago;

    @JsonProperty("Licencia_Libre")
    private Licencia_Libre licencialibre;

    private Software(){

    }

    public Software(Licencia_Pago licenciapago, Licencia_Libre licencialibre){
        this.licencialibre = licencialibre;
        this.licenciapago = licenciapago;
    }

    public Licencia_Pago getLicenciapago() {
        return licenciapago;
    }

    public void setLicenciapago(Licencia_Pago licenciapago) {
        this.licenciapago = licenciapago;
    }

    public Licencia_Libre getLicencialibre() {
        return licencialibre;
    }

    public void setLicencialibre(Licencia_Libre licencialibre) {
        this.licencialibre = licencialibre;
    }
}
