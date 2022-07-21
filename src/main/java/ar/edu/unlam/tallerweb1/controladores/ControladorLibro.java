package ar.edu.unlam.tallerweb1.controladores;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;

@Controller
public class ControladorLibro {
	
	
	private final ServicioLibro servicioLibro;
	private final ServicioAutor servicioAutor;
	
	 @Autowired
	 public ControladorLibro(ServicioLibro servicioLibro,ServicioAutor servicioAutor) {
		   this.servicioAutor = servicioAutor;
	       this.servicioLibro = servicioLibro;

	  }
	 
	 @RequestMapping(path = "/librogen", method = RequestMethod.GET)
		public ModelAndView verLibroGen() {
			
			
			return new ModelAndView("verLibro");
		}


	@RequestMapping(path = "/libro", method = RequestMethod.GET)
	public ModelAndView verLibro(@RequestParam("libroId") Long libroId,HttpServletRequest request) {
		
		Libro libro = this.servicioLibro.getLibro(libroId);
		
		SimpleDateFormat formatofecha = new SimpleDateFormat ("dd-MM-yyyy");
		
		String fecha = formatofecha.format(libro.getPublicado());
		
	/*	Long autorid = libro.getAutor().getId();
		
		Autor autor = this.servicioAutor.getAutor(libroId); */
		
		ModelMap model = new ModelMap();
		
		model.put("publicado",fecha);
		model.put("libro", libro);
		return new ModelAndView("verLibro",model);
	}
	
	
}
