package com.rafavillamizar.gestionventas.entidad;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonVenta")
public class Venta {

	private Integer ventaId;
	private Date fechaVenta;
	private Cliente cliente;
	private List<DetalleVenta> detalles;
	
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<DetalleVenta> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
}
