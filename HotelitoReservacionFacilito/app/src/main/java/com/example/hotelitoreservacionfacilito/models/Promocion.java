package com.example.hotelitoreservacionfacilito.models;

import java.util.Date;

public class Promocion{

    private int idPromocion;
    private String nombrePromocion;
    private double descuento;
    private Date fechaIinicioProm;
    private Date fechaFinProm;

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaIinicioProm() {
        return fechaIinicioProm;
    }

    public void setFechaIinicioProm(Date fechaIinicioProm) {
        this.fechaIinicioProm = fechaIinicioProm;
    }

    public Date getFechaFinProm() {
        return fechaFinProm;
    }

    public void setFechaFinProm(Date fechaFinProm) {
        this.fechaFinProm = fechaFinProm;
    }

    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", nombrePromocion=" + nombrePromocion +", descuento=" + descuento + ", fechaIinicioProm=" + fechaIinicioProm + ", fechaFinProm=" + fechaFinProm + '}';
    }
    
}
