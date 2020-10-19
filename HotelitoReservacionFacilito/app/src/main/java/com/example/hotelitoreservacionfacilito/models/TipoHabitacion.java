package com.example.hotelitoreservacionfacilito.models;

public class TipoHabitacion{

	private int idTipoHabitacion;
	private String titulo;
	private String descripcion;
	private double precio;
	
	
	public TipoHabitacion() {
		super();
	}

	public TipoHabitacion(int idTipoHabitacion, String titulo, String descripcion, double precio) {
		super();
		this.idTipoHabitacion = idTipoHabitacion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public void setIdTipoHabitacion(int idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
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
		return "TipoHabitacion [idTipoHabitacion=" + idTipoHabitacion + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	

}
