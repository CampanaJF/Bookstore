package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


import java.util.List;


public class RepositorioBibliotecaTest extends SpringTest {

    @Autowired
    private RepositorioBiblioteca repositorioBiblioteca;
   
    @Test
    @Transactional
    @Rollback
    public void queSeGuardeUnLibroEnLaBibliotecaDeUnUsuario() {
    	
    	Libro L1= givenLibro("A");
    	Libro L2= givenLibro("B");
    	Usuario U0 = givenUsuario("0");
    	Biblioteca B0 = givenBiblioteca(L1,U0);
    	B0.setEstado(Estado.Nuevo);

    	session().save(L1);
    	session().save(L2);
    	session().save(U0);
    	session().save(B0);

    	whenSeGuardaEnLaBiblioteca(B0);
    	List<Biblioteca> b= whenSeTraeLaBibliotecaDeEseUsuario(U0);

    	thenSeGuardoCorrectamente(b,L1,U0);
    }
    
    private void thenSeGuardoCorrectamente(List<Biblioteca> b,Libro L1,Usuario U0) {
		assertThat(b.get(0).getLibro()).isEqualTo(L1);
		assertThat(b.get(0).getUsuario()).isEqualTo(U0);
		assertThat(b.size()).isEqualTo(1);
	}

	private void whenSeGuardaEnLaBiblioteca(Biblioteca B0) {
		repositorioBiblioteca.guardar(B0);
		
	}

	@Test
    @Transactional
    @Rollback
    public void queSeTraiganLasBibliotecasEnLasQueEstaUnLibro() {
    	
    	Libro L1= givenLibro("A");
    	Libro L2= givenLibro("B");
    	Usuario U0 = givenUsuario("0");
    	Usuario U1 = givenUsuario("1");
    	Usuario U2 = givenUsuario("2");
    	Usuario U3 = givenUsuario("3");
    	Usuario U4 = givenUsuario("4");
    	Biblioteca B0 = givenBiblioteca(L1,U0);
    	Biblioteca B1 = givenBiblioteca(L1,U1);
    	Biblioteca B2 = givenBiblioteca(L1,U2);
    	Biblioteca B3 = givenBiblioteca(L1,U3);
    	Biblioteca B4 = givenBiblioteca(L1,U4);
    	Biblioteca B5 = givenBiblioteca(L2,U0);
  
   
    	session().save(L1);
    	session().save(L2);
    	session().save(U0);
    	session().save(U1);
    	session().save(U2);
    	session().save(U3);
    	session().save(U4);
    	session().save(B0);
    	session().save(B1);
    	session().save(B2);
    	session().save(B3);
    	session().save(B4);
    	session().save(B5);
    

    	List<Biblioteca> b= whenSeTraenLasBibliotecasDeEseLibro(L1);
    	List<Biblioteca> b1= whenSeTraenLasBibliotecasDeEseLibro(L2);
    	
    	thenTraeLasBibliotecas(b,b1);
    }
    
    private void thenTraeLasBibliotecas(List<Biblioteca> b,List<Biblioteca> b1) {
    	
    	assertThat(b.size()).isEqualTo(5);
    	assertThat(b1.size()).isEqualTo(1);

	}

	private List<Biblioteca> whenSeTraenLasBibliotecasDeEseLibro(Libro l1) {

		return repositorioBiblioteca.getBibliotecasDelLibro(l1.getId());
	}

	@Test
    @Transactional
    @Rollback
    public void queSeTraiganTodosLosLibrosDeUnUsuario() {
    	
		Libro L1= givenLibro("A");
    	Libro L2= givenLibro("B");
    	Libro L3= givenLibro("C");
    	Libro L4= givenLibro("D");
    	Libro L5= givenLibro("F");
    	Libro L6= givenLibro("G");
    	Usuario U0 = givenUsuario("0");
    	Usuario U1 = givenUsuario("1");
    	Biblioteca B0 = givenBiblioteca(L1,U0);
    	Biblioteca B1 = givenBiblioteca(L2,U1);
    	Biblioteca B2 = givenBiblioteca(L3,U0);
    	Biblioteca B3 = givenBiblioteca(L4,U1);
    	Biblioteca B4 = givenBiblioteca(L5,U0);
    	Biblioteca B5 = givenBiblioteca(L6,U0);
  
   
    	session().save(L1);
    	session().save(L2);
    	session().save(U0);
    	session().save(U1);
    	session().save(L3);
    	session().save(L4);
    	session().save(L5);
    	session().save(L6);
    	session().save(B0);
    	session().save(B1);
    	session().save(B2);
    	session().save(B3);
    	session().save(B4);
    	session().save(B5);
    

    	List<Biblioteca> b= whenSeTraeLaBibliotecaDeEseUsuario(U0);
    	List<Biblioteca> b1= whenSeTraeLaBibliotecaDeEseUsuario(U1);
    	
    	thenTraeLaBiblioteca(b,b1);
    }
    
    private void thenTraeLaBiblioteca(List<Biblioteca> b, List<Biblioteca> b1) {
    	assertThat(b.size()).isEqualTo(4);
    	assertThat(b1.size()).isEqualTo(2);
		
	}

	private List<Biblioteca> whenSeTraeLaBibliotecaDeEseUsuario(Usuario u1) {
    	
    	return repositorioBiblioteca.getBibliotecasDelUsuario(u1.getId());
	}
    

	@Test
    @Transactional
    @Rollback
    public void queSePuedaObtenerLaPuntuacionYElEstadoDeUnLibroEnLaBiblioteca() {
    	
    	Libro L1= givenLibro("A");
    	Usuario U0 = givenUsuario("U");
    	Biblioteca B0 = givenBiblioteca(L1,U0);
  
    	B0.setPuntuacion(9.9D);
   
    	session().save(L1);
    	session().save(U0);
    	session().save(B0);

    	//when
    	Double puntuacion = repositorioBiblioteca.getBiblioteca(L1.getId(),U0.getId()).getPuntuacion();
    	Estado estado = repositorioBiblioteca.getBiblioteca(L1.getId(),U0.getId()).getEstado();
    	
    	//then
    	assertThat(puntuacion).isEqualTo(9.9D);
    	assertThat(estado).isEqualTo(Estado.Nuevo);
    	assertThat(puntuacion).isNotEqualTo(9D);
    }
    
    @Test
    @Transactional
    @Rollback
    public void queSePuedaCambiarLaPuntuacioYElEstadonDeUnLibroEnLaBiblioteca() {
    	
    	Libro L1= givenLibro("A");
    	Usuario U0 = givenUsuario("U");
    	Biblioteca B0 = givenBiblioteca(L1,U0);
    	
    	Double puntuacionVieja = 9.9D;

    	B0.setPuntuacion(puntuacionVieja);
   
    	session().save(L1);
    	session().save(U0);
    	session().save(B0);
    	
    	Long L = L1.getId();
    	Long U = U0.getId();
    	
    	whenCambioLaPuntuacionDelLibro(L,U);
    	whenCambioElEstadoDelLibro(L,U);

    	thenSeObtienenLaPuntuacionYEstadoEsperados(L,U);
    }
    
    
    
    private void thenSeObtienenLaPuntuacionYEstadoEsperados(Long l,Long u) {
    	Double puntuacion = repositorioBiblioteca.getBiblioteca(l,u).getPuntuacion();
    	Estado estado = repositorioBiblioteca.getBiblioteca(l,u).getEstado();
    	
    	assertThat(puntuacion).isEqualTo(8.9D);
    	assertThat(estado).isEqualTo(Estado.Terminado);
    	
	}

	private void whenCambioLaPuntuacionDelLibro(Long l,Long u) {
    	Double puntuacionNueva = 8.9D;
    
    	repositorioBiblioteca.cambiarPuntuacion(l, u,puntuacionNueva);
		
	}
    
    private void whenCambioElEstadoDelLibro(Long l,Long u) {
    	Estado estadoNuevo = Estado.Terminado; 
    	
    	repositorioBiblioteca.cambiarEstado(l, u,estadoNuevo);
		
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