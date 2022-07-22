package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("RepositorioBiblioteca")
@Transactional
public class RepositorioBibliotecaImpl implements RepositorioBiblioteca {

	 private SessionFactory sessionFactory;
	 
	@Autowired
	private RepositorioBibliotecaImpl (SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
		
	private Session getSession() {
		   return sessionFactory.getCurrentSession();
	}
		
	@Override
	public Boolean guardar(Biblioteca biblioteca) {
		
		if(biblioteca.getEstado()!=(null)) {
		getSession().save(biblioteca);
		
		return true;
		}
		 	
		return false;
	}

	@Override
	public Biblioteca getBiblioteca(Long l, Long u) {
		Criterion rest1 = Restrictions.eq("usuario.id",u);
		Criterion rest2 = Restrictions.eq("libro.id",l);
		
		return (Biblioteca) getSession().createCriteria(Biblioteca.class).add(rest1).add(rest2).uniqueResult();
	}

	@Override
	public void cambiarPuntuacion(Long l, Long u,Double p) {

		Biblioteca b = getBiblioteca(l,u);
		
		b.setPuntuacion(p);
		
		getSession().update(b);
		
	}

	@Override
	public void cambiarEstado(Long l, Long u,Estado e) {
		Biblioteca b = getBiblioteca(l,u);
		
		b.setEstado(e);
		
		getSession().update(b);
		
	}

	@Override
	public List<Biblioteca> getBiblbiotecasDeLibro(Long id) {
		Criterion rest1 = Restrictions.eq("libro.id",id);
		
		return getSession().createCriteria(Biblioteca.class).add(rest1).list();
	}
	
	@Override
	public List<Biblioteca> getBiblbiotecaDeUsuario(Long id) {
		Criterion rest1 = Restrictions.eq("usuario.id",id);
		
		return getSession().createCriteria(Biblioteca.class).add(rest1).list();
	}

}
