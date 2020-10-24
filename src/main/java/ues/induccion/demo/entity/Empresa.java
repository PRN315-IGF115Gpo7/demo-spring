package ues.induccion.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
//	@Column(name = "id", unique = true)
	String nombre;
	String telefono;
	String direccion;
	int cantidad_empleados;
	
	@Column(name = "fecha_fundacion")
	String fecha_fundacion;

	public Empresa() {
	}
	
	public Empresa(Integer id, String nombre, String Telefono, String direccion, int cantidad_empleados) {
		super();
		this.id = id;
		
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantidad_empleados() {
		return cantidad_empleados;
	}

	public void setCantidad_empleados(int cantidad_empleados) {
		this.cantidad_empleados = cantidad_empleados;
	}

	public String getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(String fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}

}
