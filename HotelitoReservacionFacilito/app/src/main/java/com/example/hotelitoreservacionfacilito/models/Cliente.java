package com.example.hotelitoreservacionfacilito.models;

public class Cliente {

    private static final long serialVersionUID = 1L;

    private int idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;


    public Cliente() {
        super();
    }

    public Cliente(int idCliente, String nombre, String apellido, String correo, String usuario, String clave, String estado) {
        super();
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
                + correo + ", usuario=" + usuario + ", clave=" + clave + ", estado=" + estado + "]";
    }
}
