package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.PromocionHabitacion;

import java.io.Serializable;
import java.util.List;

public class PromocionHabitacionService extends RestTemplateEntity<PromocionHabitacion> implements Serializable {

    public PromocionHabitacionService() {
        super(new PromocionHabitacion(), PromocionHabitacion.class, PromocionHabitacion[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_PROMOCIONHABI;

    public List<PromocionHabitacion> obtenerPromocionHabitacions() {
        List<PromocionHabitacion> lista = getListURL(url);
        return lista;
    }

    public PromocionHabitacion obtenerPromocionHabitacionPorId(Integer id) {
        PromocionHabitacion enti = getOneURL(url, id);
        return enti;
    }

    public PromocionHabitacion obtenerPromocionHabitacionPorBody(PromocionHabitacion objeto) {
        PromocionHabitacion enti = getByBodyURL(url, objeto);
        return enti;
    }

    public PromocionHabitacion crearPromocionHabitacion(PromocionHabitacion objeto) {
        PromocionHabitacion enti = createURL(url, objeto);
        return enti;
    }

    public PromocionHabitacion actualizarPromocionHabitacionPorId(PromocionHabitacion objeto) {
        PromocionHabitacion enti = updateURL(url, objeto.getIdPromHab(), objeto);
        return enti;
    }

    public void eliminarPromocionHabitacionPorId(Integer id) {
        deleteURL(url, id);
    }
}
