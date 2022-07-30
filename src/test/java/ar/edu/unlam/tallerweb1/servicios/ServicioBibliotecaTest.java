package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;


public class ServicioBibliotecaTest {
	
	private RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
	private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
	private RepositorioBiblioteca repositorioBiblioteca = mock(RepositorioBiblioteca.class);
	private ServicioBibliotecaImpl servicioBiblioteca = new ServicioBibliotecaImpl(repositorioLibro,
																				   repositorioUsuario,
																				   repositorioBiblioteca);
	
	
	@Test
    public void queSeCalculeLaPuntuacionPromedioDeUnLibro() {
    	
    	Libro L1 = givenLibro("L1");
    	Usuario U1 = givenUsuario("U1");
    	Usuario U2 = givenUsuario("U2");
    	Usuario U3 = givenUsuario("U3");
    	Usuario U4 = givenUsuario("U4");
    	Biblioteca B1 = givenBiblioteca(L1,U1);
    	Biblioteca B2 = givenBiblioteca(L1,U2);
    	Biblioteca B3 = givenBiblioteca(L1,U3);
    	Biblioteca B4 = givenBiblioteca(L1,U4);
    	B1.setPuntuacion(3.0);
    	B2.setPuntuacion(7.0);
    	B3.setPuntuacion(9.0);
    	B4.setPuntuacion(10.0);
    	
    	List <Biblioteca> B = new ArrayList();
    	B.add(B1);
    	B.add(B2);
    	B.add(B3);
    	B.add(B4);

    	when(repositorioBiblioteca.getBibliotecasDelLibro(L1.getId())).thenReturn(B);
	
    	Double obtenido;
    	obtenido = whenCalculoPuntuacion(L1.getId());
    	
    	thenObtengoPuntuacionDelLibro(L1.getId(),obtenido);
    	
    }
	
	private void thenObtengoPuntuacionDelLibro(Long id,Double p) {
		verify(repositorioLibro,times(1)).setPuntuacionLibro(id,p);
		verify(repositorioBiblioteca,times(1)).getBibliotecasDelLibro(id);
		assertThat(p).isEqualTo(7.25);
	
	}

	private Double whenCalculoPuntuacion(Long id) {
		 return servicioBiblioteca.calcularPuntuacionLibro(id);
		
	}
	
	@Test(expected = LibroNoExisteEnBibliotecaException.class)
    public void queNoSePuedaQuitarUnLibroQueNoEstaBiblioteca() {
    	
    	Libro L0 = givenLibro("L");
    	Usuario U0 = givenUsuario("Q");

    	when(repositorioBiblioteca.getBiblioteca(L0.getId(),U0.getId())).thenReturn(null);
    		
    	whenBorroElLibro(L0.getId(),U0.getId());
    	
    	thenNoSeBorro(L0.getId(),U0.getId());
    	
    }
	
	private void thenNoSeBorro(Long id, Long id2) {
		verify(repositorioBiblioteca,times(0)).borrar(id,id2);
		
	}

	@Test
    public void queSePuedaQuitarUnLibroDeLaBiblioteca() {
    	
    	Libro L0 = givenLibro("L");
    	Usuario U0 = givenUsuario("Q");
    	Biblioteca B0 = givenBiblioteca(L0,U0);

    	when(repositorioBiblioteca.getBiblioteca(L0.getId(),U0.getId())).thenReturn(B0);
    		
    	whenBorroElLibro(L0.getId(),U0.getId());
    	
    	thenSeBorro(L0.getId(),U0.getId());
    	
    }
	
	private void thenSeBorro(Long id, Long id2) {
		verify(repositorioBiblioteca,times(1)).borrar(id,id2);
		
	}

	private void whenBorroElLibro(Long id, Long id2) {
		servicioBiblioteca.quitarDeBiblioteca(id,id2);
		
	}

	@Test
    public void queSePuedaCambiarElEstadoDeUnLibro() {
    	
    	Libro L0 = givenLibro("L");
    	Usuario U0 = givenUsuario("Q");
    	Biblioteca B0 = givenBiblioteca(L0,U0);
    	Estado E = Estado.Terminado;

    	when(repositorioBiblioteca.getBiblioteca(L0.getId(),U0.getId())).thenReturn(B0);
    		
    	whenCambioElEstado(L0.getId(),U0.getId(),E);
    	
    	thenSeCambioElEstado(L0.getId(),U0.getId(),E);
    	
    }
	
	private void thenSeCambioElEstado(Long id, Long id2, Estado e) {
		verify(repositorioBiblioteca,times(1)).cambiarEstado(id,id2,e);
		
	}

	private void whenCambioElEstado(Long id, Long id2, Estado e) {
		servicioBiblioteca.cambiarEstado(id,id2,e);
		
	}

	@Test
    public void queSePuedaCambiarLaPuntuacionDeUnLibro() {
    	
    	Libro L0 = givenLibro("L");
    	Usuario U0 = givenUsuario("Q");
    	Biblioteca B0 = givenBiblioteca(L0,U0);
    	Double P = 9.99;
    	List <Biblioteca> B = new ArrayList();
    	B.add(B0);
    	
    	

    	when(repositorioBiblioteca.getBiblioteca(L0.getId(),U0.getId())).thenReturn(B0);
    	when(repositorioBiblioteca.getBibliotecasDelLibro(L0.getId())).thenReturn(B);	
    	whenCambioLaPuntuacion(L0.getId(),U0.getId(),P);
    	
    	thenSeCambioLaPuntuacion(L0.getId(),U0.getId(),P);
    	
    }
	
	private void thenSeCambioLaPuntuacion(Long L0,Long U0,Double P) {
		verify(repositorioBiblioteca,times(1)).cambiarPuntuacion(L0,U0,P);
		
	}

	private void whenCambioLaPuntuacion(Long id, Long id2, Double p) {
		servicioBiblioteca.cambiarPuntuacion(id,id2,p);
		
	}

	@Test
    public void queSePuedaAgregarUnLibroALaBibliotecaDeUnUsuario() {
    	
    	Libro A = givenLibro("L");
    	Usuario Q = givenUsuario("Q");
    	Boolean Z = false;
    	Biblioteca B = givenBiblioteca(A,Q);
    	
    	when(repositorioUsuario.getUsuario(Q.getId())).thenReturn(Q);
    	when(repositorioLibro.getLibro(A.getId())).thenReturn(A);
    	when(repositorioBiblioteca.guardar(B)).thenReturn(Z);
    	when(repositorioBiblioteca.getBiblioteca(A.getId(),Q.getId())).thenReturn(null);
    	
    	whenAgregoABiblioteca(A,Q);
    	whenGuardoBiblioteca(B);
    	
    	thenSeGuardo(B);
    	
    }
	
	private void thenSeGuardo(Biblioteca B) {

		verify(repositorioBiblioteca,times(1)).guardar(B);
		
	}

	public void whenAgregoABiblioteca(Libro a,Usuario q) {
		
		 servicioBiblioteca.agregarABiblioteca(a.getId(),q.getId());
	}
	
	public void whenGuardoBiblioteca(Biblioteca B) {
		
		servicioBiblioteca.guardarBiblioteca(B);
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
	
	

}
