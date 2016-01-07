package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.DetalleVenta;

public class FiltroJsonDetalleVenta extends SimpleBeanPropertyFilter {
	private List<String> propiedadesDetalleVenta = Arrays.asList("detalleVentaId", "ventaId", "cantidad", "producto");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof DetalleVenta)
		{
			if (propiedadesDetalleVenta.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		}
	}
}
