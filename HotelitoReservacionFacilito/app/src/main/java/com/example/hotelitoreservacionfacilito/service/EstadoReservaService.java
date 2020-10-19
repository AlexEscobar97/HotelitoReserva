package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.EstadoReserva;

import java.io.Serializable;
import java.util.List;

public class EstadoReservaService extends RestTemplateEntity<EstadoReserva> implements Serializable {

    public EstadoReservaService() {
        super(new EstadoReserva(), EstadoReserva.class, EstadoReserva[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_ESTADORESERVA;

    public List<EstadoReserva> obtenerEstadoReservas() {
        List<EstadoReserva> lista = getListURL(url);
        return lista;
    }

    public EstadoReserva obtenerEstadoReservaPorId(Integer id) {
        EstadoReserva enti = getOneURL(url, id);
        return enti;
    }

    public EstadoReserva obtenerEstadoReservaPorBody(EstadoReserva objeto) {
        EstadoReserva enti = getByBodyURL(url, objeto);
        return enti;
    }

    public EstadoReserva crearEstadoReserva(EstadoReserva objeto) {
        EstadoReserva enti = createURL(url, objeto);
        return enti;
    }

    public EstadoReserva actualizarEstadoReservaPorId(EstadoReserva objeto) {
        EstadoReserva enti = updateURL(url, objeto.getIdEstadoReserva(), objeto);
        return enti;
    }

    public void eliminarEstadoReservaPorId(Integer id) {
        deleteURL(url, id);
    }
}
