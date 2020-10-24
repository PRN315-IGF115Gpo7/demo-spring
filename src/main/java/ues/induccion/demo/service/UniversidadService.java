package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Universidad;

public interface UniversidadService {
	
	public Universidad store(Universidad universidad);
	public Universidad update(Universidad universidad);
	public List<Universidad> getAll();
	public void destroy(Universidad universidad);
	public Universidad findById(int id_universidad);
}
