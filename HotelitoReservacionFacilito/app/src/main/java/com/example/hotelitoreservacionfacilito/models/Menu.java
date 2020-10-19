package com.example.hotelitoreservacionfacilito.models;

public class Menu{
    
    private static final long serialVersionUID = 1L;

    private int idMenu;
    private String nombre;
    private String descripcion;

    public Menu() {
    }

    public Menu(int idMenu, String nombre, String descripcion) {
        this.idMenu = idMenu;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{idMenu:'");
        builder.append(idMenu);
        builder.append("',nombre:'");
        builder.append(nombre);
        builder.append("',descripcion:'");
        builder.append(descripcion);
        builder.append("'}");
        return builder.toString();
    }
}
