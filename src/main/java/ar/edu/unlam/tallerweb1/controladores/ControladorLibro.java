package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;

@Controller
public class ControladorLibro {
	
	
	private final ServicioLibro servicioLibro;
	
	 @Autowired
	 public ControladorLibro(ServicioLibro servicioLibro) {

	       this.servicioLibro = servicioLibro;

	  }


	@RequestMapping(path = "/verLibro", method = RequestMethod.GET)
	public ModelAndView verLibro(@RequestParam("libroId") Long libroId,HttpServletRequest request) {
		
		Libro obtenido = this.servicioLibro.getLibro(libroId);
		
		ModelMap model = new ModelMap();
		
		model.put("libro", obtenido);
		return new ModelAndView("libro",model);
	}
	
	
}
