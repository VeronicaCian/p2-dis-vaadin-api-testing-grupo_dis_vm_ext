package com.practica2DIS_EXTR.vaadinapp.Controladores;

import com.practica2DIS_EXTR.vaadinapp.Clases.Usuarios;
import com.practica2DIS_EXTR.vaadinapp.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    //clase controlador para los usuarios

    Utils utils = new Utils();
    public ArrayList<Usuarios> usuarios;

    //controlador para mostrar los marcadores
    @GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Usuarios> cargarUsuarios(){

        usuarios = utils.lecturaJSONUsuarios();

        return usuarios;

    }
}
