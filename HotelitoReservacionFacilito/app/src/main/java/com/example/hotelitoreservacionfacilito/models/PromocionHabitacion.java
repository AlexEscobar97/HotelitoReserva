package com.example.hotelitoreservacionfacilito.models;

public class PromocionHabitacion{

	private int idPromHab;
    private Habitacion habitacion;
    private Promocion promocion;

	public PromocionHabitacion() {
		super();
	}

	public PromocionHabitacion(int idPromHab, Habitacion habitacion, Promocion promocion) {
		super();
		this.idPromHab = idPromHab;
		this.habitacion = habitacion;
		this.promocion = promocion;
	}

	public int getIdPromHab() {
		return idPromHab;
	}

	public void setIdPromHab(int idPromHab) {
		this.idPromHab = idPromHab;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	@Override
	public String toString() {
		return "PromocionHabitacion [idPromHab=" + idPromHab + ", habitacion=" + habitacion + ", promocion="
				+ promocion + "]";
	}
	
}
