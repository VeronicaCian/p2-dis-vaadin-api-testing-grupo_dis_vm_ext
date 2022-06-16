package com.practica2DIS_EXTR;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.practica2DIS_EXTR.Clases.Equipos;
import com.practica2DIS_EXTR.Clases.Prestamos;
import com.practica2DIS_EXTR.Clases.Usuarios;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
    private static final String URL2 = "http://localhost:8081/api/%s/%s";
    //private static HttpRequest request;
    HttpRequest request;
    HttpClient cliente = HttpClient.newBuilder().build();
    HttpResponse<String> response;

    //metodo para trar desde el backend los usuarios
    private String Getusers(){
        String resource = String.format(URL, "usuarios");
        System.out.println(resource);

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

        System.out.println(response.body());

        return response.body();

    }




    //metodo para trar desde el backend los usuarios
    private String Getuser(String name){
        String resource = String.format(URL2, "usuarios/{nombre}");
        System.out.println(resource);

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

        System.out.println(response.body());

        return response.body();

    }






    public  String crearUser(Usuarios newUser){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(newUser, Usuarios.class);
        String resource = String.format(URL, "usuario");
        System.out.println(resource);


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

        System.out.println(response.body());

        return response.body();

    }


    //metodo para trar desde el backend los prestamos
    private String GetPrestamos(){
        String resource = String.format(URL, "prestamos");
        System.out.println(resource);

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

        System.out.println(response.body());

        return response.body();

    }






    //declaramos las variables final para el proyecto
    final VerticalLayout layout;
    final Tab pestañaUser;
    final Tab pestañaPrestamo;
    final Tab pestañaEquipo;
    final Map<Tab, Component> tabsToPages = new HashMap<>();
    final Tabs tabs;
    final TextField filtros;


    public MainView() {


        this.filtros = new TextField();
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
        btnNewUser.addClickListener( e ->{
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
        });



        //fin grid Usuarios

        HorizontalUsersLayout.add(btnNewUser);
        VerticalUsersLayout.add(filtros,UsersGrid, HorizontalUsersLayout);
        divUsers.add(VerticalUsersLayout);
        divUsers.getStyle().set("flex-wrap", "wrap");


        //filtros para buscar
        filtros.setValueChangeMode(ValueChangeMode.EAGER);
        filtros.addValueChangeListener(e ->{

           String user=  Getuser(e.getValue());
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
        UsersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        //EquipoGrid.removeColumnByKey("id_equipo");
        EquipoGrid.setColumns("tipo","marca","uso");
        EquipoGrid.addColumn(Equipos::getTipo);
        EquipoGrid.addColumn(Equipos::getMarca);
        EquipoGrid.addColumn(Equipos::getUso);


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
        btnNewPrestamo.addClickListener( e ->{
            Dialog dialog2 = new Dialog();
            VerticalLayout dialogLayout = createDialogPrestamoLayout();
            dialog2.add(dialogLayout);

            Button cancelButton = new Button("Cancel", e1 -> dialog2.close());
            dialog2.add(cancelButton);


            dialog2.open();

            // Center the button within the example
            getStyle().set("position", "fixed").set("top", "0").set("right", "0")
                    .set("bottom", "0").set("left", "0").set("display", "flex")
                    .set("align-items", "center").set("justify-content", "center");
        });





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
            Usuarios user = new Usuarios(id_user,Nombre.getValue(),Departamento.getValue(),Ubicacion.getValue(),telefono.getValue(),email.getValue());
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

            Button modificaruser = new Button("Editar", event -> {dialog.close(); editarmodaluser(user);});
            Button deleteuser = new Button("Eliminar");
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
            dialog.close();

        });

        //cremoa un boton de abortar o cancelar y los añadirmos al layout
        Button cancelar = new Button("Cancelar", event -> { dialog.close(); });
        HorizontalLayout opt = new HorizontalLayout(aceptar, cancelar);
        dialog.add(opt);
        //abrimos el modal
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






}
