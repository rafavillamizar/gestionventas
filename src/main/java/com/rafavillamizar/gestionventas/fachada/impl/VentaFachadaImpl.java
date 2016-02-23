package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.DetalleVenta;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.entidad.Venta;
import com.rafavillamizar.gestionventas.json.FiltroJsonCiudad;
import com.rafavillamizar.gestionventas.json.FiltroJsonCliente;
import com.rafavillamizar.gestionventas.json.FiltroJsonDetalleVenta;
import com.rafavillamizar.gestionventas.json.FiltroJsonPagina;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.json.FiltroJsonVenta;
import com.rafavillamizar.gestionventas.servicio.DetalleVentaServicio;
import com.rafavillamizar.gestionventas.servicio.VentaServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class VentaFachadaImpl {

	@Resource
    private VentaServicio ventaServicio;

	@Resource
	private DetalleVentaServicio detalleVentaServicio;

	@RequestMapping(value = "/ventas", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(@RequestParam(value = "numeroPagina", required = false, defaultValue = "0") Integer numeroPagina, 
			HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		Pagina<Venta> paginaVenta = null;
		
		if(numeroPagina != null && numeroPagina.compareTo(1) >= 0) {
			paginaVenta = ventaServicio.obtenerVentasPaginado(numeroPagina);
		} else
			paginaVenta = ventaServicio.obtenerVentas();
		
		if(paginaVenta != null && paginaVenta.getResultado() != null && paginaVenta.getResultado().size() > 0) {
			for (Venta venta : paginaVenta.getResultado()) {
				venta.setDetalles(detalleVentaServicio.obtenerDetallesVenta(venta.getVentaId()));
			}
		}

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonVenta(),
				paginaVenta, response);
	}
	
	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
    public @ResponseBody
    void guardarVenta(@RequestBody LinkedHashMap<String, Object> data, HttpServletResponse response) 
    				 throws JsonGenerationException, JsonMappingException, IOException 
    {
		Venta venta = new Venta();
		venta.setVentaId(((Integer)data.get("ventaId") != null) ? (Integer)data.get("ventaId") : null);
		
		Cliente cliente = new Cliente();
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> clienteObj = (LinkedHashMap<String, Object>)data.get("cliente");
		cliente.setClienteId((Integer)clienteObj.get("clienteId"));
		
		venta.setCliente(cliente);
		
		try {
			venta.setFechaVenta(JsonUtils.getDateFromJson((String)data.get("fechaVenta")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
		ventaServicio.guardarVenta(venta);
		
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> detallesObj = (List<LinkedHashMap<String,Object>>)data.get("detalles");
		if(detallesObj.size() > 0) {
			List<DetalleVenta> nuevosDetallesVenta = new ArrayList<DetalleVenta>();
			for (LinkedHashMap<String, Object> elemento : detallesObj) {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String, Object> productoObj = (LinkedHashMap<String, Object>)elemento.get("producto");
				Producto producto = new Producto();
				producto.setProductoId((Integer)productoObj.get("productoId"));
				
				DetalleVenta detalleVenta = new DetalleVenta();
				detalleVenta.setVentaId(venta.getVentaId());
				detalleVenta.setDetalleVentaId(((Integer)elemento.get("detalleVentaId") != null) ? (Integer)elemento.get("detalleVentaId") : null);
				detalleVenta.setProducto(producto);
				detalleVenta.setCantidad((Integer)elemento.get("cantidad"));
				nuevosDetallesVenta.add(detalleVenta);
			}
	        Vector<DetalleVenta> detallesVentaGuardados = new Vector<DetalleVenta>();
	        Vector<DetalleVenta> detallesVentaParaGuardar = new Vector<DetalleVenta>();
	        Vector<DetalleVenta> detallesVentaParaBorrar = new Vector<DetalleVenta>();
	        List<DetalleVenta> detallesVenta = detalleVentaServicio.obtenerDetallesVenta(venta.getVentaId());

	        boolean existeDetallesVenta = (detallesVenta != null && !detallesVenta.isEmpty());

	        if (nuevosDetallesVenta != null && !nuevosDetallesVenta.isEmpty()) {
	            for (DetalleVenta nuevoDetalleVenta : nuevosDetallesVenta) {
	                if(existeDetallesVenta &&
	                        detallesVenta.contains(nuevoDetalleVenta))
	                    detallesVentaGuardados.add(nuevoDetalleVenta);
	                else
	                    detallesVentaParaGuardar.add(nuevoDetalleVenta);
	            }
	        }

	        if(existeDetallesVenta) {
	            for (DetalleVenta detalleVenta : detallesVenta) {
	                if(!detallesVentaGuardados.contains(detalleVenta))
	                    detallesVentaParaBorrar.add(detalleVenta);
	            }
	        }

	        if(detallesVentaParaGuardar != null && !detallesVentaParaGuardar.isEmpty()) {
	            for (DetalleVenta detalleVenta : detallesVentaParaGuardar) {
	                detalleVentaServicio.guardarDetalleVenta(detalleVenta);
	            }
	        }

	        if(detallesVentaParaBorrar != null && !detallesVentaParaBorrar.isEmpty()) {
	            for (DetalleVenta detalleVenta : detallesVentaParaBorrar) {
	            	detalleVentaServicio.eliminarDetalleVenta(detalleVenta.getDetalleVentaId());
	            }
	        }
		}
		
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/ventas/{ventaId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarVenta(HttpServletResponse response, @PathVariable Integer ventaId)
			throws JsonGenerationException, JsonMappingException, IOException {
		ventaServicio.eliminarVenta(ventaId);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonVenta()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonPagina", new FiltroJsonPagina());
		filters.addFilter("filtroJsonVenta", new FiltroJsonVenta());
		filters.addFilter("filtroJsonCliente", new FiltroJsonCliente());
		filters.addFilter("filtroJsonCiudad", new FiltroJsonCiudad());
		filters.addFilter("filtroJsonDetalleVenta", new FiltroJsonDetalleVenta());
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
