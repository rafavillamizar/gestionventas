package com.rafavillamizar.gestionventas.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.InformeDao;
import com.rafavillamizar.gestionventas.entidad.Informe;
import com.rafavillamizar.gestionventas.entidad.Pagina;

@Repository
public class InformeDaoImpl extends DaoGenericoImpl<Informe> implements
		InformeDao {

	@Override
	public Pagina<Informe> obtenerInformePorMesAnioPaginado(Integer anio,
			Integer mes, Integer numeroPagina) {
		Query q = getSession().getNamedQuery("obtenerInformePorMesYAnioPaginado");
		q.setParameter("anio", anio);
		q.setParameter("mes", mes);
		q.setParameter("inicio", (numeroPagina - 1) * 5);
		q.setParameter("fin", 5);
		q.setResultTransformer(Transformers.aliasToBean(Informe.class));
		@SuppressWarnings("unchecked")
		List<Informe> informes = q.list();
		
		Integer totalElementos = 0; 
				
		q = getSession().getNamedQuery("obtenerTotalInformePorMesYAnio");
		q.setParameter("anio", anio);
		q.setParameter("mes", mes);
		
		Object result = q.uniqueResult();
        if (result instanceof BigInteger)
        {
        	totalElementos = ((BigInteger)result).intValue();
        } else
        	totalElementos = (Integer)result;

		
		Pagina<Informe> paginaInforme = new Pagina<Informe>();
		paginaInforme.setNumeroPagina(numeroPagina);
		paginaInforme.setTotalElementos(totalElementos);
		paginaInforme.setResultado(informes);

		return paginaInforme;
	}


}
