package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.servicio.ClienteServicio;

@Service("clienteServicio")
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired(required = true)
    private ClienteDao clienteDao;

	@Transactional(readOnly=true)
	@Override
	public List<Cliente> obtenerClientes() {
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
		// TODO Auto-generated method stub
	}

}
