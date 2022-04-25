package com.microservices.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservices.springboot.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> { // Se indica nombre de la entidad y el tipo de la
																		// clave primaria // Vamos a hacer uso de los
																		// métodos predefinidos de la clase
																		// CrudRepository

}
