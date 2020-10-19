package com.example.hotelitoreservacionfacilito.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Reserva{

    private int idReserva;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;
    private Double total;
    private Cliente idCliente;
    private Habitacion idHabitacion;
    private PromocionHabitacion idPromocionHabitacion;
    private EstadoReserva idEstado;

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public PromocionHabitacion getIdPromocion() {
        return idPromocionHabitacion;
    }

    public void setIdPromocion(PromocionHabitacion idPromocionHabitacion) {
        this.idPromocionHabitacion = idPromocionHabitacion;
    }

    public EstadoReserva getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoReserva idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", total=" + total + ", idCliente=" + idCliente + ", idHabitacion=" + idHabitacion + ", idPromocion=" + idPromocionHabitacion + ", idEstado=" + idEstado + '}';
    }

}
