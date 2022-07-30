package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.excepciones.LibroNoExisteEnBibliotecaException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorBibliotecaTest {

	private final ServicioBiblioteca servicioBiblioteca = mock(ServicioBiblioteca.class);
	private final ServicioSession servicioSession = mock(ServicioSession.class);
	
	private final ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(servicioSession,servicioBiblioteca);
	
	private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	private final HttpSession mockSession = mock(HttpSession.class);

	
	private ModelAndView mav = new ModelAndView();
	
	
	@Test
	public void queSePuedaQuitarUnLibroDeUnaBiblioteca(){
		
		Libro A = givenLibro("L");

    	whenSeQuita(A.getId());
    	
    	thenSeQuito();
	
	}
	
	private void thenSeQuito() {
		assertThat(mav.getViewName()).isEqualTo("redirect:/");
		
	}

	private void whenSeQuita(Long id) {
		mocksSessionRequests();
		
		mav = this.controladorBiblioteca.quitarDeBiblioteca(id, mockRequest);
		
	}

	@Test
	public void queSePuedaCambiarElEstadoDeUnLibro(){
		
		Libro A = givenLibro("L");
    	Estado estado = Estado.Dejado;
	
    	whenSeCambiaElEstado(A.getId(),estado);
    	
    	thenSeCambioElEstado();
	
	}
	
	private void thenSeCambioElEstado() {
		 assertThat(mav.getViewName()).isEqualTo("redirect:/");
		
	}

	private void whenSeCambiaElEstado(Long id, Estado estado) {
		mocksSessionRequests();
		
		mav = this.controladorBiblioteca.cambiarEstadoLibro(id,estado, mockRequest);
		
	}

	@Test
	public void queSeObtengaLibroNoEnBibliotecaException(){
		
		Libro A = givenLibro("L");
    	Double P = 9.99;
    	
    	 doThrow(LibroNoExisteEnBibliotecaException.class)
         .when(servicioBiblioteca)
                 .cambiarPuntuacion(A.getId(),1L,P);
    	
    	whenSePuntuaTest(A.getId(),P);
    	
    	thenSeObtieneException();
	
	}
	
			private void thenSeObtieneException() {
				assertThat(mav.getModel().get("error")).isEqualTo("Este libro no esta en tu biblioteca");
				
			}
			
			private void whenSePuntuaTest(Long Lid,Double P) {
				mocksSessionRequests();
				
				mav = this.controladorBiblioteca.puntuarLibroExceptionTest(Lid,P, mockRequest);
				
			}

	
	@Test
	public void queSePuedaPuntuarUnLibro(){
		
		Libro A = givenLibro("L");
    	Double P = 9.99;
    	
    	whenSePuntua(A.getId(),P);
    	
    	thenSePuntuo();
	
	}
			
			private void thenSePuntuo() {
				 assertThat(mav.getViewName()).isEqualTo("redirect:/");
				
			}
		
			private void whenSePuntua(Long Lid,Double P) {
				mocksSessionRequests();
				
				mav = this.controladorBiblioteca.puntuarLibro(Lid,P, mockRequest);
				
			}

	@Test
	public void queSePuedaAgregarUnLibroALaBiblioteca(){
		Libro A = givenLibro("L");

    	whenSeAgregaABiblioteca(A.getId());
	
		thenSeAgrego();
	
	}
	
			 private void thenSeAgrego() {
			    assertThat(mav.getViewName()).isEqualTo("redirect:/");
			 }
			
			private void whenSeAgregaABiblioteca(Long id) {
				mocksSessionRequests();
				
				mav = this.controladorBiblioteca.agregarABiblioteca(id, mockRequest);
				
			}
	

			
	public Libro givenLibro(String nombre) {
    	Libro libro = new Libro ();
    	libro.setId(new Random().nextLong());
    	libro.setTitulo(nombre);
    	return libro;
    }
	
	public Biblioteca givenBiblioteca(Libro a, Usuario q) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setId(new Random().nextLong());
		biblioteca.setEstado(Estado.Nuevo);
		biblioteca.setLibro(a);
		biblioteca.setUsuario(q);
		return biblioteca;
	}
	
	public Usuario givenUsuario(String email) {
    	Usuario usuario = new Usuario ();
    	usuario.setId(new Random().nextLong());
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
