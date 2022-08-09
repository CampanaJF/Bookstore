package ar.edu.unlam.tallerweb1.controladores;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.excepciones.EmailEnUsoException;
import ar.edu.unlam.tallerweb1.excepciones.LibroNoExisteEnBibliotecaException;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorUsuarioTest {
	

	private final ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
	private final ServicioSession servicioSession = mock(ServicioSession.class);
	
	
	private final ControladorUsuario controladorUsuario = new ControladorUsuario(servicioUsuario,servicioSession);
	
	private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	private final HttpSession mockSession = mock(HttpSession.class);

	
	private ModelAndView mav = new ModelAndView();
	
	
//	@Test
//	public void queNoSePuedaRegistrarUnUsuarioConEmailRepetido(){
//		
//		Usuario usuario = givenUsuario("dio","admin","admin","dioo");
//		
//		
//		doThrow(EmailEnUsoException.class)
//        .when(servicioUsuario.validarRegistro(usuario));
//		
//		whenSeRegistraEmailException(usuario);
//		
//		thenSeRegistraEmail();
//
//	}
//	
//	private void thenSeRegistraEmail() {
//		assertThat(mav.getViewName()).isEqualTo("registro");
//		assertThat(mav.getModel().get("mensaje")).isEqualTo("El Email ya esta en uso");
//		
//	}
//
//	private void whenSeRegistraEmailException(Usuario usuario) {
//	
//		 mav = this.controladorUsuario.procesarRegistro(usuario);
//		
//	}

	@Test
	public void queSePuedaRegistrarUnUsuario(){
		
		Usuario usuario = givenUsuario("dio","admin","admin","dioo");
		
		 
		
		whenSeRegistra(usuario);
		
		thenSeRegistra();

	}
	

		 private void thenSeRegistra() {
			 assertThat(mav.getViewName()).isEqualTo("registro");
			 assertThat(mav.getModel().get("mensaje")).isEqualTo("exito");
			 
			
		}
	
	
		private void whenSeRegistra(Usuario usuario) {
			 mocksSessionRequests();
	
		     mav = this.controladorUsuario.procesarRegistro(usuario);	
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
	
	public Usuario givenUsuario(String email,String pass,String passRe,String name) {
    	Usuario usuario = new Usuario ();
    	usuario.setEmail(email);
    	usuario.setPassword(pass);
    	usuario.setPasswordRe(passRe);
    	usuario.setNombre(name);
    	return usuario;
    }
	
	 private void mocksSessionRequests() {
	        when(mockRequest.getSession()).thenReturn(mockSession);
	       /* when(mockRequest.getSession().getAttribute("ROL")).thenReturn("ADM");
	        when(mockRequest.getSession().getAttribute("ID")).thenReturn(1L);
	        when(mockRequest.getSession().getAttribute("USUARIO")).thenReturn(new Usuario()); */
	    }
	
	 
	
	



}