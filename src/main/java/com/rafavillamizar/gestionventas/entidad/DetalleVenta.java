package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonDetalleVenta")
public class DetalleVenta {
	
	private Integer detalleVentaId;
	private Integer ventaId;
	private Producto producto;
	private Integer cantidad;

	public Integer getDetalleVentaId() {
		return detalleVentaId;
	}
	public void setDetalleVentaId(Integer detalleVentaId) {
		this.detalleVentaId = detalleVentaId;
	}
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
