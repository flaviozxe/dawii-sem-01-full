package com.ciberclase.service;

import java.util.List;
import java.util.Optional;

import com.ciberclase.entity.Alumno;

public interface AlumnoService {
	
	public abstract Optional<Alumno> buscarAlumnoPorId(int id);
	
	public abstract List<Alumno> listaAlumnoPorDNI(String dni);

	public abstract List<Alumno> listaAlumno();
	
	public abstract Alumno insertarAlumno(Alumno obj);
	
	public abstract Alumno actualizaAlumno(Alumno obj);
	
	public abstract List<Alumno> listaAlumnoDniDiferenteDelMismoID(String dni, int id);
	
	
	
}
