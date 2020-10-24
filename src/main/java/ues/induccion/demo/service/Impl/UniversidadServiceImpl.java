package ues.induccion.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ues.induccion.demo.entity.Universidad;
import ues.induccion.demo.repository.UniversidadJpaRepository;
import ues.induccion.demo.service.UniversidadService;


@Service("universidadServiceImpl")
public class UniversidadServiceImpl implements UniversidadService{

	@Autowired
	@Qualifier("universidadJpaRepository")
	private UniversidadJpaRepository universidadJpaRepository;
	
	@Override
	public Universidad store(Universidad universidad) {
		// TODO Auto-generated method stub
		return universidadJpaRepository.save(universidad);
	}

	@Override
	public Universidad update(Universidad universidad) {
		// TODO Auto-generated method stub
		return universidadJpaRepository.save(universidad);
	}

	@Override
	public List<Universidad> getAll() {
		// TODO Auto-generated method stub
		return universidadJpaRepository.findAll();
	}

	@Override
	public void destroy(Universidad universidad) {
		// TODO Auto-generated method stub
		universidadJpaRepository.delete(universidad);
	}

	@Override
	public Universidad findById(int id_universidad) {
		// TODO Auto-generated method stub
		return universidadJpaRepository.getOne(id_universidad);
	}
	
}
