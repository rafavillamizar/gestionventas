package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.DaoGenerico;

@Repository
public class DaoGenericoImpl<E> implements DaoGenerico<E> {

	private static final Logger logger = LoggerFactory
			.getLogger(DaoGenericoImpl.class);

	@Autowired(required = true)
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<E> obtenerTodos(String entityName) {
		Criteria c = getSession().createCriteria(entityName);
		return c.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> obtenerTodosPorPropiedad(String entityName,
			String nombrePropiedad, Object valor) {
		Criteria c = getSession().createCriteria(entityName);
		c.add(Restrictions.eq(nombrePropiedad, valor));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return c.list();
	}
	
	@Override
    public void guardar(String entityName, E instancia) {
        getSession().persist(entityName, instancia);
    }
	
	@Override
    public void actualizar(String entityName, E instancia) {
        getSession().update(entityName, instancia);
    }
	
	@Override
    public void eliminar(String entityName, E instancia) {
        getSession().delete(entityName, instancia);
    }
	
	protected Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            logger.warn("Explicit open new session");
            return sessionFactory.openSession();
        }
    }
}
