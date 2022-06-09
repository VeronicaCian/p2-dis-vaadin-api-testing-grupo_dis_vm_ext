package com.practica2DIS_EXTR.vaadinapp.Controladores;

import com.practica2DIS_EXTR.vaadinapp.Clases.Prestamos;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")

public class PrestamosController {

    //clase con los marcadores
    Utils utils = new Utils();
    public ArrayList<Prestamos> prestamos;

    //controlador para mostrar los marcadores
    @GetMapping(value = "/prestamos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Prestamos> cargarPrestamos(){

        prestamos = utils.lecturaJSONPrestamos();

        return prestamos;

    }

}
