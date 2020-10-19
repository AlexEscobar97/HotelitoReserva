package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteService extends RestTemplateEntity<Cliente> implements Serializable {

    public ClienteService() {
        super(new Cliente(), Cliente.class, Cliente[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_CLIENTE;

    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = getListURL(url);
        return lista;
    }

    public Cliente obtenerClientePorId(Integer id) {
        Cliente enti = getOneURL(url, id);
        return enti;
    }

    public Cliente obtenerClientePorBody(Cliente objeto) {
        Cliente enti = getByBodyURL(url, objeto);
        return enti;
    }

    public Cliente crearCliente(Cliente objeto) {
        Cliente enti = createURL(url, objeto);
        return enti;
    }

    public Cliente actualizarClientePorId(Cliente objeto) {
        Cliente enti = updateURL(url, objeto.getIdCliente(), objeto);
        return enti;
    }

    public List<Cliente> loginCliente(String usuario, String clave) {
        List<Cliente> list = new ArrayList<>();
        try {
            RestTemplate restTemplat = new RestTemplate();
            ResponseEntity<Cliente[]> response = restTemplat.getForEntity(Constantes.URL_CLIENTE.concat("/login/").concat(usuario).concat("/").concat(clave), Cliente[].class);

            list = Arrays.asList(response.getBody());
            System.out.println("Contenido Lista Cliente: " +list.size());
        } catch (Exception e) {
            System.out.println("error absRest getListURL: " + e.getMessage() +" " +e.getClass());
        }
        return list;
    }

    public void eliminarClientePorId(Integer id) {
        deleteURL(url, id);
    }
}
