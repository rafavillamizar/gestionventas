package com.rafavillamizar.gestionventas.dao;

import com.rafavillamizar.gestionventas.entidad.Informe;
import com.rafavillamizar.gestionventas.entidad.Pagina;

public interface InformeDao {
	
    Pagina<Informe> obtenerInformePorMesAnioPaginado(Integer anio, Integer mes, Integer numeroPagina);
}
