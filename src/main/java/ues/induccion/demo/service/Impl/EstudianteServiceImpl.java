package ues.induccion.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ues.induccion.demo.entity.Estudiante;
import ues.induccion.demo.repository.EstudianteJpaRepository;
import ues.induccion.demo.service.EstudianteService;

@Service("estudianteServiceImpl")
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	@Qualifier("estudianteJpaRepository")
	private EstudianteJpaRepository estudianteJpaRepository;
	
	@Override
	public Estudiante store(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return estudianteJpaRepository.save(estudiante);
	}

	@Override
	public Estudiante update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return estudianteJpaRepository.save(estudiante);
	}

	@Override
	public List<Estudiante> getAll() {
		// TODO Auto-generated method stub
		return estudianteJpaRepository.findAll();
	}

	@Override
	public void destroy(Estudiante estudiante) {
		// TODO Auto-generated method stub
		estudianteJpaRepository.delete(estudiante);
	}

	@Override
	public Estudiante findById(int id_estudiante) {
		// TODO Auto-generated method stub
		return estudianteJpaRepository.getOne(id_estudiante);
	}

	
}
