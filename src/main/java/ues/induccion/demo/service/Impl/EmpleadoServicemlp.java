package ues.induccion.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ues.induccion.demo.entity.Empleado;
import ues.induccion.demo.repository.EmpleadoJpaRepository;
import ues.induccion.demo.service.EmpleadoService;

@Service("empleadoServicemlp")
public class EmpleadoServicemlp implements EmpleadoService  {
	
	@Autowired
	@Qualifier("empleadoJpaRepository")
	private EmpleadoJpaRepository empleadoJpaRepository;
	
	@Override
	public Empleado store(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoJpaRepository.save(empleado);
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoJpaRepository.save(empleado);
	}

	@Override
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return empleadoJpaRepository.findAll();
	}

	@Override
	public void destroyer(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoJpaRepository.delete(empleado);
		
	}
	

}
