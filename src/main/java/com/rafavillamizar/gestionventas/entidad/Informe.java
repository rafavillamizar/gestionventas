package com.rafavillamizar.gestionventas.entidad;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonInforme")
public class Informe {
	
    private Integer unidadesVendidas;
    private Double ventasMes;
    private String nombreCompleto;
    
	public Integer getUnidadesVendidas() {
		return unidadesVendidas;
	}
	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}
	public Double getVentasMes() {
		return ventasMes;
	}
	public void setVentasMes(Double ventasMes) {
		this.ventasMes = ventasMes;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
    
}
