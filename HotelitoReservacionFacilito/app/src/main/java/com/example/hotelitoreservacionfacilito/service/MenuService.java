package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Menu;

import java.io.Serializable;
import java.util.List;

public class MenuService extends RestTemplateEntity<Menu> implements Serializable {

    public MenuService() {
        super(new Menu(), Menu.class, Menu[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_MENU;

    public List<Menu> obtenerMenus() {
        List<Menu> lista = getListURL(url);
        return lista;
    }

    public Menu obtenerMenuPorId(Integer id) {
        Menu enti = getOneURL(url, id);
        return enti;
    }

    public Menu obtenerMenuPorBody(Menu objeto) {
        Menu enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Menu crearMenu(Menu objeto) {
        Menu enti = createURL(url, objeto);
        return enti;
    }

    public Menu actualizarMenuPorId(Menu objeto) {
        Menu enti = updateURL(url, objeto.getIdMenu(), objeto);
        return enti;
    }

    public void eliminarMenuPorId(Integer id) {
        deleteURL(url, id);
    }
}
