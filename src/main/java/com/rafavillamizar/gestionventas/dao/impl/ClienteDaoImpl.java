package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;

@Repository
public class ClienteDaoImpl extends DaoGenericoImpl<Cliente> implements ClienteDao {

	@Override
	public List<Cliente> obtenerClientes() {
		return obtenerTodos("Cliente");
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		guardar("Cliente", cliente);
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		actualizar("Cliente", cliente);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		eliminar("Cliente", cliente);
	}
	
}
