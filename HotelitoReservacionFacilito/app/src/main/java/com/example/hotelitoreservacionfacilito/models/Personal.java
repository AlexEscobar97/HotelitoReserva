package com.example.hotelitoreservacionfacilito.models;

public class Personal{

    private Integer idPersonal;
    private String nombre;
    private String apellido;
    private Rol rol;
    
	public Personal() {
		super();
	}

	public Personal(Integer idPersonal, String nombre, String apellido, Rol rol) {
		super();
		this.idPersonal = idPersonal;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol
				+ "]";
	}
	
}
