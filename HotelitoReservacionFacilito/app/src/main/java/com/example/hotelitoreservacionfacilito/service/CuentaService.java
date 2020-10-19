package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Cuenta;

import java.io.Serializable;
import java.util.List;

public class CuentaService extends RestTemplateEntity<Cuenta> implements Serializable {

    public CuentaService() {
        super(new Cuenta(), Cuenta.class, Cuenta[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_CUENTA;

    public List<Cuenta> obtenerCuentas() {
        List<Cuenta> lista = getListURL(url);
        return lista;
    }

    public Cuenta obtenerCuentaPorId(Integer id) {
        Cuenta enti = getOneURL(url, id);
        return enti;
    }

    public Cuenta obtenerCuentaPorBody(Cuenta objeto) {
        Cuenta enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Cuenta crearCuenta(Cuenta objeto) {
        Cuenta enti = createURL(url, objeto);
        return enti;
    }

    public Cuenta actualizarCuentaPorId(Cuenta objeto) {
        Cuenta enti = updateURL(url, objeto.getIdCuenta(), objeto);
        return enti;
    }

    public void eliminarCuentaPorId(Integer id) {
        deleteURL(url, id);
    }
}
