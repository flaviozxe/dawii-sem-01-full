package com.ciberclase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberclase.entity.Alumno;
import com.ciberclase.repository.AlumnoRepositoty;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	AlumnoRepositoty repo;
	
	@Override
	public List<Alumno> listaAlumno() {
		return repo.findAll();
	}

	@Override
	public Alumno insertarAlumno(Alumno obj) {
		return repo.save(obj);
	}

	@Override
	public Alumno actualizaAlumno(Alumno obj) {
		return repo.save(obj);
	}

	@Override
	public List<Alumno> listaAlumnoDniDiferenteDelMismoID(String dni, int id) {
		return repo.listaAlumnoDniDiferenteDelMismoID(dni, id);
	}

	@Override
	public Optional<Alumno> buscarAlumnoPorId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Alumno> listaAlumnoPorDNI(String dni) {
		return repo.listaAlumnoPorDNI(dni);
	}

}
