package com.rafavillamizar.gestionventas.entidad;

public class Ciudad {

	private Integer ciudadId;
	private Integer provinciaId;
	private String nombre;

	public Integer getCiudadId() {
		return ciudadId;
	}
	public void setCiudadId(Integer ciudadId) {
		this.ciudadId = ciudadId;
	}
	public Integer getProvinciaId() {
		return provinciaId;
	}
	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
