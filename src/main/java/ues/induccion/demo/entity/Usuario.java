package ues.induccion.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios") 
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "username", unique = true)
	String username;
	@Column(name = "contraseña")
	String password;
    boolean es_activo;
    Integer intentos;
    
    public Usuario() {
	}
	public Usuario(Integer id, String username, String password, boolean es_activo, Integer intentos,
			String fecha_registro) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.es_activo = es_activo;
		this.intentos = intentos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEs_activo() {
		return es_activo;
	}
	public void setEs_activo(boolean es_activo) {
		this.es_activo = es_activo;
	}
	public Integer getIntentos() {
		return intentos;
	}
	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}
    
}
