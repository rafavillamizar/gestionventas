package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.Ciudad;

public class FiltroJsonCiudad extends SimpleBeanPropertyFilter {
	private List<String> propiedadesCiudad = Arrays.asList("ciudadId", "nombreLocalizacion");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof Ciudad)
		{
			if (propiedadesCiudad.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		} 
	}
}
