package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ibm.academia.apirest.entities.Carrera;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer>
{ 
	//Consultas por metodos
	//Carrera por Cantidad de años buscar
	//@Query("select  c from Carrera c where c.cantidadAnios = ?1")
	public Iterable<Carrera> findByCantidadAnios(Integer cantidadAnios);
	
	//Buscar carreras por nombre
	//@Query("select  c from Carrera c where c.nombre like %?1%")
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre);

	//Buscar carreras en mayusculas y minusculas. upper convierte el objeto a mayuscula o minuscula.
	//@Query("select  c from Carrera c where upper(c.nombre) like upper(%?1%)")
	public Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);
	
	//Encontrar carreras por CantidadAnios
	//@Query("select  c from Carrera c where c.cantidadAnios > ?1")
	public Iterable<Carrera> findCarerrasByCantidadAniosAfter(Integer cantidadAnios);
}
