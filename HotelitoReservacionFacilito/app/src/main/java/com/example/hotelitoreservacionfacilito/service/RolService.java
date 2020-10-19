package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Rol;

import java.io.Serializable;
import java.util.List;

public class RolService extends RestTemplateEntity<Rol> implements Serializable {

    public RolService() {
        super(new Rol(), Rol.class, Rol[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_ROL;

    public List<Rol> obtenerRols() {
        List<Rol> lista = getListURL(url);
        return lista;
    }

    public Rol obtenerRolPorId(Integer id) {
        Rol enti = getOneURL(url, id);
        return enti;
    }

    public Rol obtenerRolPorBody(Rol objeto) {
        Rol enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Rol crearRol(Rol objeto) {
        Rol enti = createURL(url, objeto);
        return enti;
    }

    public Rol actualizarRolPorId(Rol objeto) {
        Rol enti = updateURL(url, objeto.getId_rol() , objeto);
        return enti;
    }

    public void eliminarRolPorId(Integer id) {
        deleteURL(url, id);
    }
}
