package ues.induccion.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ues.induccion.demo.entity.Producto;
import ues.induccion.demo.repository.ProductoJpaRepository;
import ues.induccion.demo.service.ProductoService;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	@Qualifier("productoJpaRepository")
	private ProductoJpaRepository productoJpaRepository;

	@Override
	public Producto store(Producto producto) {
		// TODO Auto-generated method stub
		return productoJpaRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return productoJpaRepository.save(producto);
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productoJpaRepository.findAll();
	}

	@Override
	public void destroy(Producto producto) {
		// TODO Auto-generated method stub
		productoJpaRepository.delete(producto);
		
	}

	@Override
	public Producto findById(int idProducto) {
		// TODO Auto-generated method stub
		return productoJpaRepository.getOne(idProducto);
	}

}
