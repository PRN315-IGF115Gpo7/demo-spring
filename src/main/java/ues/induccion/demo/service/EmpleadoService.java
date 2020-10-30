package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Empleado;

public interface EmpleadoService {
	public Empleado store(Empleado empleado);
	public Empleado update(Empleado empleado);
	public List<Empleado>  getAll();
	public void destroyer(Empleado empleado);
}
