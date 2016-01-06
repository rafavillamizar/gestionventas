package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonProducto")
public class Producto {
	private Integer productoId;
    private String name;
    
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
