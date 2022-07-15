package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RespuestaComentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Comentario comentarioBase;
	
	@ManyToOne
	private Comentario respuesta;

	public Comentario getComentarioBase() {
		return comentarioBase;
	}

	public void setComentarioBase(Comentario comentarioBase) {
		this.comentarioBase = comentarioBase;
	}

	public Comentario getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Comentario respuesta) {
		this.respuesta = respuesta;
	}

	
}
