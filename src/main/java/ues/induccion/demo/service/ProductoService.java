package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Producto;

public interface ProductoService {

	public Producto store(Producto producto);
	public Producto update(Producto producto);
	public List<Producto> getAll();
	public void destroy(Producto producto);
	public Producto findById(int idProducto);
}
