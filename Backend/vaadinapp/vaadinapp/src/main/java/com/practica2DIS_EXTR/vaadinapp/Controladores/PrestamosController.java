package com.practica2DIS_EXTR.vaadinapp.Controladores;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practica2DIS_EXTR.vaadinapp.Clases.Prestamos;
import com.practica2DIS_EXTR.vaadinapp.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")

public class PrestamosController {

    //Clase - Prestamos

    Utils utils = new Utils();
    public ArrayList<Prestamos> prestamos;

    //Controlador para mostrar los prestamos

    @GetMapping(value = "/prestamos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Prestamos> cargarPrestamos(){

        prestamos = utils.lecturaJSONPrestamos();

        return prestamos;
    }

    //Instancion la varible de Java para incrementar el id al añadir uno nuevo
    private final AtomicInteger nuevoID = new AtomicInteger();

    //Controlador POST para añadir un nuevo objeto al json

    @PostMapping(value = "/newPrestamo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newPrestamo(@RequestBody Prestamos prestamos){

        //Instanciamos una nueva lectura dle JSON
        ArrayList<Prestamos> arrayprestamos = utils.lecturaJSONPrestamos();

        prestamos.setId(this.nuevoID.getAndIncrement());            //Incrementamos el id para este nuevo prestamo
        arrayprestamos.add(prestamos);                              //Añadimos este nuevo prestamo al array

        //Modificamos el json con este nuevo prestamo

        Gson gson = new GsonBuilder().setPrettyPrinting().create();     //Hacemos que aparezca bonito en vez de en una linea
        FileWriter writer = null;                                       //Inicializamos el filewriter
        String archivo = "Prestamos.json";

        try{
            writer = new FileWriter(archivo);
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(arrayprestamos,writer);

        try {
            writer.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }


        return new ResponseEntity(HttpStatus.OK);

    }

}
