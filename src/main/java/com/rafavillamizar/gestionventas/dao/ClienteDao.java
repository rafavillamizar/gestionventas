package com.rafavillamizar.gestionventas.dao;

import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Pagina;

public interface ClienteDao {
	
	Pagina<Cliente> obtenerClientesPorPropiedadPaginado(String nif, Integer numeroPagina);
    Pagina<Cliente> obtenerClientesPaginado(Integer numeroPagina);
    Pagina<Cliente> obtenerClientes();
    void guardarCliente(Cliente cliente);
	void eliminarCliente(Integer clienteId);
}
