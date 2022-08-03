package ar.edu.unlam.tallerweb1.controladores;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorLibroTest {
	

	private final ServicioBiblioteca servicioBiblioteca = mock(ServicioBiblioteca.class);
	private final ServicioLibro servicioLibro = mock(ServicioLibro.class);
	private final ServicioSession servicioSession = mock(ServicioSession.class);
	
	
	private final ControladorLibro controladorLibro = new ControladorLibro(servicioLibro,servicioBiblioteca,servicioSession);
	
	private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	private final HttpSession mockSession = mock(HttpSession.class);

	
	private ModelAndView mav = new ModelAndView();
	
	
	
	
	@Test
	public void queSePuedaVerElLibroYSusDatos(){
		
		Libro A = givenLibro("L");
		Long idLibro = 1L;
		
		whenSeIngresaAEseLibro(idLibro,A);
		
		thenLaVistaEsCorrecta();

	}
	

	 private void whenSeIngresaAEseLibro(Long idLibro,Libro A) {
		 mocksSessionRequests();
		 when(servicioLibro.getLibro(idLibro)).thenReturn(A);

	     mav = this.controladorLibro.verLibro(1l,mockRequest);
			
	}
	 
	private void thenLaVistaEsCorrecta() {
		assertThat( mav.getViewName() ).isEqualTo( "libro");
			
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
    	libro.setId(1L);
    	return libro;
    }
	
	public Usuario givenUsuario(String email) {
    	Usuario usuario = new Usuario ();
    	usuario.setEmail(email);
    	return usuario;
    }
	
	 private void mocksSessionRequests() {
	        when(mockRequest.getSession()).thenReturn(mockSession);
	       /* when(mockRequest.getSession().getAttribute("ROL")).thenReturn("ADM");
	        when(mockRequest.getSession().getAttribute("ID")).thenReturn(1L);
	        when(mockRequest.getSession().getAttribute("USUARIO")).thenReturn(new Usuario()); */
	    }
	
	 
	
	



}
