package com.practica2DIS_EXTR.vaadinapp.Controladores;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practica2DIS_EXTR.vaadinapp.Clases.Usuarios;
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

    @PutMapping(path = "/usuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifyUsuario (@RequestBody Usuarios usuariomodificado) throws IOException {


        ArrayList<Usuarios> listamodified = utils.lecturaJSONUsuarios();


        int id = usuariomodificado.getId();

        for (Usuarios user : listamodified) {
            if(user.getId()==id){
                user.setNombre(usuariomodificado.getNombre());
                user.setDepartamento(usuariomodificado.getDepartamento());
                user.setUbicacion(usuariomodificado.getUbicacion());
                user.setTelefono(usuariomodificado.getTelefono());
                user.setEmail(usuariomodificado.getEmail());
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //hacmeos que aparezca bonito en vez de en una linea
        FileWriter writer = null; //inicializamos el filewriter
        String archivo = "Usuarios.json";

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

    //instancion la varible de Java para incrementar el id al añadir uno nuevo
    private final AtomicInteger nuevoID = new AtomicInteger();

    //controlador POST para añadir un nuevo objeto al json
    @PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> newUser(@RequestBody Usuarios usuario) throws IOException{

        //instancio una nueva lectura dle JSON
        ArrayList<Usuarios> arrayusuarios = utils.lecturaJSONUsuarios();

        usuario.setId(this.nuevoID.getAndIncrement()); //incrementamos el id para este nuevo onjeto
        arrayusuarios.add(usuario); //añadimos este nuevo marcador al array
        //modificamos el json con estenuevo marcador

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //hacmeos que aparezca bonito en vez de en una linea
        FileWriter writer = null; //inicializamos el filewriter
        String archivo = "Usuarios.json";

        try{
            writer = new FileWriter(archivo);
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(arrayusuarios,writer);

        try {
            writer.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }


        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //para buscar por id cojo el ide del elemento encontrado
    @DeleteMapping(value = "/usuarios/{id}")
    public ResponseEntity deleteMarcador (@PathVariable int id) throws IOException{


        Boolean encontrado = false;
        Usuarios user = null;
        int identificador = id;

        ArrayList<Usuarios> listamarcadores = utils.lecturaJSONUsuarios();

        int i = 0;
        while(!encontrado && i < listamarcadores.size()){
            Usuarios u = listamarcadores.get(i);
            if(identificador == u.getId()){
                encontrado = true;
                user = u;
                listamarcadores.remove(user);
            }
            i++;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //hacmeos que aparezca bonito en vez de en una linea
        FileWriter writer = null; //inicializamos el filewriter
        String archivo = "Usuarios.json";

        try{
            writer = new FileWriter(archivo);
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(listamarcadores,writer);

        try {
            writer.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.ACCEPTED);



    }

    //para buscar por id cojo el ide del elemento encontrado
    @GetMapping(value = "/usuarios/{id}")
    public Usuarios buscarUsuarioID (@PathVariable int id) throws IOException{


        Boolean encontrado = false;
        Usuarios user = null;
        int identificador = id;

        ArrayList<Usuarios> listausuarios = utils.lecturaJSONUsuarios();

        int i = 0;
        while(!encontrado && i < listausuarios.size()){
            Usuarios u = listausuarios.get(i);
            if(identificador == u.getId()){
                encontrado = true;
                user = u;
            }
            i++;
        }



        return user;



    }

}
