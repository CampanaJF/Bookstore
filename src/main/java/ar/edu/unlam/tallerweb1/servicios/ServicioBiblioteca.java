package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;

public interface ServicioBiblioteca {

	void agregarABiblioteca(Long Lid, Long Uid);

	void guardarBiblioteca(Biblioteca nueva);
	
	void cambiarPuntuacion(Long id, Long id2, Double p);

	Boolean validarBibliotecaExistente(Long lid, Long uid);

	void cambiarEstado(Long id, Long id2, Estado nuevo);

	void quitarDeBiblioteca(Long id, Long id2);

	Biblioteca getBiblioteca(Long Lid, Long Uid);

}
