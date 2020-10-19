package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Servicio;

import java.io.Serializable;
import java.util.List;

public class ServicioService extends RestTemplateEntity<Servicio> implements Serializable {

    public ServicioService() {
        super(new Servicio(), Servicio.class, Servicio[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_SERVICIO;

    public List<Servicio> obtenerServicios() {
        List<Servicio> lista = getListURL(url);
        return lista;
    }

    public Servicio obtenerServicioPorId(Integer id) {
        Servicio enti = getOneURL(url, id);
        return enti;
    }

    public Servicio obtenerServicioPorBody(Servicio objeto) {
        Servicio enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Servicio crearServicio(Servicio objeto) {
        Servicio enti = createURL(url, objeto);
        return enti;
    }

    public Servicio actualizarServicioPorId(Servicio objeto) {
        Servicio enti = updateURL(url, objeto.getIdServicio(), objeto);
        return enti;
    }

    public void eliminarServicioPorId(Integer id) {
        deleteURL(url, id);
    }
}
