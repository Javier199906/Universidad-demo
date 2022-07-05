package com.ibm.academia.apirest.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.apirest.exceptions.BadRequestExeption;

@ControllerAdvice
public class UniversidadRESTException 
{
	@ExceptionHandler(value = BadRequestExeption.class)
	public ResponseEntity<Object> formatoInvalidoException(BadRequestExeption exception)
	{
	 Map<String, Object> respuesta = new HashMap<String, Object>();
	 respuesta.put("Error", exception.getMessage());
	 return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
}
