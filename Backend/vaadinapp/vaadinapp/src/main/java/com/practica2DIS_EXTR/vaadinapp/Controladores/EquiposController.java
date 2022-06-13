package com.practica2DIS_EXTR.vaadinapp.Controladores;


import com.practica2DIS_EXTR.vaadinapp.Clases.Equipos;
import com.practica2DIS_EXTR.vaadinapp.Clases.Usuarios;
import com.practica2DIS_EXTR.vaadinapp.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class EquiposController {

    //clase controlador para los equipos

    Utils utils = new Utils();
    public ArrayList<Equipos> equipos;

    //controlador para mostrar los marcadores
    @GetMapping(value = "/equipos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Equipos> cargarEquipos(){

        equipos = utils.lecturaJSONEquipos();

        return equipos;

    }

    //para buscar por id cojo el ide del elemento encontrado
    @GetMapping(value = "/equipos/{id}")
    public Equipos buscarEquipoID (@PathVariable int id) throws IOException {


        Boolean encontrado = false;
        Equipos equipo = null;
        int identificador = id;

        ArrayList<Equipos> listaequipos = utils.lecturaJSONEquipos();

        int i = 0;
        while(!encontrado && i < listaequipos.size()){
            Equipos e = listaequipos.get(i);
            if(identificador == e.getIdEquipo()){
                encontrado = true;
                equipo = e;
            }
            i++;
        }



        return equipo;



    }
}
