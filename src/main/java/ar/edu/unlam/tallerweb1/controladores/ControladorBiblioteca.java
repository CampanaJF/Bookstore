package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;

@Controller
public class ControladorBiblioteca {
	
	private final ServicioBiblioteca servicioBiblioteca;
	
	 @Autowired
	 public ControladorBiblioteca(ServicioBiblioteca servicioBiblioteca) {

	       this.servicioBiblioteca = servicioBiblioteca;

	  }
	 
	 @RequestMapping(path = "/biblioteca", method = RequestMethod.GET)
		public ModelAndView verMiBiblioteca() {
			return new ModelAndView("biblioteca");
		}


	@RequestMapping(path = "/biblioteca/agregar", method = RequestMethod.POST)
	public ModelAndView agregarABibliotecaB(@RequestParam("figuritaId") Long libroId,
											@RequestParam("userId") Long userId,
											HttpServletRequest request) {
		
		this.servicioBiblioteca.agregarABiblioteca(libroId, userId);
		
		return new ModelAndView("redirect:/biblioteca");
	}
	
	
	
}
