package com.rafavillamizar.gestionventas.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

public class JsonUtils {
	
	public static void putJsonDataInResponse(SimpleFilterProvider filters, Object data, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        if (filters != null)
        {
        	mapper.setFilters(filters);
        }
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        
//        response.setContentType("ISO-8859-1");
        PrintWriter ou = response.getWriter();
        ou.print(result);
        ou.flush();
    }
	
	public static String getJsonDate(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		return formatter.format(date);
	}
	
	public static Date getDateFromJson(String date) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		return formatter.parse(date);
	}

}
