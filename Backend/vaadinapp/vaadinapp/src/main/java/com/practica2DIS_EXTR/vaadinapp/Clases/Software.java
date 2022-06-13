package com.practica2DIS_EXTR.vaadinapp.Clases;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

public class Software {

    @JsonProperty("Licencia_Pago")
    public Licencia_Pago Licencia_Pago;

    @JsonProperty("Licencia_Libre")
    public Licencia_Libre Licencia_Libre;

    private Software(){

    }

    public Software(Licencia_Pago licenciapago, Licencia_Libre licencialibre){
        this.Licencia_Libre = licencialibre;
        this.Licencia_Pago = licenciapago;
    }

    public Licencia_Pago getLicenciapago() {
        return Licencia_Pago;
    }

    public void setLicenciapago(Licencia_Pago licenciapago) {
        this.Licencia_Pago = licenciapago;
    }

    public Licencia_Libre getLicencialibre() {
        return Licencia_Libre;
    }

    public void setLicencialibre(Licencia_Libre licencialibre) {
        this.Licencia_Libre = licencialibre;
    }
}
