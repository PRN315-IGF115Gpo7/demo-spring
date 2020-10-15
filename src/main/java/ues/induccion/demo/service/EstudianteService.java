package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Estudiante;

public interface EstudianteService {

	public Estudiante store(Estudiante estudiante);
	public Estudiante update(Estudiante estudiante);
	public List<Estudiante> getAll();
	public void destroy(Estudiante estudiante);
	public Estudiante findById(int id_estudiante);
}
