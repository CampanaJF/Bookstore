package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import static org.assertj.core.api.Assertions.*;

public class ServicioBibliotecaTest {
	
	private RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
	private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
	private RepositorioBiblioteca repositorioBiblioteca = mock(RepositorioBiblioteca.class);
	private ServicioBibliotecaImpl servicioBiblioteca = new ServicioBibliotecaImpl(repositorioLibro,
																				   repositorioUsuario,
																				   repositorioBiblioteca);
	
	@Test
    public void queSePuedaAgregarUnLibroALaBibliotecaDeUnUsuario() {
    	
    	Libro A = givenLibro("L");
    	Usuario Q = givenUsuario("Q");
    	//Usuario B = givenUsuario("B");
    	Boolean Z = true;
    	Biblioteca B = givenBiblioteca(A,Q);
    	
    	when(repositorioUsuario.getUsuario(Q.getId())).thenReturn(Q);
    	when(repositorioLibro.getLibro(A.getId())).thenReturn(A);
    	when(repositorioBiblioteca.guardar(B)).thenReturn(Z);
    	
    	Boolean res = whenAgregoABiblioteca(A,Q);
    	Boolean res2 = whenGuardoBiblioteca(B);
    	
    	thenSeGuardo(res,res2);
    	
    }
	
	private void thenSeGuardo(Boolean res,Boolean res2) {
		assertThat(res).isFalse();
		assertThat(res2).isTrue();
		
	}

	public Boolean whenAgregoABiblioteca(Libro a,Usuario q) {
		
		return servicioBiblioteca.agregarABiblioteca(a.getId(),q.getId());
	}
	
	public Boolean whenGuardoBiblioteca(Biblioteca B) {
		
		return servicioBiblioteca.guardarBiblioteca(B);
	}
	
	public Libro givenLibro(String nombre) {
    	Libro libro = new Libro ();
    	libro.setTitulo(nombre);
    	return libro;
    }
	
	public Biblioteca givenBiblioteca(Libro a, Usuario q) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setEstado(Estado.Nuevo);
		biblioteca.setLibro(a);
		biblioteca.setUsuario(q);
		return biblioteca;
	}
	
	public Usuario givenUsuario(String email) {
    	Usuario usuario = new Usuario ();
    	usuario.setEmail(email);
    	return usuario;
    }
	
	

}
