package com.rafavillamizar.gestionventas.json;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;

import com.rafavillamizar.gestionventas.entidad.Cliente;

public class FiltroJsonCliente extends SimpleBeanPropertyFilter {
	private List<String> propiedadesCliente = Arrays.asList("clienteId", "nif", "email", "nombre", "apellido1", "apellido2", "direccion", "ciudad");

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer) throws Exception 
	{
		if (pojo instanceof Cliente)
		{
			if (propiedadesCliente.contains(writer.getName()))
			{
				writer.serializeAsField(pojo, jgen, provider);
			}
		}
	}
}
