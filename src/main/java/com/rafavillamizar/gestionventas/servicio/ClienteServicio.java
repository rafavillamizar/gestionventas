package com.rafavillamizar.gestionventas.servicio;

import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Pagina;

public interface ClienteServicio {
	
	Pagina<Cliente> obtenerClientesPorPropiedadPaginado(String nif, Integer numeroPagina);
	Pagina<Cliente> obtenerClientesPaginado(Integer numeroPagina);
	Pagina<Cliente> obtenerClientes();
	void guardarCliente(Cliente cliente);
	void eliminarCliente(Integer clienteId);
}
