package ues.induccion.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "dui", unique = true)
	String DUI;
	String nombreCompleto;
	String sexo;
	Double salario;
	Double fecha_contratacion;
	
	public Empleado() {
		
	}
	
	public Empleado(Integer id, String dUI, String nombreCompleto, String sexo, Double salario,
			Double fecha_contratacion) {
		super();
		this.id = id;
		DUI = dUI;
		this.nombreCompleto = nombreCompleto;
		this.sexo = sexo;
		this.salario = salario;
		this.fecha_contratacion = fecha_contratacion;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDUI() {
		return DUI;
	}
	public void setDUI(String dUI) {
		DUI = dUI;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getFecha_contratacion() {
		return fecha_contratacion;
	}
	public void setFecha_contratacion(Double fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}
	
	
}
