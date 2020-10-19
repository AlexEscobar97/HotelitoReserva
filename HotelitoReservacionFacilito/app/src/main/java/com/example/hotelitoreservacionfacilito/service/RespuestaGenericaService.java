package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.entities.RespuestaGenerica;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespuestaGenericaService extends RestTemplateEntity<RespuestaGenerica> implements Serializable {

    public RespuestaGenericaService() {
        super(new RespuestaGenerica(), RespuestaGenerica.class, RespuestaGenerica[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_CLIENTE;



    public List<RespuestaGenerica> loginRespuestaGenerica(String usuario, String clave) {
        List<RespuestaGenerica> list = new ArrayList<>();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
                @Override
                protected boolean hasError(HttpStatus statusCode) {
                    // desactivar el error loader
                    // al recivir una respuesta de tipo error
                    return false;
                }
            });
            HttpEntity<Object> entity = new HttpEntity<Object>(headers);
            RestTemplate restTemplat = new RestTemplate();
            ResponseEntity<RespuestaGenerica> response = restTemplat.getForEntity(Constantes.DOMINIO.concat("/login/").concat(usuario).concat("/").concat(clave), RespuestaGenerica.class);

            list = Arrays.asList(response.getBody());
            System.out.println("Contenido Lista RespuestaGenerica: " +list.size());
        } catch (Exception e) {
            System.out.println("error absRest getListURL: " + e.getMessage() +" " +e.getClass());
        }
        return list;
    }

    public void eliminarRespuestaGenericaPorId(Integer id) {
        deleteURL(url, id);
    }
}
