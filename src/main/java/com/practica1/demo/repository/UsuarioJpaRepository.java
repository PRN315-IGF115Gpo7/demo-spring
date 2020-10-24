package com.practica1.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica1.demo.entity.Usuario;

@Repository("usuarioJpaRepository")
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Serializable>{

}
