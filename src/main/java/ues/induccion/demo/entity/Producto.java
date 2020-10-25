package ues.induccion.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@Column(name = "margen_ganacia")
	private Integer margenGanacia;
	
	@Column(name = "es_nacional")
	private Boolean esNacional;
	
	@Column(name = "fecha_registro")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	public Producto() {
	}
	
	public Producto(Integer id, String nombre, Integer margenGanacia, Date fechaRegistro, Boolean esNacional) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.esNacional = esNacional;
		this.margenGanacia = margenGanacia;
		this.fechaRegistro = fechaRegistro;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getMargenGanacia() {
		return margenGanacia;
	}
	public void setMargenGanacia(Integer margenGanacia) {
		this.margenGanacia = margenGanacia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getEsNacional() {
		return esNacional;
	}

	public void setEsNacional(Boolean esNacional) {
		this.esNacional = esNacional;
	}
	
}
