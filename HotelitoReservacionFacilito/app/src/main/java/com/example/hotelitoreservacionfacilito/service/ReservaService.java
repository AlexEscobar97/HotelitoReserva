package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.models.Reserva;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Reserva> reservaCliente(String idCliente) {
        List<Reserva> list = new ArrayList<>();
        try {
            RestTemplate restTemplat = new RestTemplate();
            ResponseEntity<Reserva[]> response = restTemplat.getForEntity(Constantes.URL_RESERVA.concat("/reservaCliente/").concat(idCliente), Reserva[].class);

            list = Arrays.asList(response.getBody());
            System.out.println("Contenido Lista Reserva: " +list.size());
        } catch (Exception e) {
            System.out.println("error absRest getListURL: " + e.getMessage() +" " +e.getClass());
        }
        return list;
    }

    public void eliminarReservaPorId(Integer id) {
        deleteURL(url, id);
    }
}
