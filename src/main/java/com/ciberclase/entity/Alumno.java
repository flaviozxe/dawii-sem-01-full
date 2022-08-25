package com.ciberclase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alumno")
@Getter
@Setter

public class Alumno {
	
	@Id
	@Column(name = "idAlumno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String dni;
	
	private String correo;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNac;

}
