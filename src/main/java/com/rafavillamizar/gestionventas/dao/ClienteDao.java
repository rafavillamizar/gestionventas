package com.rafavillamizar.gestionventas.dao;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Cliente;

public interface ClienteDao {
	
    List<Cliente> obtenerClientes();
    void guardarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
	void eliminarCliente(Cliente cliente);
}
