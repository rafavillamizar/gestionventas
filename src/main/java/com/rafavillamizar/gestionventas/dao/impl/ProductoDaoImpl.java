package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Producto;

@Repository
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements ProductoDao {
	
	@Autowired(required = true)
    protected SessionFactory sessionFactory;

	@Override
	public List<Producto> obtenerProductos() {
		return obtenerTodos("Producto");
	}

}
