package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.GeneroLibro;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.TipoGenero;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;


import static org.assertj.core.api.Assertions.*;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ServicioLibroTest {
	
	private RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
	private RepositorioBiblioteca repositorioBiblioteca = mock(RepositorioBiblioteca.class);

	private ServicioLibroImpl servicioLibro= new ServicioLibroImpl(repositorioLibro,repositorioBiblioteca);
	
	
	
	@Test
    public void queSePuedanObtenerLasReseniasDeUnLibro() {
    	
    	Libro A = givenLibro("L");
    	Resenia E = givenResenia("Resenia E",A);
    	Resenia C = givenResenia("Resenia C",A);
    	Resenia D = givenResenia("Resenia D",A);
    	
    	List <Resenia> R = new ArrayList();
    	R.add(E);
    	R.add(C);
    	R.add(D);

    	when(repositorioLibro.getReseniasLibro(A.getId())).thenReturn(R);
	
    	List <Resenia> obtenidas;
    	obtenidas = whenObtengoResenias(A.getId());
    	
    	thenObtengoResenias(obtenidas,A.getId());
    	
    }
	
	
	private void thenObtengoResenias(List<Resenia> obtenido,Long id) {
		verify(repositorioLibro,times(1)).getReseniasLibro(id);
		assertThat(obtenido.get(0).getResenia()).isEqualTo("Resenia E");
		assertThat(obtenido.get(1).getResenia()).isEqualTo("Resenia C");
		assertThat(obtenido.get(2).getResenia()).isEqualTo("Resenia D");
		
	}

	private List <Resenia> whenObtengoResenias(Long id) {
		return servicioLibro.getReseniasLibro(id);
		
	}
	
	
	@Test
    public void queSePuedanObtenerLosGenerosDeUnLibro() {
    	
    	Libro A = givenLibro("L");
    	Genero C = givenGenero(TipoGenero.CienciaFiccion);
    	Genero D = givenGenero(TipoGenero.Suspenso);
    	Genero E = givenGenero(TipoGenero.Misterio);
    	Genero F = givenGenero(TipoGenero.Historico);
    	GeneroLibro gn = givenGeneroLibro(C,A);
    	GeneroLibro gn1 = givenGeneroLibro(D,A);
    	GeneroLibro gn2 = givenGeneroLibro(E,A);
    	GeneroLibro gn3 = givenGeneroLibro(F,A);
    	
    	List <GeneroLibro> gnl = new ArrayList();
    	gnl.add(gn);
    	gnl.add(gn1);
    	gnl.add(gn2);
    	gnl.add(gn3);

    	when(repositorioLibro.getGenerosLibro(A.getId())).thenReturn(gnl);
	
    	List <Genero> obtenido;
    	obtenido = whenObtengoGeneros(A.getId());
    	
    	thenObtengoGeneros(obtenido,A.getId());
    	
    }
	
	
	private void thenObtengoGeneros(List<Genero> obtenido,Long id) {
		verify(repositorioLibro,times(1)).getGenerosLibro(id);
		assertThat(obtenido.get(0).getGenero()).isEqualTo(TipoGenero.CienciaFiccion);
		assertThat(obtenido.get(1).getGenero()).isEqualTo(TipoGenero.Suspenso);
		assertThat(obtenido.get(3).getGenero()).isEqualTo(TipoGenero.Historico);
		
	}

	private List <Genero> whenObtengoGeneros(Long id) {
		return servicioLibro.getGenerosLibro(id);
		
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
	
	private Genero givenGenero(TipoGenero cienciaficcion) {
		Genero genero = new Genero();
		genero.setId(new Random().nextLong());
		genero.setGenero(cienciaficcion);
		return genero;
	}
  
	 private Resenia givenResenia(String string,Libro libro) {
			Resenia resenia = new Resenia();
			resenia.setId(new Random().nextLong());
			resenia.setResenia(string);
			resenia.setLibro(libro);
			return resenia;
		}
	 
	 private GeneroLibro givenGeneroLibro(Genero g,Libro l) {
			GeneroLibro gn = new GeneroLibro();
			gn.setId(new Random().nextLong());
			gn.setGenero(g);
			gn.setLibro(l);
			return gn;
		}
	

}
