package com.practica1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practica1.demo.entity.Usuario;
import com.practica1.demo.repository.UsuarioJpaRepository;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	@Qualifier("usuarioJpaRepository")
	private UsuarioJpaRepository usuarioJpaRepository;
	
	@Override
	public Usuario store(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioJpaRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioJpaRepository.save(usuario);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioJpaRepository.findAll();
	}

	@Override
	public void destroy(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioJpaRepository.delete(usuario);
	}

	@Override
	public Usuario findById(int id_usuario) {
		// TODO Auto-generated method stub
		return usuarioJpaRepository.getOne(id_usuario);
	}

	
	
}
