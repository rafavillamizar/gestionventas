package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonCiudad")
public class Ciudad {

	private Integer ciudadId;
	private Provincia provincia;
	@JsonProperty("nombreCiudad")
	private String nombre;
	
	private String nombreProvincia;
	private String nombrePais;

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
	public String getNombreProvincia() {
		if (provincia != null && !provincia.getNombre().isEmpty())
			return provincia.getNombre();
		
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public String getNombrePais() {
		if(provincia != null && provincia.getPais() != null && !provincia.getPais().getNombre().isEmpty())
			return provincia.getPais().getNombre();
		
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
}
