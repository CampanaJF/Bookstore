package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.GeneroLibro;
import ar.edu.unlam.tallerweb1.modelo.Lenguaje;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;


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
	public List<GeneroLibro> getGenerosLibro(Long Lid) {
		Criterion rest1 = Restrictions.eq("libro.id",Lid);
		
		return getSession().createCriteria(GeneroLibro.class).add(rest1).list();
	}

	@Override
	public List<Resenia> getReseniasLibro(Long Lid) {
		Criterion rest1 = Restrictions.eq("libro.id",Lid);
		
		return getSession().createCriteria(Resenia.class).add(rest1).list();
	}
	
	@Override
	public void setPuntuacionLibro(Long id,Double p) {

	    Libro l = getLibro(id);
		
		l.setPuntuacion(p);
		
		getSession().update(l);
		
	}

	@Override
	public void guardar(Libro libro) {
		getSession().save(libro);
		
	}

	@Override
	public void update(Libro libro) {
		
		Libro l = getLibro(libro.getId());
		
		l=libro;
		
		getSession().update(l);
		
		
	}
		
	



}
