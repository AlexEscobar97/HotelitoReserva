package com.example.hotelitoreservacionfacilito.models;

public class Rol{

    private int id_rol;
    private String nombre_rol;

    public Rol() {
    }

    public Rol(int id_rol, String nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    
    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
     @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id_rol:'");
        builder.append(id_rol);
        builder.append("',nombre_rol:'");
        builder.append(nombre_rol);
        builder.append("'}");
        return builder.toString();
    }
    
}
