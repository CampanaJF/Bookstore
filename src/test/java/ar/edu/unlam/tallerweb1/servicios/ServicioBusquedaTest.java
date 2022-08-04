package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;


public class ServicioBusquedaTest {
	
	private RepositorioAutor repositorioAutor = mock(RepositorioAutor.class);
	private RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
	private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);

	private ServicioBusquedaImpl servicioBusqueda= new ServicioBusquedaImpl(repositorioAutor,repositorioLibro,repositorioUsuario);
	
	@Test
    public void queSePuedanObtenerLasReseniasDeUnLibro() {
    	
		Autor E= givenAutor("Dio","Brando");
    	Autor C= givenAutor("Dio","Dio");
    	Autor D= givenAutor("Orange","Dio");
    	
    	List <Autor> nombre = new ArrayList<>();
    	nombre.add(E);
    	nombre.add(C);
    	
    	List <Autor> apellido = new ArrayList<>();
    	apellido.add(D);
    	apellido.add(C);

    	when(repositorioAutor.getAutoresNombre("Dio")).thenReturn(nombre);
    	when(repositorioAutor.getAutoresApellido("Dio")).thenReturn(apellido);
	
    	Set <Autor> obtenidas;
    	obtenidas = whenObtengoAutores("Dio");
    	
    	thenObtengoAutores(obtenidas);
    	
    }
	
	private void thenObtengoAutores(Set<Autor> obtenidas) {
		verify(repositorioAutor,times(1)).getAutoresNombre("Dio");
		verify(repositorioAutor,times(1)).getAutoresApellido("Dio");
		assertThat(obtenidas.size()).isEqualTo(3);
		
	}

	private Set<Autor> whenObtengoAutores(String string) {
		return servicioBusqueda.getAutoresBuscados(string);
	}

	
	private Autor givenAutor(String nombre, String apellido) {
		Autor autor = new Autor();
		autor.setNombre(nombre);
		autor.setApellido(apellido);
		return autor;
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
  
    public Libro givenLibro(String nombre) {
    	Libro libro = new Libro ();
    	libro.setTitulo(nombre);
    	return libro;
    }
	

}
