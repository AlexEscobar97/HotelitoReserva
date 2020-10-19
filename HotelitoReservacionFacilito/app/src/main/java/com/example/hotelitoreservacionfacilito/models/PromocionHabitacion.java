package com.example.hotelitoreservacionfacilito.models;

public class PromocionHabitacion{

	private int idPromHab;
    private Habitacion idHabitacion;
    private Promocion idPromocion;
    
	public PromocionHabitacion() {
		super();
	}

	public PromocionHabitacion(int idPromHab, Habitacion idHabitacion, Promocion idPromocion) {
		super();
		this.idPromHab = idPromHab;
		this.idHabitacion = idHabitacion;
		this.idPromocion = idPromocion;
	}

	public int getIdPromHab() {
		return idPromHab;
	}

	public void setIdPromHab(int idPromHab) {
		this.idPromHab = idPromHab;
	}

	public Habitacion getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Habitacion idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Promocion getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Promocion idPromocion) {
		this.idPromocion = idPromocion;
	}

	@Override
	public String toString() {
		return "PromocionHabitacion [idPromHab=" + idPromHab + ", idHabitacion=" + idHabitacion + ", idPromocion="
				+ idPromocion + "]";
	}
	
}
