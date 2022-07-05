package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>
{
	Iterable<Carrera> findCarrerasByNombreContains(String nombre);
	Iterable<Carrera> findByNombreContains(String nombre);
	Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
	Iterable<Carrera> findCarerrasByCantidadAniosAfter(Integer cantidadAnios);
}
