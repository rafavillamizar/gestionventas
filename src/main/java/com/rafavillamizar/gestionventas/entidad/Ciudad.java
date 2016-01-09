package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonCiudad")
public class Ciudad {

	private Integer ciudadId;
	private Provincia provincia;
	private String nombre;
	
	private String nombreLocalizacion;

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
	public String getNombreLocalizacion() {
		if(!nombre.isEmpty() && provincia != null && 
				!provincia.getNombre().isEmpty() && provincia.getPais() != null && 
				!provincia.getPais().getNombre().isEmpty())
			return nombre + "(" + provincia.getNombre() + "-" + provincia.getPais().getNombre() + ")";
		
		return nombreLocalizacion;
	}
	public void setNombreLocalizacion(String nombreLocalizacion) {
		this.nombreLocalizacion = nombreLocalizacion;
	}
	
}
