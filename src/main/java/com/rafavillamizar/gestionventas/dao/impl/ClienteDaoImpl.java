package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ClienteDao;
import com.rafavillamizar.gestionventas.entidad.Cliente;

@Repository
public class ClienteDaoImpl extends DaoGenericoImpl<Cliente> implements ClienteDao {

	@Override
	public List<Cliente> obtenerClientes(String nif) {
//		if(nif != null && !nif.isEmpty())
//			return obtenerTodosPorPropiedad("Cliente", "nif", nif);
//		else
//			return obtenerTodos("Cliente");
		return null;
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
