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
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) obj;
        if (detalleVentaId == null) {
            if (other.detalleVentaId != null) {
                return false;
            }
        } else if (!detalleVentaId.equals(other.detalleVentaId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((detalleVentaId == null) ? 0 : detalleVentaId.hashCode());
        return result;
    }
	
}
