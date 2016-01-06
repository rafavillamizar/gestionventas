package com.rafavillamizar.gestionventas.entidad;

public class DetalleVenta {
	
	private Integer detalleVentaId;
	private Integer ventaId;
	private Producto productoId;
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
	public Producto getProductoId() {
		return productoId;
	}
	public void setProductoId(Producto productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
