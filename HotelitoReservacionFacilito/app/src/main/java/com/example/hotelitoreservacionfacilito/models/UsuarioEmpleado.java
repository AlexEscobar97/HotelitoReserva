package com.example.hotelitoreservacionfacilito.models;


public class UsuarioEmpleado{

    private int id_usuario_empleado;
    private String usuario;
    private String clave;
    private Personal personal;

    public UsuarioEmpleado() {
    }

    public UsuarioEmpleado(int id_usuario_empleado, String usuario, String clave, Personal personal) {
		super();
		this.id_usuario_empleado = id_usuario_empleado;
		this.usuario = usuario;
		this.clave = clave;
		this.personal = personal;
	}

	public int getId_usuario_empleado() {
		return id_usuario_empleado;
	}



	public void setId_usuario_empleado(int id_usuario_empleado) {
		this.id_usuario_empleado = id_usuario_empleado;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public Personal getPersonal() {
		return personal;
	}



	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "UsuarioEmpleado [id_usuario_empleado=" + id_usuario_empleado + ", usuario=" + usuario + ", clave="
				+ clave + ", personal=" + personal + "]";
	}
  
}
