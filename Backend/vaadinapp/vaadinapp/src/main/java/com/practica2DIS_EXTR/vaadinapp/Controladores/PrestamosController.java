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

    @PostMapping(value = "/prestamo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    //Controlador PUT para modificar un objeto del Json

    @PutMapping(path = "/prestamos",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity modifyPrestamo (@RequestBody Prestamos prestamoModificado) throws IOException {

        ArrayList<Prestamos> listamodified = utils.lecturaJSONPrestamos();


        int id = prestamoModificado.getId();

        for (Prestamos m : listamodified) {
            if(m.getId()==id){
                m.setUsuario_Id(prestamoModificado.getUsuario_Id());
                m.setFecha_Inicio_Prestamo(prestamoModificado.getFecha_Inicio_Prestamo());
                m.setFecha_Fin_Prestamo(prestamoModificado.getFecha_Fin_Prestamo());
                m.setFecha_Real_Dev(prestamoModificado.getFecha_Real_Dev());
                m.setComentarios(prestamoModificado.getComentarios());
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();                 //Hacemos que aparezca bonito en vez de en una linea
        FileWriter writer = null;                                                  //Inicializamos el filewriter
        String archivo = "Prestamos.json";

        try{
            writer = new FileWriter(archivo);
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(listamodified,writer);

        try {
            writer.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    //Para buscar por id selecciono el id del elemento encontrado

    @GetMapping(value = "/prestamos/{id}")
    public Prestamos buscarPrestamoId (@PathVariable int id) throws IOException{

        Boolean encontrado = false;
        Prestamos user = null;
        int identificador = id;

        ArrayList<Prestamos> listaprestamos = utils.lecturaJSONPrestamos();

        int i = 0;
        while(!encontrado && i < listaprestamos.size()){
            Prestamos u = listaprestamos.get(i);
            if(identificador == u.getId()){
                encontrado = true;
                user = u;
            }
            i++;
        }

        return user;

    }

}
