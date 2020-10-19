package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.MenuDia;

import java.io.Serializable;
import java.util.List;

public class MenuDiaService extends RestTemplateEntity<MenuDia> implements Serializable {

    public MenuDiaService() {
        super(new MenuDia(), MenuDia.class, MenuDia[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_MENUDIA;

    public List<MenuDia> obtenerMenuDias() {
        List<MenuDia> lista = getListURL(url);
        return lista;
    }

    public MenuDia obtenerMenuDiaPorId(Integer id) {
        MenuDia enti = getOneURL(url, id);
        return enti;
    }

    public MenuDia obtenerMenuDiaPorBody(MenuDia objeto) {
        MenuDia enti = getByBodyURL(url, objeto);
        return enti;
    }

    public MenuDia crearMenuDia(MenuDia objeto) {
        MenuDia enti = createURL(url, objeto);
        return enti;
    }

    public MenuDia actualizarMenuDiaPorId(MenuDia objeto) {
        MenuDia enti = updateURL(url, objeto.getIdMenuDia(), objeto);
        return enti;
    }

    public void eliminarMenuDiaPorId(Integer id) {
        deleteURL(url, id);
    }
}
