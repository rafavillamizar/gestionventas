package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonProducto")
public class Producto {
	
	private Integer productoId;
	private String referencia;
    private String nombre;
    private String imagen;
    private Integer precio;
    private String caracteristicas;
    
    //Propiedades no mapeadas
    private String imagenUrl;
    
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
    
}
