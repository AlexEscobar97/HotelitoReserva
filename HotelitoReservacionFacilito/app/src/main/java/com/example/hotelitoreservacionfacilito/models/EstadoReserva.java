package com.example.hotelitoreservacionfacilito.models;

public class EstadoReserva{


    private int idEstadoReserva;
    private String descripcion;

    public int getIdEstadoReserva() {
        return idEstadoReserva;
    }

    public void setIdEstadoReserva(int idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstadoReserva{" + "idEstadoReserva=" + idEstadoReserva + ", descripcion=" + descripcion + '}';
    }

}
