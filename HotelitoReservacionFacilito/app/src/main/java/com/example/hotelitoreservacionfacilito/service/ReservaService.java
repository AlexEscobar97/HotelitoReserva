package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Reserva;

import java.io.Serializable;
import java.util.List;

public class ReservaService extends RestTemplateEntity<Reserva> implements Serializable {

    public ReservaService() {
        super(new Reserva(), Reserva.class, Reserva[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_RESERVA;

    public List<Reserva> obtenerReservas() {
        List<Reserva> lista = getListURL(url);
        return lista;
    }

    public Reserva obtenerReservaPorId(Integer id) {
        Reserva enti = getOneURL(url, id);
        return enti;
    }

    public Reserva obtenerReservaPorBody(Reserva objeto) {
        Reserva enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Reserva crearReserva(Reserva objeto) {
        Reserva enti = createURL(url, objeto);
        return enti;
    }

    public Reserva actualizarReservaPorId(Reserva objeto) {
        Reserva enti = updateURL(url, objeto.getIdReserva(), objeto);
        return enti;
    }

    public void eliminarReservaPorId(Integer id) {
        deleteURL(url, id);
    }
}
