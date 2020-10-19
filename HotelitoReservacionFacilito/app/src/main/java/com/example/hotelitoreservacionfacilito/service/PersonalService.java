package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Personal;

import java.io.Serializable;
import java.util.List;

public class PersonalService extends RestTemplateEntity<Personal> implements Serializable {

    public PersonalService() {
        super(new Personal(), Personal.class, Personal[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_PERSONAL;

    public List<Personal> obtenerPersonals() {
        List<Personal> lista = getListURL(url);
        return lista;
    }

    public Personal obtenerPersonalPorId(Integer id) {
        Personal enti = getOneURL(url, id);
        return enti;
    }

    public Personal obtenerPersonalPorBody(Personal objeto) {
        Personal enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Personal crearPersonal(Personal objeto) {
        Personal enti = createURL(url, objeto);
        return enti;
    }

    public Personal actualizarPersonalPorId(Personal objeto) {
        Personal enti = updateURL(url, objeto.getIdPersonal(), objeto);
        return enti;
    }

    public void eliminarPersonalPorId(Integer id) {
        deleteURL(url, id);
    }
}
