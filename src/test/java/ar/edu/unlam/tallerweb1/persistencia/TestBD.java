package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class TestBD extends SpringTest{

    @Test
    @Transactional @Rollback
    public void testConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void testCrearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("ADMIN");
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void testCrearLibro(){
        Libro libro = new Libro();
        libro.setTitulo("TituloA");
        session().save(libro);
        
        assertThat(libro.getId()).isNotNull();
      
    }
    
    @Test
    @Transactional @Rollback
    public void testAsignarUsuarioaAutorYAutorALibro() {
    	Usuario usuario = new Usuario();
        usuario.setEmail("autorTest@gmail.com");
        usuario.setPassword("test");
    
        session().save(usuario);
        
        Autor autor = new Autor();
        autor.setNombre(null);
        autor.setNombre("nombreAutor");
        
        session().save(autor);
        
    	Libro libro = new Libro();
        libro.setTitulo("TituloA");
        libro.setAutor(autor);
        
        session().save(libro);
        
        System.out.println("ID AUTOR: " + libro.getAutor().getId());
        
        assertThat(libro.getAutor()).isNotNull();
        
           
    }

}
