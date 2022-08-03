package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;


@Entity
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String nombre;
	
	@Lob
	private String img;
	
	@OneToOne
	private Premium premium;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean esPremium;
	
	private Long diasAVencimientoPremium;
	
	private String password;
	
	private Boolean activo = false;
	
	private Date fechaRegistro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public boolean activo() {
		return activo;
    }

    public void activarUsuario() {
		activo = true;
    }
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Premium getPremium() {
		return premium;
	}
	public void setPremium(Premium premium) {
		this.premium = premium;
	}
	public Boolean getEsPremium() {
		return esPremium;
	}
	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}
	public Long getDiasAVencimientoPremium() {
		return diasAVencimientoPremium;
	}
	public void setDiasAVencimientoPremium(Long diasAVencimientoPremium) {
		this.diasAVencimientoPremium = diasAVencimientoPremium;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(id, usuario.id) && Objects.equals(esPremium, usuario.esPremium)
				&& Objects.equals(diasAVencimientoPremium, usuario.diasAVencimientoPremium) && Objects.equals(email, usuario.email)
				&& Objects.equals(password, usuario.password) && Objects.equals(fechaRegistro, usuario.fechaRegistro)
				&& Objects.equals(activo, usuario.activo)
				&& Objects.equals(premium, usuario.premium)
				&& Objects.equals(img, usuario.img);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,esPremium, premium, email, password, diasAVencimientoPremium, fechaRegistro, activo, img);
	}
}
