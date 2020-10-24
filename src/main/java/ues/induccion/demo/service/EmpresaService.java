package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Empresa;

public interface EmpresaService {

	public Empresa store(Empresa estudiante);
	public Empresa update(Empresa estudiante);
	public List<Empresa> getAll();
	public void destroy(Empresa estudiante);
	public Empresa findById(int id_empresa);
}
