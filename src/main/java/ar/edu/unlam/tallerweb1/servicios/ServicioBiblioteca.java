package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;

public interface ServicioBiblioteca {

	Boolean agregarABiblioteca(Long Lid, Long Uid);

	Boolean guardarBiblioteca(Biblioteca nueva);

}
