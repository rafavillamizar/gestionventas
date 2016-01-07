package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.Venta;

public class FiltroJsonVenta extends SimpleBeanPropertyFilter {
	private List<String> propiedadesVenta = Arrays.asList("ventaId", "fechaVenta", "cliente");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof Venta)
		{
			if (propiedadesVenta.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		}
	}
}
