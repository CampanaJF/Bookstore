package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;

@Controller
public class ControladorHome {
	
	
	private final ServicioLibro servicioLibro;
	
	@Autowired
	 public ControladorHome(ServicioLibro servicioLibro) {

	       this.servicioLibro = servicioLibro;

	  }
	
	
		@RequestMapping(path = "/libreria", method = RequestMethod.GET)
		public ModelAndView goLibreria() {
			return new ModelAndView("libreria");
		}
		
		@RequestMapping(path = "/perfil", method = RequestMethod.GET)
		public ModelAndView verPerfil() {
			return new ModelAndView("perfil");
		}
		
		@RequestMapping(path = "/home", method = RequestMethod.GET)
		public ModelAndView goHome() {
			
			ModelMap model = new ModelMap();
			
			List<Libro> libros = servicioLibro.getLibros();
			
			model.put("libros", libros);
			
			return new ModelAndView("index",model);
		}

		
		@RequestMapping(path = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			return new ModelAndView("redirect:/home");
		}

}
