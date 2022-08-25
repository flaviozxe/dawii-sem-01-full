package com.ciberclase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciberclase.entity.Alumno;
import com.ciberclase.service.AlumnoService;

@RestController
@RequestMapping("/rest/Alumno")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {

	@Autowired
	AlumnoService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno(){
		List<Alumno> lista = service.listaAlumno();
		if(lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lista);
	} 
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertarAlumno(@RequestBody Alumno obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			if(obj != null) {
				List<Alumno> lista = service.listaAlumnoPorDNI(obj.getDni());
				if(lista.isEmpty()) {
					Alumno objSalida = service.insertarAlumno(obj);				
					if(objSalida != null) {
						salida.put("mensaje", "se registro correctamente");
					}
					else {
						salida.put("mensaje", "error en el registro");
					}
				}
				else {
					salida.put("mensaje", "el numero de dni ya se encuentra registrado");
				}
			}
			else {
				salida.put("mensaje", "el objeto que envio es nulo");
			}
			
		}
		catch(Exception e){
			salida.put("mensaje", "Error en el registro");
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizaAlumno(@RequestBody Alumno obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			if(obj != null) {
				Optional<Alumno> objSalida = service.buscarAlumnoPorId(obj.getId());
				if(objSalida.isPresent()) {
				List<Alumno> listaAlumnoDni = service.listaAlumnoDniDiferenteDelMismoID(obj.getDni(), obj.getId());
				if(listaAlumnoDni.isEmpty()) {
					Alumno objSaldia =  service.actualizaAlumno(obj);
					if(objSaldia != null) {
						salida.put("mensaje", "Se actualizo correctamente");
					}
					else {
						salida.put("mensaje","Error en la actualizacion");
					}
				}
				else {
					salida.put("mensaje", "El dni ingresado ya se encuentra registrado");
				}	
			  }
			else {
				salida.put("mensaje", "El id al que intenta acceder no existe");
					
			 }
				
			}
			else {
				salida.put("mensaje", "El objeto ingresado es nulo");
			}
			
		}
		catch(Exception ex){
			salida.put("mensaje", "Error en la actualizacion");
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	
	
	
}
