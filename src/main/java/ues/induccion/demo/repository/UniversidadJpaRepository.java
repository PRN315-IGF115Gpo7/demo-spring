package ues.induccion.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.induccion.demo.entity.Universidad;

@Repository("universidadJpaRepository")
public interface UniversidadJpaRepository extends JpaRepository<Universidad, Serializable>{
	
}
