package com.microservices.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.springboot.app.productos.models.dao.ProductoDao;
import com.microservices.springboot.app.productos.models.entity.Producto;

@Service // Marca/registra esta clase como un componente/bean de Spring
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll(); // hacemos casting pues el método devuelve una lista
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null); // al buscar por ID, devuelve un opcional(valora si encuentra
														// objeto o no) // si lo hace lo devuelve, en caso contrario,
														// devuelve null
	}
}