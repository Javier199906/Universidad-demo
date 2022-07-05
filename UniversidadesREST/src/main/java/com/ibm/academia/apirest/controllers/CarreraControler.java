package com.ibm.academia.apirest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.exceptions.BadRequestExeption;
import com.ibm.academia.apirest.services.CarreraDAO;

@RestController
@RequestMapping("carrera")
public class CarreraControler
{
	@Autowired
	private CarreraDAO carreraDao;
	
	@GetMapping("/lista/carreras")
	public List<Carrera> buscarTodas()
	{
		List<Carrera> carreras = (List<Carrera>) carreraDao.buscarTodos();
		if(carreras.isEmpty())
			throw new BadRequestExeption("No existen carreras");
		
		return carreras;
	}
	@GetMapping("/id/{carreraId}")
	public Carrera buscarCarreraPorId (@PathVariable Integer carreraId) 
	{
		/*Optional<Carrera>  ocarrera = carreraDao.buscarPorId(carreraId);
		if(!ocarrera.isPresent())
			throw new BadRequestExeption(String.format("Carrera con id: &d no existe", carreraId));
	 return ocarrera.get();*/
	 Carrera carrera = carreraDao.buscarPorId(carreraId).orElse(null);
	 if(carrera == null)
		 throw new BadRequestExeption(String.format("La Carrera con ID: %d no existe ", carreraId));
	 return carrera;
	
	}
	
	@PostMapping
	public ResponseEntity<?> guardarCarrera(@RequestBody Carrera carrera)
	{
		if(carrera.getCantidadAnios() <0)
		throw new BadRequestExeption("El campo cantidad de años deber ser mayor a 0");
		
		if(carrera.getCantidadMaterias() <0)
		throw new BadRequestExeption("El campo cantidad de materias deber ser mayor a 0");
		
		Carrera carreraGuardada = carreraDao.guardar(carrera);
		
		return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
	}
}

