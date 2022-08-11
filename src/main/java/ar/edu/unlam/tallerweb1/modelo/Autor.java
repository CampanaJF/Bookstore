package ar.edu.unlam.tallerweb1.modelo;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Autor {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String nombre;
		private String apellido;
		
		private String img;
		
		@Column(columnDefinition = "boolean default false")
		private Boolean activo;
		
		@OneToOne
		private Usuario usuario;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public Boolean getActivo() {
			return activo;
		}
		public void setActivo(Boolean activo) {
			this.activo = activo;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Autor autor = (Autor) o;
			return Objects.equals(id, autor.id)
					&& Objects.equals(nombre, autor.nombre) && Objects.equals(apellido, autor.apellido)
					&& Objects.equals(activo, autor.activo) && Objects.equals(usuario, autor.usuario);

		}

		@Override
		public int hashCode() {
			return Objects.hash(id,nombre,apellido, activo,usuario);
		}
		public String getImagen() {
			return img;
		}
		public void setImagen(String imagen) {
			this.img = imagen;
		}
		
		

}
