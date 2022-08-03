package ar.edu.unlam.tallerweb1.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class RepositorioBusquedaTest extends SpringTest{
	
	@Autowired
    private RepositorioAutor repositorioAutor;
	
	@Autowired
    private RepositorioLibro repositorioLibro;
	
	@Autowired
    private RepositorioUsuario repositorioUsuario;
	
	@Test
	@Transactional
	@Rollback
	public void queSePuedanBuscarAutoresPorSuApellido() {
	    	
	    	Autor L1= givenAutor("Dio","Brando");
	    	Autor L2= givenAutor("Dio","Jo");
	    	Autor L3= givenAutor("Orange","Jo");

	    	session().save(L1);
	    	session().save(L2);
	    	session().save(L3);

	    	List<Autor> b= whenSeBuscanAutoresApellido("Jo");

	    	thenSeTraenAutoresApellido(b);
	    }
	
	
	private void thenSeTraenAutoresApellido(List<Autor> b) {
		 assertThat(b.get(0).getNombre()).isEqualTo("Dio");	
		 assertThat(b.size()).isEqualTo(2);		
		
	}


	private List<Autor> whenSeBuscanAutoresApellido(String string) {
		return repositorioAutor.getAutoresApellido(string);
	}


	@Test
	@Transactional
	@Rollback
	public void queSePuedanBuscarAutoresPorSuNombre() {
	    	
	    	Autor L1= givenAutor("Dio","Brando");
	    	Autor L2= givenAutor("Dio","Jo");
	    	Autor L3= givenAutor("Orange","Jo");

	    	session().save(L1);
	    	session().save(L2);
	    	session().save(L3);

	    	List<Autor> b= whenSeBuscanAutores("Dio");

	    	thenSeTraenAutores(b);
	    }


	private void thenSeTraenAutores(List<Autor> b) {
		 assertThat(b.get(0).getNombre()).isEqualTo("Dio");	
		 assertThat(b.size()).isEqualTo(2);		

	}


	private List<Autor> whenSeBuscanAutores(String string) {
		return repositorioAutor.getAutoresNombre(string);
	}


	@Test
	@Transactional
	@Rollback
	public void queSePuedanBuscarLibrosPorSuTitulo() {
	    	
	    	Libro L1= givenLibro("Libro1");
	    	Libro L2= givenLibro("Libro2");
	    	Libro L3= givenLibro("bro2");

	    	session().save(L1);
	    	session().save(L2);
	    	session().save(L3);

	    	List<Libro> b= whenSeBuscanLibros("Libro");

	    	thenSeTraenLibros(b);
	    }
	 
	 private void thenSeTraenLibros(List<Libro> b) {
		 assertThat(b.get(0).getTitulo()).isEqualTo("Libro1");	
		 assertThat(b.size()).isEqualTo(2);
	}

	private List<Libro> whenSeBuscanLibros(String string) {
		return repositorioLibro.getLibrosTitulo(string);
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
	    
		
		private Autor givenAutor(String nombre, String apellido) {
			Autor autor = new Autor();
			autor.setNombre(nombre);
			autor.setApellido(apellido);
			return autor;
		}

}
