package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.Informe;

public class FiltroJsonInforme extends SimpleBeanPropertyFilter {
	private List<String> propiedadesInforme = Arrays.asList("nombreCompleto", "unidadesVendidas", "ventasMes");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof Informe)
		{
			if (propiedadesInforme.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		}
	}
}
