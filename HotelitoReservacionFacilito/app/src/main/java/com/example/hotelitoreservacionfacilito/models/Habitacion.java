package com.example.hotelitoreservacionfacilito.models;

public class Habitacion{


	private int idHabitacion;
	private String nombreHabitacion;
	private int estadoHabitacion;
	private TipoHabitacion tipoHabitacion;	
	
	public Habitacion() {
		super();
	}


	public Habitacion(int idHabitacion, String nombreHabitacion, int estadoHabitacion,
			TipoHabitacion tipoHabitacion) {
		super();
		this.idHabitacion = idHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.estadoHabitacion = estadoHabitacion;
		this.tipoHabitacion = tipoHabitacion;
	}


	public int getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	public String getNombreHabitacion() {
		return nombreHabitacion;
	}


	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}


	public int getEstadoHabitacion() {
		return estadoHabitacion;
	}


	public void setEstadoHabitacion(int estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}


	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}


	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}


	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + ", nombreHabitacion=" + nombreHabitacion
				+ ", estadoHabitacion=" + estadoHabitacion + ", tipoHabitacion=" + tipoHabitacion + "]";
	}

	
}
