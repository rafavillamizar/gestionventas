package com.rafavillamizar.gestionventas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.servicio.ClienteServicio;

@Service("clienteServicio")
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired(required = true)
    private ClienteDao clienteDao;
	
	@Transactional(readOnly=true)
	@Override
	public Pagina<Cliente> obtenerClientesPorPropiedadPaginado(String nif,
			Integer numeroPagina) {
		return clienteDao.obtenerClientesPorPropiedadPaginado(nif, numeroPagina);
	}

	@Transactional(readOnly=true)
	@Override
	public Pagina<Cliente> obtenerClientesPaginado(Integer numeroPagina) {
		return clienteDao.obtenerClientesPaginado(numeroPagina);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Pagina<Cliente> obtenerClientes() {
		return clienteDao.obtenerClientes();
	}

	@Transactional
	@Override
	public void guardarCliente(Cliente cliente) {
		clienteDao.guardarCliente(cliente);
	}

	@Transactional
	@Override
	public void eliminarCliente(Integer clienteId) {
		clienteDao.eliminarCliente(clienteId);
	}

}
