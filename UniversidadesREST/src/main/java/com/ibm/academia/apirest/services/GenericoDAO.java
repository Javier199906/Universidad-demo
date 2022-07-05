package com.ibm.academia.apirest.services;

import java.util.Optional;
public interface GenericoDAO <E> //Metodo Generico
{
	public Optional<E> buscarPorId(Integer id);
	public E guardar (E entidad);
	public Iterable<E> buscarTodos();
	public void eliminarPorId(Integer id);
}
