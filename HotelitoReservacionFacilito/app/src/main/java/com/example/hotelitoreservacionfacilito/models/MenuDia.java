package com.example.hotelitoreservacionfacilito.models;
import java.util.Date;

public class MenuDia{

    private int idMenuDia;
    private Date fecha;
    private Menu menu;

    public MenuDia() {
    }

    public MenuDia(int idMenuDia, Date fecha, Menu menu) {
		super();
		this.idMenuDia = idMenuDia;
		this.fecha = fecha;
		this.menu = menu;
	}

	public int getIdMenuDia() {
		return idMenuDia;
	}

	public void setIdMenuDia(int idMenuDia) {
		this.idMenuDia = idMenuDia;
	}

	public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id_menu_dia:'");
        builder.append(idMenuDia);
        builder.append("',fecha:'");
        builder.append(fecha);
        builder.append("',menu:'");
        builder.append(menu);
        builder.append("'}");
        return builder.toString();
    }
    
}
