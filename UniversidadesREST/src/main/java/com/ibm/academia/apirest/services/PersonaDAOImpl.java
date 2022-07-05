package com.ibm.academia.apirest.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
@Service
public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO
{
@Autowired
	public PersonaDAOImpl(PersonaRepository repository)
	{
		super(repository);
	}

	@Override
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) 
	{
			return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	public Optional<Persona> buscarPorDni(String dni)
	{
		return repository.buscarPorDni(dni);
	}

	@Override
	public Iterable<Persona> buscarPersonaPorApellido(String apellido) 
	{
		return repository.buscarPersonaPorApellido(apellido);
	}
}
