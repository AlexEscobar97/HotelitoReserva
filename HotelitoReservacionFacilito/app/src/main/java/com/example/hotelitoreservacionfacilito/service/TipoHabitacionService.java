package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.TipoHabitacion;

import java.io.Serializable;
import java.util.List;

public class TipoHabitacionService extends RestTemplateEntity<TipoHabitacion> implements Serializable {

    public TipoHabitacionService() {
        super(new TipoHabitacion(), TipoHabitacion.class, TipoHabitacion[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_TIPOHAB;

    public List<TipoHabitacion> obtenerTipoHabitacions() {
        List<TipoHabitacion> lista = getListURL(url);
        return lista;
    }

    public TipoHabitacion obtenerTipoHabitacionPorId(Integer id) {
        TipoHabitacion enti = getOneURL(url, id);
        return enti;
    }

    public TipoHabitacion obtenerTipoHabitacionPorBody(TipoHabitacion objeto) {
        TipoHabitacion enti = getByBodyURL(url, objeto);
        return enti;
    }

    public TipoHabitacion crearTipoHabitacion(TipoHabitacion objeto) {
        TipoHabitacion enti = createURL(url, objeto);
        return enti;
    }

    public TipoHabitacion actualizarTipoHabitacionPorId(TipoHabitacion objeto) {
        TipoHabitacion enti = updateURL(url, objeto.getIdTipoHabitacion(), objeto);
        return enti;
    }

    public void eliminarTipoHabitacionPorId(Integer id) {
        deleteURL(url, id);
    }
}
