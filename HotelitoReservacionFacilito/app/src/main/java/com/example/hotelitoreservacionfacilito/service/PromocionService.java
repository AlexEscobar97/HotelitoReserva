package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Promocion;

import java.io.Serializable;
import java.util.List;

public class PromocionService extends RestTemplateEntity<Promocion> implements Serializable {

    public PromocionService() {
        super(new Promocion(), Promocion.class, Promocion[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_PROMOCION;

    public List<Promocion> obtenerPromocions() {
        List<Promocion> lista = getListURL(url);
        return lista;
    }

    public Promocion obtenerPromocionPorId(Integer id) {
        Promocion enti = getOneURL(url, id);
        return enti;
    }

    public Promocion obtenerPromocionPorBody(Promocion objeto) {
        Promocion enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Promocion crearPromocion(Promocion objeto) {
        Promocion enti = createURL(url, objeto);
        return enti;
    }

    public Promocion actualizarPromocionPorId(Promocion objeto) {
        Promocion enti = updateURL(url, objeto.getIdPromocion(), objeto);
        return enti;
    }

    public void eliminarPromocionPorId(Integer id) {
        deleteURL(url, id);
    }
}
