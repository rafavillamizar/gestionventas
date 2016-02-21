package com.rafavillamizar.gestionventas.entidad;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("filtroJsonPagina")
public class Pagina<E> {
	
	private Integer numeroPagina;
	private Integer totalElementos;
	private List<E> resultado;
	
	public Integer getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public Integer getTotalElementos() {
		return totalElementos;
	}
	public void setTotalElementos(Integer totalElementos) {
		this.totalElementos = totalElementos;
	}
	public List<E> getResultado() {
		return resultado;
	}
	public void setResultado(List<E> resultado) {
		this.resultado = resultado;
	}
	
	

}
