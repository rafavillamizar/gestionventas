package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.servicio.ClienteServicio;

@Service("clienteServicio")
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired(required = true)
    private ClienteDao clienteDao;

	@Override
	public List<Cliente> obtenerClientes() {
		return clienteDao.obtenerClientes();
	}

}
