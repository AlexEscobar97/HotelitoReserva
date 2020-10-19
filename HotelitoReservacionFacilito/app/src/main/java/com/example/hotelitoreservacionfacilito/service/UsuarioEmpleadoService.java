package com.example.hotelitoreservacionfacilito.service;

import com.example.hotelitoreservacionfacilito.entities.RespuestaGenerica;
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioEmpleadoService extends RestTemplateEntity<UsuarioEmpleado> implements Serializable {

    public UsuarioEmpleadoService() {
        super(new UsuarioEmpleado(), UsuarioEmpleado.class, UsuarioEmpleado[].class);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    private final String url = Constantes.URL_USUARIOEMEPLADO;

    public List<UsuarioEmpleado> obtenerUsuarioEmpleados() {
        List<UsuarioEmpleado> lista = getListURL(url);
        return lista;
    }

    public UsuarioEmpleado obtenerUsuarioEmpleadoPorId(Integer id) {
        UsuarioEmpleado enti = getOneURL(url, id);
        return enti;
    }

    public UsuarioEmpleado obtenerUsuarioEmpleadoPorBody(UsuarioEmpleado objeto) {
        UsuarioEmpleado enti = getByBodyURL(url, objeto);
        return enti;
    }

    public UsuarioEmpleado crearUsuarioEmpleado(UsuarioEmpleado objeto) {
        UsuarioEmpleado enti = createURL(url, objeto);
        return enti;
    }

    public UsuarioEmpleado actualizarUsuarioEmpleadoPorId(UsuarioEmpleado objeto) {
        UsuarioEmpleado enti = updateURL(url, objeto.getId_usuario_empleado(), objeto);
        return enti;
    }

    public void eliminarUsuarioEmpleadoPorId(Integer id) {
        deleteURL(url, id);
    }

    public List<UsuarioEmpleado> loginEmpleado(String usuario, String clave) {
        List<UsuarioEmpleado> list = new ArrayList<>();
        try {
            RestTemplate restTemplat = new RestTemplate();
            ResponseEntity<UsuarioEmpleado[]> response = restTemplat.getForEntity(Constantes.URL_USUARIOEMEPLADO.concat("/login/").concat(usuario).concat("/").concat(clave), UsuarioEmpleado[].class);

            list = Arrays.asList(response.getBody());
            System.out.println("Contenido Lista UsuarioEmpleado: " +list.size());
        } catch (Exception e) {
            System.out.println("error absRest getListURL: " + e.getMessage() +" " +e.getClass());
        }
        return list;
    }

    public int signIn(UsuarioEmpleado usuario){
        int i = 0;
        /*
         * 0 = server problem
         * -1 = bad username
         * -2 = bad password
         * x = signed in
         * -4 = inactive
         * */
        try {
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
                ResponseEntity<RespuestaGenerica> responses = restTemplate.exchange(Constantes.DOMINIO.concat("/usuarioLogin/").concat(usuario.getUsuario()).concat("/").concat(usuario.getClave()), HttpMethod.GET,entity, RespuestaGenerica.class);
                RespuestaGenerica response = responses.getBody();
                if (response != null){
                    if ("1".equals(response.getCodigo())){}
                    switch (response.getCodigo()){
                        case "1": i = -1;break;
                        case "2": i = -2;break;
                        case "3": i = Integer.parseInt(response.getMensaje());break;
                        case "4": i = -4;break;
                    }
                }
            } catch (Exception e) {
                System.out.println("error absRest s: " + e);

            }
        }catch (Exception e){}
        return i;
    }
}
