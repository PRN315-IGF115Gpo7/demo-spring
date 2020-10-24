package ues.induccion.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ues.induccion.demo.entity.Empresa;
import ues.induccion.demo.repository.EmpresaJpaRepository;
import ues.induccion.demo.service.EmpresaService;


@Service("empresaServiceImpl")
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
//	@Qualifier("estudianteJpaRepository")
	@Qualifier("empresaJpaRepository")
	private EmpresaJpaRepository empresaJpaRepository;
	
	@Override
	public Empresa store(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaJpaRepository.save(empresa);
	}

	@Override
	public Empresa update(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaJpaRepository.save(empresa);
	}

	@Override
	public List<Empresa> getAll() {
		// TODO Auto-generated method stub
		return empresaJpaRepository.findAll();
	}

	@Override
	public void destroy(Empresa empresa) {
		// TODO Auto-generated method stub
		empresaJpaRepository.delete(empresa);
	}

	@Override
	public Empresa findById(int id_empresa) {
		// TODO Auto-generated method stub
		return empresaJpaRepository.getOne(id_empresa);
	}

	
}
