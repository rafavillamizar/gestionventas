package com.rafavillamizar.gestionventas.servicio;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Cliente;

public interface ClienteServicio {
	
	List<Cliente> obtenerClientes();
	void guardarCliente(Cliente cliente);
	void eliminarCliente(Integer clienteId);
}
