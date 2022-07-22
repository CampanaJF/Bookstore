package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Lenguaje;
import ar.edu.unlam.tallerweb1.modelo.Libro;


@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("RepositorioLibro")
@Transactional
public class RepositorioLibroImpl implements RepositorioLibro {
	
	 private SessionFactory sessionFactory;
	 
	@Autowired
	private RepositorioLibroImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Libro> getLibros() {
		
		return getSession().createCriteria(Libro.class).list();
	}
	
	@Override
	public Libro getLibro(Long id) {
		Criterion rest1 = Restrictions.eq("id",id);
		
		return (Libro) getSession().createCriteria(Libro.class).add(rest1).uniqueResult();
	}
		
	@Override
	public Libro buscarLibroXTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro buscarLibroXAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro buscarLibroXLenguaje(Lenguaje lenguaje) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
