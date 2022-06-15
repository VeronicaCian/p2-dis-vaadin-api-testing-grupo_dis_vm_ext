package com.practica2DIS_EXTR;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.practica2DIS_EXTR.Clases.Prestamos;
import com.practica2DIS_EXTR.Clases.Usuarios;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {


    private static final String URL = "http://localhost:8080/api/%s";




    final VerticalLayout layout;
    final Tab usersTAB;
    final Tab prestTAB;
    final Tab equipoTAB;
    final Map<Tab, Component> tabsToPages = new HashMap<>();
    final Tabs tabs;


    public MainView() {



        //primeramente nos creamos un grid con los usuarios
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Usuarios> users;
        Type ListaUsersType = new TypeToken<ArrayList<Usuarios>>(){}.getType();
        //users = gson.fromJson(usersST, ListaUsersType);


        //Layout de usuarios
        VerticalLayout usersVLayout = new VerticalLayout();
        HorizontalLayout usersHLayout = new HorizontalLayout();

        //grid usuarios

        Grid<Usuarios> gridUsers = new Grid<>(Usuarios.class);
        //gridUsers.setItems(users);
        gridUsers.removeColumnByKey("id");
        gridUsers.setColumns("nombre", "departamento", "telefono", "email", "ubicacion");

        //tabshet y div de usuarios
        usersTAB = new Tab(VaadinIcon.USER.create(),new Span("Usuarios"));
        Div usersDIV = new Div();

        //Definicion de los textfield
        AtomicInteger id_user = new AtomicInteger();
        TextField nombre = new TextField("Nombre");
        TextField departamento = new TextField("Departamento");
        TextField telefono = new TextField("Telefono");
        TextField email = new TextField("Email");
        TextField ubicacion = new TextField("Ubicación");

        //botones del grid usuarios
        Button anadir = new Button("Añadir");
        Button acep_2 = new Button("Aceptar_2");
        Button nuevo = new Button("Nuevo User");
        Button edit = new Button("Editar User");
        Button borrar = new Button("Borrar User");

        usersHLayout.add(nombre, departamento, telefono, email, ubicacion);
        usersVLayout.add(usersHLayout, nuevo);
        usersDIV.add(gridUsers, nuevo);



        //PRESTAMOS
        prestTAB = new Tab(VaadinIcon.DOLLAR.create(),new Span("Prestamos"));
        Div prestDIV = new Div();
        prestDIV.setVisible(false);

        //Definicion del grid de users
        Grid<Prestamos> gridPrest = new Grid<>(Prestamos.class);
        //gridPrest.setItems(prestamos);
        gridPrest.removeColumnByKey("id");
        //gridPrest.setColumns("Usuario_Id","Fecha_Inicio_Prestamo", "Fecha_Fin_Prestamo", "Fecha_Real_Dev", "Comentarios");

        //Definicion de los layaout
        VerticalLayout prestVLayout = new VerticalLayout();
        HorizontalLayout prestHLayout = new HorizontalLayout();

        //Definicion de los textfield
        TextField iduser = new TextField("id_user");
        TextField idequipo = new TextField("id_equipo");
        TextField fechaIni = new TextField("fecha_inicio");
        TextField fechaFin = new TextField("fecha_fin");
        TextField fechaReal = new TextField("fecha_real");
        TextField comen = new TextField("comentario");

        //Definicion de los buttons
        Button anadir_1 = new Button("Añadir");
        Button acep_2_2 = new Button("Aceptar_2");
        Button nuevo_2 = new Button("Nuevo Prestamo");
        Button edit_2 = new Button("Editar Prestamo");


        //Definicion del diseño de los layout y divs
        prestVLayout.add(prestHLayout, nuevo_2);
        prestHLayout.add(iduser, idequipo, fechaIni, fechaFin, fechaReal, comen);
        prestDIV.add(gridPrest, nuevo_2);



        //EQUIPOS
        equipoTAB = new Tab(VaadinIcon.DESKTOP.create(),new Span("Equipos"));
        Div equipoDIV = new Div();
        equipoDIV.setVisible(false);


        //tabshett map

        tabsToPages.put(usersTAB, usersDIV);
        tabsToPages.put(prestTAB, prestDIV);
        tabsToPages.put(equipoTAB,equipoDIV);

        tabs = new Tabs(usersTAB, prestTAB,equipoTAB);
        tabs.setSizeFull();
        Div pages = new Div(usersDIV, prestDIV,equipoDIV);
        pages.setSizeFull();


        tabs.addSelectedChangeListener(event ->{
            //tabsToPages.values().forEach(page -> page.setVisible(false));
            //Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            //paginaSeleccionada.setVisible(true);
            setLayout(event.getSelectedTab());
        });

        layout = new VerticalLayout();
        layout.setSpacing(false);
        setLayout(tabs.getSelectedTab());

        add(tabs, pages,layout);

    }

    private void setLayout(Tab tab) {
        layout.removeAll();

        if (tab.equals(usersTAB)) {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        } else if (tab.equals(prestTAB)) {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        } else if (tab.equals(equipoTAB)){
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component paginaSeleccionada = tabsToPages.get(tabs.getSelectedTab());
            paginaSeleccionada.setVisible(true);
        }
    }


}
