package ar.edu.unlam.tallerweb1.repositorios;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;


@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("RepositorioAutor")
@Transactional
public class RepositorioAutorImpl implements RepositorioAutor {
	
	 private SessionFactory sessionFactory;
	 
	 @Autowired
		private RepositorioAutorImpl (SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
		}
	 
	 private Session getSession() {
		   return sessionFactory.getCurrentSession();
	}

	@Override
	public Autor getAutor(Long autorid) {
		
		Criterion rest1 = Restrictions.eq("id",autorid);
		
		return (Autor) getSession().createCriteria(Autor.class).add(rest1).uniqueResult();
	}
	
	@Override
	public List<Autor> getAutores() {

		return getSession().createCriteria(Autor.class).list();
	}
	
	@Override
	public Autor getAutorNombre(String nombre) {
		
		Criterion rest1 = Restrictions.eq("nombre",nombre);
		Criterion rest2 = Restrictions.eq("apellido",nombre);
		
		Autor e;

		e = (Autor) getSession().createCriteria(Autor.class).add(rest1).uniqueResult();
		
		if (e==null)
			return (Autor) getSession().createCriteria(Autor.class).add(rest2).uniqueResult();
		
		return e;
		
	}
	
	@Override
	public List<Autor> getAutoresNombre(String nombre) {
		Criterion rest1 = Restrictions.ilike("nombre",nombre,MatchMode.ANYWHERE);

		return getSession().createCriteria(Autor.class).add(rest1).list();
		
	}
	
	@Override
	public List<Autor> getAutoresApellido(String nombre) {
		Criterion rest2 = Restrictions.ilike("apellido",nombre,MatchMode.ANYWHERE);
		
		return getSession().createCriteria(Autor.class).add(rest2).list();
		
	}

}
