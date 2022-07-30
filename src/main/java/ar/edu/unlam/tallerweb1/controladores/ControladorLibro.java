package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorLibro {
	
	
	private final ServicioLibro servicioLibro;
	private final ServicioBiblioteca servicioBiblioteca;
	private final ServicioSession servicioSession;
	
	 @Autowired
	 public ControladorLibro(ServicioLibro servicioLibro,ServicioBiblioteca servicioBiblioteca,ServicioSession servicioSession) {
		   this.servicioBiblioteca = servicioBiblioteca;
	       this.servicioLibro = servicioLibro;
	       this.servicioSession = servicioSession;

	  }

	@RequestMapping(path = "/libro", method = RequestMethod.GET)
	public ModelAndView verLibro(@RequestParam("libroId") Long libroId,HttpServletRequest request) {
		
		Libro libro = this.servicioLibro.getLibro(libroId);

		Long userId = this.servicioSession.getUserId(request);
		
		List<Genero> generos= this.servicioLibro.getGenerosLibro(libroId); 
		
		List<Resenia> resenias= this.servicioLibro.getReseniasLibro(libroId); 
		
		ModelMap model = new ModelMap();
		
		
		if (userId==null) {
			model.put("libro", libro);
			model.put("generos", generos);
			model.put("resenias", resenias);
			return new ModelAndView("libro",model);
        }
		
		Biblioteca biblioteca = this.servicioBiblioteca.getBiblioteca(libroId, userId);
			
		
		model.put("generos", generos);
		model.put("resenias", resenias);
		model.put("biblioteca", biblioteca);
		model.put("usuario", userId);
		model.put("libro", libro);
		return new ModelAndView("libro",model);
	}
	
	
}
