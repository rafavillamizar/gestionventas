package com.rafavillamizar.gestionventas.dao;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Cliente;

public interface ClienteDao {
	
    List<Cliente> obtenerClientes(String nif);
    void guardarCliente(Cliente cliente);
	void eliminarCliente(Integer clienteId);
}
