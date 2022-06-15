package com.practica2DIS_EXTR;

import com.practica2DIS_EXTR.Clases.Equipos;
import com.practica2DIS_EXTR.Clases.Prestamos;
import com.practica2DIS_EXTR.Clases.Usuarios;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    //declaramos las variables final para el proyecto
    final VerticalLayout layout;
    final Tab pestañaUser;
    final Tab pestañaPrestamo;
    final Tab pestañaEquipo;
    final Map<Tab, Component> tabsToPages = new HashMap<>();
    final Tabs tabs;

    public MainView(){


        //objetos inciales
        VerticalLayout totallayout = new VerticalLayout();


        //INICIO LAYOUT USUARIOS

        VerticalLayout VerticalUsersLayout = new VerticalLayout();
        HorizontalLayout HorizontalUsersLayout = new HorizontalLayout();

        //hacemos referencia a la pestaña de usuarios --> tab
        pestañaUser = new Tab(VaadinIcon.USER.create(),new Span("Usuarios"));
        Div divUsers = new Div();

        //nos creamos el boton de añadir un nuevo usuario
        Button btnNewUser = new Button("Nuevo User");


        //Inicio grid Usuarios

        Grid<Usuarios> UsersGrid = new Grid<>(Usuarios.class);
        UsersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        //gridUsers.setItems(users);
        UsersGrid.removeColumnByKey("id");
        UsersGrid.setColumns("nombre", "departamento", "telefono", "email", "ubicacion");
        UsersGrid.addColumn(Usuarios::getNombre);
        UsersGrid.addColumn(Usuarios::getDepartamento);
        UsersGrid.addColumn(Usuarios::getTelefono);
        UsersGrid.addColumn(Usuarios::getEmail);
        UsersGrid.addColumn(Usuarios::getUbicacion);

        //al pulsar el boton de nuevo usuario
        btnNewUser.addClickListener( e ->{
            Dialog dialog = new Dialog();
            VerticalLayout dialogLayout = createDialogUserLayout();
            dialog.add(dialogLayout);

            Button cancelButton = new Button("Cancel", e1 -> dialog.close());
            dialog.add(cancelButton);


            dialog.open();

            // Center the button within the example
            getStyle().set("position", "fixed").set("top", "0").set("right", "0")
                    .set("bottom", "0").set("left", "0").set("display", "flex")
                    .set("align-items", "center").set("justify-content", "center");
        });

        //fin grid Usuarios

        HorizontalUsersLayout.add(btnNewUser);
        VerticalUsersLayout.add(UsersGrid, HorizontalUsersLayout);
        divUsers.add(VerticalUsersLayout);
        divUsers.getStyle().set("flex-wrap", "wrap");


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

        //Incicio de grid Prestamos

        Grid<Prestamos> PrestamoGrid = new Grid<>(Prestamos.class);
        PrestamoGrid.removeColumnByKey("id");
        PrestamoGrid.setColumns("usuario_Id","fecha_Inicio_Prestamo","fecha_Fin_Prestamo","comentarios");
        PrestamoGrid.addColumn(Prestamos::getUsuario_Id);
        PrestamoGrid.addColumn(Prestamos::getFecha_Inicio_Prestamo);
        PrestamoGrid.addColumn(Prestamos::getFecha_Fin_Prestamo);
        PrestamoGrid.addColumn(Prestamos::getComentarios);

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

    private static VerticalLayout createDialogUserLayout() {

        //Definicion de los textfield
        AtomicInteger id_user = new AtomicInteger();
        TextField nombre = new TextField("Nombre");
        TextField departamento = new TextField("Departamento");
        TextField telefono = new TextField("Telefono");
        TextField email = new TextField("Email");
        TextField ubicacion = new TextField("Ubicación");

        VerticalLayout dialogLayout = new VerticalLayout(
                nombre,departamento,telefono, email, ubicacion);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        return dialogLayout;
    }


}
