package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.GeneroLibro;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.TipoGenero;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


import java.util.List;


public class RepositorioLibroTest extends SpringTest {

    @Autowired
    private RepositorioLibro repositorioLibro;
   
    @Test
    @Transactional
    @Rollback
    public void queSeListenTodosLosGenerosDeUnLibro() {
    	
    	Libro A = givenLibro("A");
    	Libro B = givenLibro("B");
    	Genero C = givenGenero(TipoGenero.CienciaFiccion);
    	Genero D = givenGenero(TipoGenero.Suspenso);
    	Genero E = givenGenero(TipoGenero.Misterio);
    	Genero F = givenGenero(TipoGenero.Historico);
    	GeneroLibro gn = givenGeneroLibro(C,A);
    	GeneroLibro gn1 = givenGeneroLibro(D,A);
    	GeneroLibro gn2 = givenGeneroLibro(E,A);
    	GeneroLibro gn3 = givenGeneroLibro(F,A);
    	GeneroLibro gn4 = givenGeneroLibro(C,B);
    	GeneroLibro gn5 = givenGeneroLibro(D,B);


    	session().save(A);
    	session().save(B);
    	session().save(C);
    	session().save(D);
    	session().save(E);
    	session().save(F);
    	session().save(gn);
    	session().save(gn1);
    	session().save(gn2);
    	session().save(gn3);
    	session().save(gn4);
    	session().save(gn5);
    	

    	
    	List <GeneroLibro> encontradosA = repositorioLibro.getGenerosLibro(A.getId());
    	List <GeneroLibro> encontradosB = repositorioLibro.getGenerosLibro(B.getId());
    	
    	assertThat(encontradosA.size()).isEqualTo(4);
    	assertThat(encontradosB.size()).isEqualTo(2);
    	assertThat(encontradosA.get(0).getGenero().getGenero()).isEqualTo(TipoGenero.CienciaFiccion);
    	assertThat(encontradosB.get(1).getGenero().getGenero()).isEqualTo(TipoGenero.Suspenso);
    	
    }
    
    

	@Test
    @Transactional
    @Rollback
    public void queSeListenTodasLasReseniasDeUnLibro() {
    	
    	Libro A = givenLibro("A");
    	Libro B = givenLibro("B");
    	Resenia E = givenResenia("Resenia E",A);
    	Resenia C = givenResenia("Resenia C",A);
    	Resenia D = givenResenia("Resenia D",B);

    	session().save(A);
    	session().save(B);
    	session().save(E);
    	session().save(C);
    	session().save(D);
    	

    	
    	List <Resenia> encontradosA = repositorioLibro.getReseniasLibro(A.getId());
    	List <Resenia> encontradosB = repositorioLibro.getReseniasLibro(B.getId());
    	
    	assertThat(encontradosA.size()).isEqualTo(2);
    	assertThat(encontradosB.size()).isEqualTo(1);
    	assertThat(encontradosA.get(0).getResenia()).isEqualTo("Resenia E");
    	
    }
    
  
	@Test
    @Transactional
    @Rollback
    public void queSeListenTodosLosLibros() {
    	
    	Libro A = givenLibro("A");
    	Libro B = givenLibro("B");
    	Libro C = givenLibro("C");
    	Libro D = givenLibro("D");
    	Libro E = givenLibro("E");
    	Libro F = givenLibro("F");
    	Libro G = givenLibro("G");
    	Libro H = givenLibro("H");
    	

    	session().save(A);
    	session().save(B);
    	session().save(C);
    	session().save(D);
    	session().save(E);
    	session().save(F);
    	session().save(G);
    	session().save(H);
    	
    	List <Libro> encontrados = repositorioLibro.getLibros();
    	
    	assertThat(encontrados.size()).isNotEqualTo(7);
    	assertThat(encontrados.size()).isEqualTo(8);
    	
    }
	
	private GeneroLibro givenGeneroLibro(Genero g,Libro l) {
		GeneroLibro gn = new GeneroLibro();
		gn.setGenero(g);
		gn.setLibro(l);
		return gn;
	}
	
	
	private Genero givenGenero(TipoGenero cienciaficcion) {
		Genero genero = new Genero();
		genero.setGenero(cienciaficcion);
		return genero;
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
    
    private Resenia givenResenia(String string,Libro libro) {
		Resenia resenia = new Resenia();
		resenia.setResenia(string);
		resenia.setLibro(libro);
		return resenia;
	}
}