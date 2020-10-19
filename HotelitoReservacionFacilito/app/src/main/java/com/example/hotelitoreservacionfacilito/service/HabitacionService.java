package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Habitacion;

import java.io.Serializable;
import java.util.List;

public class HabitacionService extends RestTemplateEntity<Habitacion> implements Serializable {

    public HabitacionService() {
        super(new Habitacion(), Habitacion.class, Habitacion[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_HABITACION;

    public List<Habitacion> obtenerHabitacions() {
        List<Habitacion> lista = getListURL(url);
        return lista;
    }

    public Habitacion obtenerHabitacionPorId(Integer id) {
        Habitacion enti = getOneURL(url, id);
        return enti;
    }

    public Habitacion obtenerHabitacionPorBody(Habitacion objeto) {
        Habitacion enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Habitacion crearHabitacion(Habitacion objeto) {
        Habitacion enti = createURL(url, objeto);
        return enti;
    }

    public Habitacion actualizarHabitacionPorId(Habitacion objeto) {
        Habitacion enti = updateURL(url, objeto.getIdHabitacion(), objeto);
        return enti;
    }

    public void eliminarHabitacionPorId(Integer id) {
        deleteURL(url, id);
    }
}
