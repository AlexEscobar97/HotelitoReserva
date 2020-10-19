package com.example.hotelitoreservacionfacilito.models;

public class Servicio{

    private int idServicio;
    private String titulo;
    private String descripcion;
    private double precio;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServivio=" + idServicio + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    

}
