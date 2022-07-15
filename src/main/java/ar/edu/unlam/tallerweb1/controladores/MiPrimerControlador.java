package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiPrimerControlador {
	
	@RequestMapping(path= "/miprimerurl", method = RequestMethod.GET)
	public ModelAndView miPrimerVista() {
		
		return new ModelAndView ("vista");
		
	}
	
	@RequestMapping(path= "/segundavista", method = RequestMethod.GET)
	public ModelAndView miSegundaVista() {
		ModelMap modelo =new ModelMap();
		
		modelo.put("mensaje1", "Hoy es Jueves 21" );
		modelo.put("mensaje2", "de Abril del 2022");
		
		return new ModelAndView ("vista2", modelo);
		
	}
	
	@RequestMapping(path= "/tercervista", method = RequestMethod.GET)
	public ModelAndView miTerceraVista(@RequestParam(value="n")String nombre,
			                           @RequestParam(value="a")String apellido) {
		ModelMap modelo =new ModelMap();
		
		modelo.put("nombre", nombre );
		modelo.put("apellido", apellido);
		
		return new ModelAndView ("vista3", modelo);
		
	}
	
	@RequestMapping(path= "/tercervista/categoria/{nombreCategoria}")
	public ModelAndView miTerceraVista(@PathVariable(value="nombreCategoria")String nombre) {
		ModelMap modelo =new ModelMap();
		
		modelo.put("nombre", nombre );
		
		return new ModelAndView ("vista3", modelo);
		
	}
	
	@RequestMapping(path= "/sum")
	public ModelAndView sumando(@RequestParam(value="numero1")Integer numero1,
									   @RequestParam(value="numero2")Integer numero2,
			                           @RequestParam(value="numero3")Integer numero3) {
		ModelMap modelo =new ModelMap();
		
		modelo.put("numero1", numero1 );
		modelo.put("numero2", numero2 );
		modelo.put("numero3", numero3 );
		
		Integer resultado = (numero1 + numero2 + numero3);
		modelo.put("resultado", resultado );
		
		return new ModelAndView ("vistasum", modelo);
		
	}

}
