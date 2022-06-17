package com.practica2DIS_EXTR;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.practica2DIS_EXTR.Clases.Equipos;
import com.practica2DIS_EXTR.Clases.Prestamos;
import com.practica2DIS_EXTR.Clases.Sistema_Operativo;
import com.practica2DIS_EXTR.Clases.Usuarios;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.ButtonOptions;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Pre;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    private static final String URL = "http://localhost:8081/api/%s";
    private static final String URL2 = "http://localhost:8081/api/%s/%i";
    //private static HttpRequest request;
    HttpRequest request;
    HttpClient cliente = HttpClient.newBuilder().build();
    HttpResponse<String> response;

    //metodo para trar desde el backend los usuarios
    private String Getusers(){
        String resource = String.format(URL, "usuarios");

        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/java")
                    .GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return response.body();

    }




    //metodo para trar desde el backend los usuarios
    private String Getuser(int id){
        String resource = String.format(URL2, "usuarios/{id}");

        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/java")
                    .GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }






    public  String crearUser(Usuarios newUser){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(newUser, Usuarios.class);
        String resource = String.format(URL, "usuario");



        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(string)).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return response.body();

    }




    private String modificarUser(Usuarios userModified){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(userModified, Usuarios.class);
        String resource = String.format(URL, "usuario");


        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(string)).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();
    }



    //DELETE USER
    private String deleteUser(int id){
        String resource = String.format(URL2, "usuarios/{id}");

        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/java").DELETE().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }







    //metodo para trar desde el backend los prestamos
    private String GetPrestamos(){
        String resource = String.format(URL, "prestamos");


        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/java")
                    .GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }





    public  String crearPrestamo(Prestamos prestamo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(prestamo, Prestamos.class);
        String resource = String.format(URL, "prestamo");



        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(string)).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return response.body();

    }




    //metodo para trar desde el backend los prestamos
    private String GetEquipos(){
        String resource = String.format(URL, "equipos");


        try{
            request = HttpRequest.newBuilder(new URI(resource)).header("Content-type","application/java")
                    .GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }






    //declaramos las variables final para el proyecto
    final VerticalLayout layout;
    final Tab pestañaUser;
    final Tab pestañaPrestamo;
    final Tab pestañaEquipo;
    final Map<Tab, Component> tabsToPages = new HashMap<>();
    final Tabs tabs;
    final IntegerField filtros;


    public MainView() {


        this.filtros = new IntegerField();
        //objetos inciales
        //Inicializamos una llamada para coger los prestamos y meterlos en un array
        VerticalLayout totalayout = new VerticalLayout();
        String prestamosarray = GetPrestamos();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Prestamos> prestamos;
        Type listaprestamos = new TypeToken<ArrayList<Prestamos>>(){}.getType();
        prestamos = gson.fromJson(prestamosarray, listaprestamos);



        //Inicializamos una llamada para coger los usuarios y meterlos en un array
        String usuariosarray = Getusers();
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Usuarios> users;
        Type listausers = new TypeToken<ArrayList<Usuarios>>(){}.getType();
        users = gson2.fromJson(usuariosarray, listausers);


        //inicializamos la llamada para los equipos
        String arayequipos = GetEquipos();
        Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Equipos> equipos;
        Type listaequipos = new TypeToken<ArrayList<Equipos>>(){}.getType();
        equipos = gson3.fromJson(arayequipos, listaequipos);



        //INICIO LAYOUT USUARIOS

        VerticalLayout VerticalUsersLayout = new VerticalLayout();
        HorizontalLayout HorizontalUsersLayout = new HorizontalLayout();

        //hacemos referencia a la pestaña de usuarios --> tab
        pestañaUser = new Tab(VaadinIcon.USER.create(),new Span("Usuarios"));
        Div divUsers = new Div();



        //nos creamos el boton de añadir un nuevo usuario
        Button btnNewUser = new Button("Nuevo User");
        Button btnAgregarUser = new Button("Añadir");

        //Inicio grid Usuarios

        Grid<Usuarios> UsersGrid = new Grid<>(Usuarios.class);
        UsersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        UsersGrid.setItems(users);
        UsersGrid.removeColumnByKey("id");
        UsersGrid.setColumns("nombre", "departamento", "ubicacion", "telefono", "email");
        UsersGrid.addColumn(Usuarios::getNombre);
        UsersGrid.addColumn(Usuarios::getDepartamento);
        UsersGrid.addColumn(Usuarios::getTelefono);
        UsersGrid.addColumn(Usuarios::getEmail);
        UsersGrid.addColumn(Usuarios::getUbicacion);

        UsersGrid.setWidth("100%");

        //listener para cuando el usuario selecciones una fila del grid
        UsersGrid.asSingleSelect().addValueChangeListener(e -> {
            modalinfo(e.getValue());
        });


        //al pulsar el boton de nuevo usuario
        /*btnNewUser.addClickListener( e ->{
            Dialog dialog = new Dialog();
            VerticalLayout dialogLayout = createDialogUserLayout(dialog);
            dialog.add(dialogLayout);

            Button cancelButton = new Button("Cancelar", e1 -> dialog.close());
            dialog.add(cancelButton);
            //add(dialog,cancelButton);

            
            dialog.open();

            // Center the button within the example
            getStyle().set("position", "fixed").set("top", "0").set("right", "0")
                    .set("bottom", "0").set("left", "0").set("display", "flex")
                    .set("align-items", "center").set("justify-content", "center");
        });*/

        //formulario para un nuevo usuario
        btnNewUser.addClickListener(e-> nuevoModalUser());



        //fin grid Usuarios

        HorizontalUsersLayout.add(btnNewUser);
        VerticalUsersLayout.add(filtros,UsersGrid, HorizontalUsersLayout);
        divUsers.add(VerticalUsersLayout);
        divUsers.getStyle().set("flex-wrap", "wrap");


        //filtros para buscar
        filtros.setValueChangeMode(ValueChangeMode.EAGER);
        filtros.addValueChangeListener(e ->{

           String user= Getuser(e.getValue());
           Usuarios userfiltro = gson2.fromJson(usuariosarray, listausers);
           if(userfiltro != null){
               UsersGrid.setItems(userfiltro);
           }else{
               UsersGrid.setItems(users);
           }

        });
        //FIN LAYOUT USUARIOS







        //INICIO LAYOUT EQUIPOS

        VerticalLayout VerticalEquipoLayout = new VerticalLayout();
        HorizontalLayout HorizontalEquipoLayout = new HorizontalLayout();

        //hacemos referencia a la pestaña de usuarios --> tab
        pestañaEquipo = new Tab(VaadinIcon.DESKTOP.create(),new Span("Equipos"));
        Div divEquipos = new Div();

        //nos creamos el boton de añadir un nuevo prestamo
        Button btnNewEquipo = new Button("Nuevo Prestamo");

        //Inicio Grid Equipos

        Grid<Equipos> EquipoGrid = new Grid<>(Equipos.class);
        EquipoGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        EquipoGrid.setItems(equipos);
        //EquipoGrid.removeColumnByKey("id_equipo");
        EquipoGrid.setColumns("tipo","marca","uso");
        EquipoGrid.addColumn(Equipos::getTipo);
        EquipoGrid.addColumn(Equipos::getMarca);
        EquipoGrid.addColumn(Equipos::getUso);

        EquipoGrid.setWidth("100%");

        //listener para cuando el usuario selecciones una fila del grid
        EquipoGrid.asSingleSelect().addValueChangeListener(e ->
                //AQUI VA LA LLAMADA AL MODAL DE VER LOS EQUIPOS
            modalinfoEquipos(e.getValue()));

        //Fin Grid equipos


        VerticalEquipoLayout.add(EquipoGrid,HorizontalEquipoLayout);
        divEquipos.add(VerticalEquipoLayout);
        divEquipos.getStyle().set("flex-wrap", "wrap");

        //FIN LAYOUT EQUIPOS









        //INICIO LAYOUT PRESTAMOS

        VerticalLayout VerticalPrestamoLayout = new VerticalLayout();
        HorizontalLayout HorizontalPrestamoLayout = new HorizontalLayout();

        //hacemos referencia a la pestaña de usuarios --> tab
        pestañaPrestamo = new Tab(VaadinIcon.DOLLAR.create(),new Span("Prestamos"));
        Div divPrestamos = new Div();

        //nos creamos el boton de añadir un nuevo prestamo
        Button btnNewPrestamo = new Button("Nuevo Prestamo");


        TextField usuario = new TextField("Usuario_Id");
        TextField equipo = new TextField("Equipo id");
        TextField fechaIni = new TextField("Fecha Inicio");
        TextField fechaFin = new TextField("Fecha fin ");
        TextField comentarios = new TextField("Comentarios");


        //Incicio de grid Prestamos

        Grid<Prestamos> PrestamoGrid = new Grid<>(Prestamos.class);
        PrestamoGrid.setItems(prestamos);
        PrestamoGrid.removeColumnByKey("id");
        PrestamoGrid.setColumns("usuario_Id","fecha_Inicio_Prestamo","fecha_Fin_Prestamo","comentarios");
        PrestamoGrid.addColumn(Prestamos::getUsuario_Id);
        PrestamoGrid.addColumn(Prestamos::getFecha_Inicio_Prestamo);
        PrestamoGrid.addColumn(Prestamos::getFecha_Fin_Prestamo);
        PrestamoGrid.addColumn(Prestamos::getComentarios);

        //listener para cuando el usuario selecciones una fila del grid
        PrestamoGrid.asSingleSelect().addValueChangeListener(e -> {
            modalinfoPrestamo(e.getValue());
        });


        //al pulsar el boton de nuevo usuario
        btnNewPrestamo.addClickListener( e ->nuevoModalPrestamo());





        //Fin del grid Prestamos

        VerticalPrestamoLayout.add(PrestamoGrid,btnNewPrestamo);
        divPrestamos.add(VerticalPrestamoLayout);
        VerticalUsersLayout.getStyle().set("flex-wrap", "wrap");


        //FIN LAYOUT PRESTAMOS




        //INCIO TABSHEET

        tabsToPages.put(pestañaUser,divUsers);
        tabsToPages.put(pestañaEquipo,divEquipos);
        tabsToPages.put(pestañaPrestamo,divPrestamos);

        tabs = new Tabs(pestañaUser, pestañaEquipo,pestañaPrestamo);
        tabs.setSizeFull();
        Div paginas = new Div(divUsers, divEquipos,divPrestamos);
        paginas.setSizeFull();


        tabs.addSelectedChangeListener(event ->{
            //tabsToPages.values().forEach(page -> page.setVisible(false));
            //Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            //paginaSeleccionada.setVisible(true);
            setLayout(event.getSelectedTab());
        });

        layout = new VerticalLayout();
        layout.setSpacing(false);
        setLayout(tabs.getSelectedTab());

        add(tabs, paginas,layout);

        //FIN TABSHEET

    }


    //FIN CONTSTRUCTOR DE MAINVIEW



    private VerticalLayout createDialogUserLayout(Dialog dialog) {

        H2 headline = new H2("Nuevo usuario");
        headline.getStyle().set("margin", "0").set("font-size", "1.5em")
                .set("font-weight", "bold");

        HorizontalLayout header = new HorizontalLayout(headline);
        header.getElement().getClassList().add("draggable");
        header.setSpacing(false);

        //Definicion de los textfield del formulario
        AtomicInteger id_user = new AtomicInteger();
        TextField Nombre = new TextField("Nombre");
        TextField Departamento = new TextField("Departamento");
        TextField telefono = new TextField("Telefono");
        TextField email = new TextField("Email");
        TextField Ubicacion = new TextField("Ubicación");

        VerticalLayout dialogLayout = new VerticalLayout(Nombre,Departamento,Ubicacion, telefono, email);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        //botones del formulario
        //utton btnAgregarUser = new Button("Añadir", e-> dialog.close());
        Button btnAñadir = new Button("Añadir" ,e -> {
            //agregamos la funcioalidad de agregar el usuarios con los datos del textfield
            //instanciamos un nuevo usuario
            Usuarios user = new Usuarios(5,Nombre.getValue(),Departamento.getValue(),Ubicacion.getValue(),telefono.getValue(),email.getValue());
            //MainView m = new MainView();
            crearUser(user);
            UI.getCurrent().getPage().reload();



        });

        HorizontalLayout buttonLayout = new HorizontalLayout(btnAñadir);
        VerticalLayout dialogLayout2 = new VerticalLayout(header, dialogLayout,buttonLayout);
        dialog.add(btnAñadir);

        return dialogLayout;
    }






    //Inicio de los metodos

    private void setLayout(Tab tab) {
        layout.removeAll();

        if (tab.equals(pestañaUser)) {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        } else if (tab.equals(pestañaEquipo)) {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        } else if (tab.equals(pestañaPrestamo)){
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        }
    }


    private static VerticalLayout createDialogPrestamoLayout() {

        //Definicion de los textfield
        AtomicInteger id_prestamo = new AtomicInteger();
        TextField usuario = new TextField("Usuario_Id");
        TextField equipo = new TextField("Equipo id");
        /*ComboBox<Usuarios> combox1 = new ComboBox<>("Usuarios");
        ComboBox<Equipos> combox2 = new ComboBox<>("Equipos");
        List<Integer> idUserUsuarios = new ArrayList<Integer>();
        List<Integer> idUserEquipos = new ArrayList<Integer>();
        for(Usuarios user : usuarios){

            idUserUsuarios.add(user.getId());

        }
        for(int i = 0; i<usuarios.size(); i++){

            Usuarios index = usuarios.get(0);
            idUserUsuarios.add(index.getId());
        }
        combox1.setItems((Usuarios) idUserUsuarios);
        combox2.setItems((Equipos) idUserEquipos);
        */
        TextField fechaIni = new TextField("Fecha Inicio");
        TextField fechaFin = new TextField("Fecha fin ");
        TextField comentarios = new TextField("Comentarios");

        VerticalLayout dialogLayout = new VerticalLayout(usuario,equipo,
                fechaIni,fechaFin, comentarios);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        return dialogLayout;
    }


    //Funcion modalinfo para mostrar la informacion del usuario
    private void modalinfo(Usuarios user){
        try {
            Dialog dialog = new Dialog(); //nos instanciamos un nuevo dialogo
            dialog.setCloseOnEsc(false);
            dialog.setCloseOnOutsideClick(false);

            //ponemos en el layout los campos a mostrar
            dialog.add(new HorizontalLayout(new Html("<b>Nombre:  </b>"),new Text(user.getNombre())));
            dialog.add(new HorizontalLayout(new Html("<b>Departamento:  </b>"), new Text(user.getDepartamento())));
            dialog.add(new HorizontalLayout(new Html("<b>Ubicacion:  </b>"),new Text(user.getUbicacion())));
            dialog.add(new HorizontalLayout(new Html("<b>Telefono:  </b>"), new Text(String.valueOf(user.getTelefono()))));
            dialog.add(new HorizontalLayout(new Html("<b>email:  </b>"),new Text(user.getEmail())));

            //imprim por consola el id del usuario para ver si lo coge bien y poder eliminarlo
            System.out.println(user.getId());

            Button modificaruser = new Button("Editar", event -> {dialog.close(); editarmodaluser(user);});
            Button deleteuser = new Button("Eliminar", event -> deleteUser(user.getId()));
            Button cancelButton = new Button("Cancelar", event -> { dialog.close(); });
            HorizontalLayout actions2 = new HorizontalLayout(modificaruser, cancelButton,deleteuser);
            dialog.add(actions2);
            dialog.open();

            //estilo para el boton de eliminar --> rojo
            deleteuser.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_ERROR);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //MOdal para modificar un usuario
    private void editarmodaluser(Usuarios user){

        Dialog dialog = new Dialog(); //nos creamos un nuevo dialog para el formulario de mdificar el usuario
        dialog.setCloseOnOutsideClick(false);
        dialog.setCloseOnEsc(false);

        //Declaramos los campos que van a aparecer para editar el modal
        //lo campos son los declrados anteriormente
        //usamos TextField

        TextField Nombre = new TextField("Nombre");
        Nombre.setValue(user.getNombre());
        dialog.add(new HorizontalLayout(Nombre));
        TextField Departamento = new TextField("Departamento");
        Departamento.setValue(user.getDepartamento());
        dialog.add(new HorizontalLayout(Departamento));
        TextField Ubicacion = new TextField("Ubicacion");
        Ubicacion.setValue(user.getUbicacion());
        dialog.add(new HorizontalLayout(Ubicacion));
        TextField telefono = new TextField("Telefono");
        telefono.setValue(String.valueOf(user.getTelefono()));
        dialog.add(new HorizontalLayout(telefono));
        TextField email = new TextField("email");
        email.setValue(user.getEmail());
        dialog.add(new HorizontalLayout(email));


        //creamos el boton de aceptar para modificar el usuario

        Button aceptar = new Button("Confirmar", e -> {

            user.setNombre(Nombre.getValue());
            user.setDepartamento(Departamento.getValue());
            user.setUbicacion(Ubicacion.getValue());
            user.setTelefono(Integer.parseInt(telefono.getValue()));
            user.setEmail(email.getValue());

            //guardamos los cambios
            //LLAMADA A FUNCION DE PUT como modificaUser(user)
            modificarUser(user);
            UI.getCurrent().getPage().reload();
            dialog.close();

        });

        //cremoa un boton de abortar o cancelar y los añadirmos al layout
        Button cancelar = new Button("Cancelar", event -> { dialog.close(); });
        HorizontalLayout opt = new HorizontalLayout(aceptar, cancelar);
        dialog.add(opt);
        //abrimos el modal
        dialog.open();

    }

    //nuev modal para crear un usuario
    void nuevoModalUser(){
        Dialog dialog = new Dialog(); //instaciamos un nuevo dialogo

        //nos declaramos los campos del formulario necesarios para crear un nuevo usuario

        TextField Nombre = new TextField("Nombre");
        dialog.add(new HorizontalLayout(Nombre));
        TextField Departamento = new TextField("Departamento");
        dialog.add(new HorizontalLayout(Departamento));
        TextField Ubicacion = new TextField("Ubicacion");
        dialog.add(new HorizontalLayout(Ubicacion));
        TextField telefono = new TextField("telefono");
        dialog.add(new HorizontalLayout(telefono));
        TextField email = new TextField("email");
        dialog.add(new HorizontalLayout(email));

        //creamos el boton de aceptar
        Button aceptar = new Button("Añadir", event -> {


            Usuarios user = new Usuarios(7,Nombre.getValue(),Departamento.getValue(),Ubicacion.getValue(),telefono.getValue(),email.getValue());
            //crearUser(user);
            user.setNombre(Nombre.getValue());
            user.setDepartamento(Departamento.getValue());
            user.setUbicacion(Ubicacion.getValue());
            user.setTelefono(Integer.parseInt(telefono.getValue()));
            user.setEmail(email.getValue());

            crearUser(user);
            dialog.close();
        });

        Button cancelar = new Button("Cancelar", event2 ->{
            dialog.close();
        });

        HorizontalLayout opciones = new HorizontalLayout(aceptar,cancelar);
        dialog.add(opciones);
        dialog.open();


    }













    //METODOS PARA LA PESTAÑA DE PRESTAMOS

    //modal iinformacion cuando el usuario quiere ver info de un prestamos
    private void modalinfoPrestamo(Prestamos prestamo){

        try{
            //nos generemos un nuevo dialogo
            Dialog dialogo = new Dialog();
            dialogo.setCloseOnEsc(false);
            dialogo.setCloseOnOutsideClick(false);

            //ponemos en el layout los textfields que vamos a usar
            dialogo.add(new HorizontalLayout(new Html("<b>id Usuario: </b>"), new Text(String.valueOf(prestamo.getUsuario_Id()))));
            dialogo.add(new HorizontalLayout(new Html("<b>id Equipo: </b>"), new Text(String.valueOf(prestamo.getEquipo_Id()))));
            dialogo.add(new HorizontalLayout(new Html("<b>Fecha Inicio Prestamo: </b>"),new Text(prestamo.getFecha_Inicio_Prestamo())));
            dialogo.add(new HorizontalLayout(new Html("<b>Fecha Fin prestamos: </b>"),new Text(prestamo.getFecha_Fin_Prestamo())));
            dialogo.add(new HorizontalLayout(new Html("<b>Fecha Real dev: </b>"),new Text(prestamo.getFecha_Real_Dev())));
            dialogo.add(new HorizontalLayout(new Html("<b>Comentarios: </b>"),new Text(prestamo.getComentarios())));

            Button modificarprestamo = new Button("Editar", event -> {dialogo.close(); editarmodalPrestamo(prestamo);});
            Button deleteprestamo = new Button("Eliminar");
            Button cancelButton = new Button("Cancelar", event -> { dialogo.close(); });
            HorizontalLayout actions2 = new HorizontalLayout(modificarprestamo, cancelButton,deleteprestamo);
            dialogo.add(actions2);
            dialogo.open();

            //estilo para el boton de eliminar --> rojo
            deleteprestamo.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_ERROR);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //metodo para editar un prestamos
    //fomrulario con textfields donde se muestra la info del prestamo solicitado
    private void editarmodalPrestamo(Prestamos prestamo){

        //nos generemos un nuevo dialogo
        Dialog dialogo = new Dialog();
        dialogo.setCloseOnEsc(false);
        dialogo.setCloseOnOutsideClick(false);

        //textfields necesarios
        TextField idUsuario = new TextField("Id Usuario");
        idUsuario.setValue(String.valueOf(prestamo.getUsuario_Id()));
        dialogo.add(new HorizontalLayout(idUsuario));
        TextField idEquipo = new TextField("Id Equipo");
        idEquipo.setValue(String.valueOf(prestamo.getEquipo_Id()));
        dialogo.add(new HorizontalLayout(idEquipo));
        TextField fechaIni = new TextField("Fecha Inicio prestamo");
        fechaIni.setValue(prestamo.getFecha_Inicio_Prestamo());
        dialogo.add(new HorizontalLayout(fechaIni));
        TextField fechaFin = new TextField("Fecha Fin prestamo");
        fechaFin.setValue(prestamo.getFecha_Fin_Prestamo());
        dialogo.add(new HorizontalLayout(fechaFin));
        TextField fechaReal = new TextField("Fecha Real prestamo");
        fechaReal.setValue(prestamo.getFecha_Real_Dev());
        dialogo.add(new HorizontalLayout(fechaReal));
        TextField comentaios = new TextField("Comentarios");
        comentaios.setValue(prestamo.getComentarios());
        dialogo.add(new HorizontalLayout(comentaios));

        Button aceptar = new Button("Confirmar", e -> {

            prestamo.setUsuario_Id(Integer.parseInt(idUsuario.getValue()));
            prestamo.setEquipo_Id(Integer.parseInt(idEquipo.getValue()));
            prestamo.setFecha_Inicio_Prestamo(fechaIni.getValue());
            prestamo.setFecha_Fin_Prestamo(fechaFin.getValue());
            prestamo.setFecha_Real_Dev(fechaReal.getValue());
            prestamo.setComentarios(comentaios.getValue());

            //guardamos los cambios
            //LLAMADA A FUNCION DE PUT como modificaUser(user)
            dialogo.close();

        });

        //cremoa un boton de abortar o cancelar y los añadirmos al layout
        Button cancelar = new Button("Cancelar", event -> { dialogo.close(); });
        HorizontalLayout opt = new HorizontalLayout(aceptar, cancelar);
        dialogo.add(opt);
        //abrimos el modal
        dialogo.open();


    }


    //modal para un nuevo prestamos
    void nuevoModalPrestamo(){

        Dialog dialog = new Dialog();


        //nos creamos los diferentes textfields para ingresar los datos
        IntegerField id_Equipo = new IntegerField("ID Equipo");
        dialog.add(new HorizontalLayout(id_Equipo));
        IntegerField id_Usuario = new IntegerField("ID Usuario");
        dialog.add(new HorizontalLayout(id_Usuario));
        TextField fechaIni = new TextField("Fecha Inicio Prestamo");
        dialog.add(new HorizontalLayout(fechaIni));
        TextField fechaFin = new TextField("Fecha Fin Prestamo");
        dialog.add(new HorizontalLayout(fechaFin));
        TextField fechaReal = new TextField("Fecha Real Devlucion");
        dialog.add(new HorizontalLayout(fechaReal));
        TextField comentarios = new TextField("comentarios");
        dialog.add(new HorizontalLayout(comentarios));


        //nos creamos el boton de aceptar para confirmar el nuevo prestamo
        Button aceptar = new Button("Añadir",event -> {
            Prestamos prestamo = new Prestamos(4,id_Usuario.getValue(),id_Equipo.getValue(),fechaIni.getValue(),fechaFin.getValue(),fechaReal.getValue(),comentarios.getValue());

            prestamo.setUsuario_Id(id_Usuario.getValue());
            prestamo.setEquipo_Id(id_Equipo.getValue());
            prestamo.setFecha_Inicio_Prestamo(fechaIni.getValue());
            prestamo.setFecha_Fin_Prestamo(fechaFin.getValue());
            prestamo.setFecha_Real_Dev(fechaReal.getValue());
            prestamo.setComentarios(comentarios.getValue());

            crearPrestamo(prestamo);
            UI.getCurrent().getPage().reload();
            dialog.close();


        });

        Button cancelar = new Button("Cancelar", event2 ->{
            dialog.close();
        });

        HorizontalLayout opciones = new HorizontalLayout(aceptar,cancelar);
        dialog.add(opciones);
        dialog.open();

    }


    //modal info de los equipos
    void modalinfoEquipos(Equipos equipos){


        try{

            Dialog dialog = new Dialog(); //modal instanciado
            dialog.setCloseOnEsc(false);
            dialog.setCloseOnOutsideClick(false);

            //declaramos los textfields necesarios
            dialog.add(new HorizontalLayout(new Html("<b>Tipo: </b>"), new Text(equipos.getTipo())));
            dialog.add(new HorizontalLayout(new Html("<b>Marca: </b>"), new Text(equipos.getMarca())));
            dialog.add(new HorizontalLayout(new Html("<b>Uso: </b>"), new Text(equipos.getUso())));
            dialog.add(new HorizontalLayout(new Html("<b>       SISTEMA OPERATIVO: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Nombre SO: </b>"), new Text(equipos.getSistema_operativo().nombreSO)));
            dialog.add(new HorizontalLayout(new Html("<b>Version SO: </b>"), new Text(equipos.getSistema_operativo().versionSO)));
            dialog.add(new HorizontalLayout(new Html("<b>       HARDWARE: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Procesador SO: </b>"), new Text(equipos.getHardware().Procesador)));
            dialog.add(new HorizontalLayout(new Html("<b>Memoria: </b>"), new Text(String.valueOf(equipos.getHardware().Memoria))));
            dialog.add(new HorizontalLayout(new Html("<b>       DISCO DURO: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Tipo disco SO: </b>"), new Text(equipos.getHardware().getDiscoduro().getTipodisco())));
            dialog.add(new HorizontalLayout(new Html("<b>capacidad: </b>"), new Text(equipos.getHardware().getDiscoduro().getCapacidad())));
            dialog.add(new HorizontalLayout(new Html("<b>       PANTALLA: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Diagonal: </b>"), new Text(String.valueOf(equipos.getHardware().getPantalla().Diagonal))));
            dialog.add(new HorizontalLayout(new Html("<b>Resolucion SO: </b>"), new Text(equipos.getHardware().getPantalla().Resolucion)));
            dialog.add(new HorizontalLayout(new Html("<b>       SOFTWARE: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>       Licencia de Pago: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Nombre Licencia Pago: </b>"), new Text(equipos.getSoftware().getLicenciapago().NombreSP)));
            dialog.add(new HorizontalLayout(new Html("<b>Version Licencia Pago: </b>"), new Text(equipos.getSoftware().getLicenciapago().VersionSP)));
            dialog.add(new HorizontalLayout(new Html("<b>Tipo Licencia Pago: </b>"), new Text(equipos.getSoftware().getLicenciapago().TipoSP)));
            dialog.add(new HorizontalLayout(new Html("<b>       Licencia Libre: </b>")));
            dialog.add(new HorizontalLayout(new Html("<b>Nombre Licencia Libre: </b>"), new Text(equipos.getSoftware().getLicencialibre().NombreSL)));
            dialog.add(new HorizontalLayout(new Html("<b>Version Licencia Libre: </b>"), new Text(equipos.getSoftware().getLicencialibre().VersionSL)));

            //impirmo por consola el id del equipo para ver si lo coge bien
            System.out.println(equipos.getIdEquipo());

            Button cancelButton = new Button("Cancelar", event -> { dialog.close(); });
            HorizontalLayout actions2 = new HorizontalLayout(cancelButton);
            dialog.add(actions2);

            dialog.open();



        } catch (Exception e) {
             e.printStackTrace();
         }
    }






}
