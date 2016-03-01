package com.rafavillamizar.gestionventas.servicio;

import com.rafavillamizar.gestionventas.entidad.Informe;
import com.rafavillamizar.gestionventas.entidad.Pagina;

public interface InformeServicio {
	
	Pagina<Informe> obtenerInformePorMesAnioPaginado(Integer anio, Integer mes, Integer numeroPagina);
}
