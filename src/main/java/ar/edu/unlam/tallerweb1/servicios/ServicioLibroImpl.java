package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.GeneroLibro;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;


@Service("servicioLibro")
@Transactional
public class ServicioLibroImpl implements ServicioLibro{
	
	private RepositorioLibro repositorioLibro;


	@Autowired
	public ServicioLibroImpl(RepositorioLibro repositorioLibro){
		this.repositorioLibro = repositorioLibro;
	}

	@Override
	public Libro getLibro(Long id) {
		
		return this.repositorioLibro.getLibro(id);
	}

	@Override
	public List<Libro> getLibros() {
		
		return this.repositorioLibro.getLibros();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Genero> getGenerosLibro(Long Lid) {
		
		
		List<GeneroLibro> generosLibro = this.repositorioLibro.getGenerosLibro(Lid);
		List<Genero> generos = new ArrayList();
		GeneroLibro GL;
		
		for (int i = 0; i < generosLibro.size(); i++) {
			GL=generosLibro.get(i);
			generos.add(GL.getGenero());
		}
		
		return generos;
	}

	@Override
	public List<Resenia> getReseniasLibro(Long Lid) {
		
		return this.repositorioLibro.getReseniasLibro(Lid);
	}

	

}
