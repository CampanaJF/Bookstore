package ar.edu.unlam.tallerweb1.servicios;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.GeneroLibro;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("servicioLibro")
@Transactional
public class ServicioLibroImpl implements ServicioLibro{
	
	private RepositorioLibro repositorioLibro;
	private RepositorioBiblioteca repositorioBiblioteca;


	@Autowired
	public ServicioLibroImpl(RepositorioLibro repositorioLibro,RepositorioBiblioteca repositorioBiblioteca){
		this.repositorioLibro = repositorioLibro;
		this.repositorioBiblioteca = repositorioBiblioteca;
	}

	@Override
	public Libro getLibro(Long id) {
		
		return this.repositorioLibro.getLibro(id);
	}

	@Override
	public List<Libro> getLibros() {
		
		return this.repositorioLibro.getLibros();
	}

	
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

	@Override
	public void crearLibro(Libro libro){
		
		libro = setPublicadoLibro(libro);
		
		validarTituloYSinopsis(libro);
		
		validarLenguajeLibro(libro);
		
		validarPortadaYArchivo(libro);
		
		this.repositorioLibro.guardar(libro);
			
	}

	

	@Override
	public Libro setPublicadoLibro(Libro libro) {
		
		Date now = new Date();
    	now.getTime();
		libro.setPublicado(now);
		
		SimpleDateFormat formatofecha = new SimpleDateFormat ("dd-MM-yyyy");
		
		libro.setPublicadoS( formatofecha.format(libro.getPublicado()) );	
			
		return libro;
		
	}

	@Override
	public void validarTituloYSinopsis(Libro libro) {
		if(libro.getTitulo()==null||libro.getSinopsis()==null)
			throw new LibroSinTituloOSinopsisException();
		
	}
	
	@Override
	public void validarLenguajeLibro(Libro libro) {

		if(libro.getLenguaje()==null)
			throw new LibroSinLenguajeException();
		
	}

	@Override
	public Libro validarPortadaYArchivo(Libro libro) {
		if(libro.getArchivo()==null)
			throw new LibroSinArchivoException();
		if(libro.getPortada()==null)
			libro.setPortada("book");
		
		return libro;
	}

	@Override
	public Libro setPaginas(Libro libro) throws IOException {
		
		String path = "D:/DW/Eclipse_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shelves/archivos";
		
		PDDocument doc = PDDocument.load(new File(path+"/"+libro.getArchivo()+".pdf"));
		int count = doc.getNumberOfPages();
		doc.close();
		
		libro.setPaginas(count);
		return libro;
	}

	
	

	

}
