package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.Producto;

public class FiltroJsonProducto extends SimpleBeanPropertyFilter {
	private List<String> propiedadesProducto = Arrays.asList("productoId", "name");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof Producto)
		{
			if (propiedadesProducto.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		}
	}
}
