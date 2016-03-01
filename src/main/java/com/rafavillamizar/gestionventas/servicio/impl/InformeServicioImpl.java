package com.rafavillamizar.gestionventas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.InformeDao;
import com.rafavillamizar.gestionventas.entidad.Informe;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.servicio.InformeServicio;

@Service("informeServicio")
public class InformeServicioImpl implements InformeServicio {
	
	@Autowired(required = true)
    private InformeDao informeDao;

	@Transactional(readOnly=true)
	@Override
	public  Pagina<Informe> obtenerInformePorMesAnioPaginado(Integer anio, Integer mes, Integer numeroPagina) {
		return informeDao.obtenerInformePorMesAnioPaginado(anio, mes, numeroPagina);
	}

}
