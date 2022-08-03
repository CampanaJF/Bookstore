package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.excepciones.LibroNoExisteEnBibliotecaException;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorBiblioteca {
	
	private final ServicioSession servicioSession;
	private final ServicioBiblioteca servicioBiblioteca;
	
	
	 @Autowired
	 public ControladorBiblioteca(ServicioSession servicioSession,ServicioBiblioteca servicioBiblioteca) {
		   this.servicioSession = servicioSession;
	       this.servicioBiblioteca = servicioBiblioteca;

	  }
	 
	 @RequestMapping(path = "/biblioteca", method = RequestMethod.GET)
		public ModelAndView verMiBiblioteca(HttpServletRequest request) {
		 ModelMap model = new ModelMap();
			
		 Long userId = this.servicioSession.getUserId(request);
		 

		 model.put("usuario", userId);
		
			
	     return new ModelAndView("biblioteca",model);
		}


	@RequestMapping(path = "/biblioteca/agregar", method = RequestMethod.GET)
	public ModelAndView agregarABiblioteca(@RequestParam("libroId") Long libroId,
										   HttpServletRequest request) {
		
		Long userId = this.servicioSession.getUserId(request);
		
		if(userId==null)
			return new ModelAndView("redirect:/login");
		
		this.servicioBiblioteca.agregarABiblioteca(libroId, userId);
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(path = "/biblioteca/puntuar", method = RequestMethod.GET)
	public ModelAndView puntuarLibro(@RequestParam("libroId") Long libroId,
									 @RequestParam("puntuacion") Double p,
									 HttpServletRequest request) {
		
		Long userId = this.servicioSession.getUserId(request);
		ModelMap model = new ModelMap();
		
		try{
			this.servicioBiblioteca.cambiarPuntuacion(libroId, userId, p);	
			
		}catch(LibroNoExisteEnBibliotecaException x) {
			model.put("error", "Este libro no esta en tu biblioteca");
			return new ModelAndView("biblioteca",model);
			}
			
		return new ModelAndView("redirect:/");
	}
	
	
	
	@RequestMapping(path = "/biblioteca/cambiarEstado", method = RequestMethod.GET)
	public ModelAndView cambiarEstadoLibro(@RequestParam("libroId") Long libroId,
										   @RequestParam("estado") Estado estado,
										   HttpServletRequest request) {
		
		Long userId = this.servicioSession.getUserId(request);
		ModelMap model = new ModelMap();
		
		try{
			this.servicioBiblioteca.cambiarEstado(libroId, userId, estado);	
			
		}catch(LibroNoExisteEnBibliotecaException x) {
			model.put("error", "Este libro no esta en tu biblioteca");
			return new ModelAndView("biblioteca",model);
			}
			
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(path = "/biblioteca/remover", method = RequestMethod.POST)
	public ModelAndView quitarDeBiblioteca(@RequestParam("libroId")Long libroId, HttpServletRequest request) {

		Long userId = this.servicioSession.getUserId(request);
		ModelMap model = new ModelMap();
		
		try{
			this.servicioBiblioteca.quitarDeBiblioteca(libroId, userId);	
			
		}catch(LibroNoExisteEnBibliotecaException x) {
			model.put("error", "Este libro no esta en tu biblioteca");
			return new ModelAndView("biblioteca",model);
			}
			
		return new ModelAndView("redirect:/");
	}
	

	@RequestMapping(path = "/biblioteca/puntuartest", method = RequestMethod.POST)
	public ModelAndView puntuarLibroExceptionTest(@RequestParam("libroId") Long libroId,
												 @RequestParam("Puntuacion") Double p,
												 HttpServletRequest request) {
		
		ModelMap model = new ModelMap();
		
		try{
			this.servicioBiblioteca.cambiarPuntuacion(libroId, 1L, p);	
			
		}catch(LibroNoExisteEnBibliotecaException x) {
			model.put("error", "Este libro no esta en tu biblioteca");
			return new ModelAndView("biblioteca",model);
			}
			
		return new ModelAndView("redirect:/");
	}

	
	
	
	
	
}
