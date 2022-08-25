package com.ciberclase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciberclase.entity.Alumno;

@Repository
public interface AlumnoRepositoty extends JpaRepository<Alumno, Integer>{
	
	@Query("Select a from Alumno a where dni = ?1 and id <> ?2")
	public List<Alumno> listaAlumnoDniDiferenteDelMismoID(String dni, int id);
	
	@Query("Select a from Alumno a where dni = ?1")
	public List<Alumno> listaAlumnoPorDNI(String dni);
	
	
	
}
