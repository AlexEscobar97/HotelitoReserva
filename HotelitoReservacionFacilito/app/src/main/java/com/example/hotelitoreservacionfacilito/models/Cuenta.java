package com.example.hotelitoreservacionfacilito.models;

public class Cuenta {

    private int idCuenta;
    private Servicio idServicio;
    private Reserva idReserva;

    public Cuenta() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", idServicio=" + idServicio + ", idReserva=" + idReserva + '}';
    }
}
