package com.rafavillamizar.gestionventas.entidad;

public class Ciudad {

	private Integer ciudadId;
	private Provincia provincia;
	private String nombre;

	public Integer getCiudadId() {
		return ciudadId;
	}
	public void setCiudadId(Integer ciudadId) {
		this.ciudadId = ciudadId;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
