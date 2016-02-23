package com.rafavillamizar.gestionventas.dao.impl;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Pagina;

@Repository
public class ClienteDaoImpl extends DaoGenericoImpl<Cliente> implements ClienteDao {

	@Override
	public Pagina<Cliente> obtenerClientesPorPropiedadPaginado(String nif,
			Integer numeroPagina) {
		Pagina<Cliente> paginaCliente = new Pagina<Cliente>();
		paginaCliente.setNumeroPagina(numeroPagina);
		paginaCliente.setTotalElementos(obtenerNumeroElementosPorPropiedadPaginado("Cliente", "nif", nif));
		paginaCliente.setResultado(obtenerTodosPorPropiedadPaginado(
				"Cliente", "nif", nif, "clienteId",
				numeroPagina));

		return paginaCliente;
	}

	@Override
	public Pagina<Cliente> obtenerClientesPaginado(Integer numeroPagina) {
		Pagina<Cliente> paginaCliente = new Pagina<Cliente>();
		paginaCliente.setNumeroPagina(numeroPagina);
		paginaCliente.setTotalElementos(obtenerNumeroElementosPaginado("Cliente"));
		paginaCliente.setResultado(obtenerTodosPaginado("Cliente",
				"clienteId", numeroPagina));

		return paginaCliente;
	}
	
	@Override
	public Pagina<Cliente> obtenerClientes() {
		Pagina<Cliente> paginaCliente = new Pagina<Cliente>();
		paginaCliente.setNumeroPagina(0);
		paginaCliente.setTotalElementos(0);
		paginaCliente.setResultado(obtenerTodos("Cliente"));

		return paginaCliente;
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		guardar("Cliente", cliente);
	}

	@Override
	public void eliminarCliente(Integer clienteId) {
		String clienteEntityName = "Cliente";
		Cliente cliente = obtenerById(clienteEntityName, clienteId);
		
		if(cliente != null)
			eliminar("Cliente", cliente);
	}

}
