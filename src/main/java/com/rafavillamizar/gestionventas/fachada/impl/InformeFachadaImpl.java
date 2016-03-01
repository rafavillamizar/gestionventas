package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rafavillamizar.gestionventas.entidad.Informe;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.json.FiltroJsonInforme;
import com.rafavillamizar.gestionventas.json.FiltroJsonPagina;
import com.rafavillamizar.gestionventas.servicio.InformeServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class InformeFachadaImpl {

	@Resource
	private InformeServicio informeServicio;

	@RequestMapping(value = "/informe", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerInformePorMesAnioPaginado(@RequestParam(value = "anio", required = false, defaultValue = "") Integer anio,
			@RequestParam(value = "mes", required = false, defaultValue = "") Integer mes,
			@RequestParam(value = "numeroPagina", required = false, defaultValue = "0") Integer numeroPagina, 
			HttpServletResponse response)
					throws JsonGenerationException, JsonMappingException, IOException {
		Pagina<Informe> paginaInforme = null;
		
		if(numeroPagina != null && numeroPagina.compareTo(1) >= 0) {
			if(anio != null && mes != null)
				paginaInforme = informeServicio.obtenerInformePorMesAnioPaginado(anio, mes, numeroPagina);
		}
		
		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonPagina(),
				paginaInforme, response);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonPagina()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonPagina", new FiltroJsonPagina());
		filters.addFilter("filtroJsonInforme", new FiltroJsonInforme());
		
		return filters;
	}

}
