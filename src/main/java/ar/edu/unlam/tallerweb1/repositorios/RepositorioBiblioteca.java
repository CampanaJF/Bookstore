package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;


public interface RepositorioBiblioteca {
	
	Boolean guardar(Biblioteca biblioteca);

	Biblioteca getBiblioteca(Long l, Long u);

	void cambiarPuntuacion(Long l, Long u,Double d);

	void cambiarEstado(Long l, Long u,Estado e);

	List<Biblioteca> getBiblbiotecasDeLibro(Long id);

	List<Biblioteca> getBiblbiotecaDeUsuario(Long id);

}
