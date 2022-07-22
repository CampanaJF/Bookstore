package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;


import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;



@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorBibliotecaTest {

	private final ServicioBiblioteca servicioBiblioteca = mock(ServicioBiblioteca.class);
	
	
	private final ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(servicioBiblioteca);
	
	private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	private final HttpSession mockSession = mock(HttpSession.class);

	
	private ModelAndView mav = new ModelAndView();
	
	@Test
	public void queSePuedaCrearUnaBiblioteca(){
		
		Libro A = givenLibro("L");
    	Usuario Q = givenUsuario("Q");
    	Biblioteca B = givenBiblioteca(A,Q);
	
		
	
	}
	
	public Biblioteca givenBiblioteca(Libro a, Usuario q) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setEstado(Estado.Nuevo);
		biblioteca.setLibro(a);
		biblioteca.setUsuario(q);
		return biblioteca;
	}
	
	public Libro givenLibro(String nombre) {
    	Libro libro = new Libro ();
    	libro.setTitulo(nombre);
    	return libro;
    }
	
	public Usuario givenUsuario(String email) {
    	Usuario usuario = new Usuario ();
    	usuario.setEmail(email);
    	return usuario;
    }
	
	


}
