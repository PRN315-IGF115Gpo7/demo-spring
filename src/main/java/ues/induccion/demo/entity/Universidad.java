package ues.induccion.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universidades")
public class Universidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String nombre;
	
	Integer cantidad_carreras;
	String es_publica;
	String direccion;
	String fecha_fundacion;
	
	public Universidad() {
	}
	
	public Universidad(Integer id, String nombre, Integer cantidad_carreras,String es_publica, String direccion, String fecha_fundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad_carreras=cantidad_carreras;
		this.es_publica = es_publica;
		this.direccion = direccion;
		this.fecha_fundacion = fecha_fundacion;
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

	public String getEs_publica() {
		return es_publica;
	}

	public void setEs_publica(String es_publica) {
		this.es_publica = es_publica;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(String fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}

	public Integer getCantidad_carreras() {
		return cantidad_carreras;
	}

	public void setCantidad_carreras(Integer cantidad_carreras) {
		this.cantidad_carreras = cantidad_carreras;
	}
}
