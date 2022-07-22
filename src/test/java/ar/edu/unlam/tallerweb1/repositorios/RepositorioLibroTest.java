package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Libro;


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
  
    public Libro givenLibro(String nombre) {
    	Libro libro = new Libro ();
    	libro.setTitulo(nombre);
    	return libro;
    }
}