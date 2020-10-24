package ues.induccion.demo.service;

import java.util.List;

import ues.induccion.demo.entity.Usuario;

public interface UsuarioService {
	public Usuario store(Usuario usuario);
	public Usuario update(Usuario usuario);
    public List<Usuario> getAll();
    public void destroy(Usuario usuario);
    public Usuario findById(int id_usuario);
}
