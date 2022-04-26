package com.microservices.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity // Para configurar la clase como JPA -> Anotamos con Entity para indicar que es
		// una entidad relacional
@Table(name = "productos") // Indicamos la tabla sobre la cual dicha entidad hace mapeo. Si no se indica,
							// la tabla tendrá el nombre de la CLASE
@Data // Para generar GETTER Y SETTER
public class Producto implements Serializable {

	/**
	 * Es buena práctica implementar la interfaz serializable Esta convierte el
	 * objeto en bytes, algo muy útil para guardar nuestro objeto ENTITY en una
	 * sesión HTTP, archivo de texto ...
	 */
	private static final long serialVersionUID = -7446703115949698511L;

	@Id // Indicamos que es la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	private Long id;

	// Estas columnas no necesitan ser mapeadas, excepto cuando no se nombrarán
	// igual tanto
	// en la CLASE(atributo) como en la TABLA(campo)
	private String nombre;
	private Double precio;

	@Column(name = "creado_en") // Este campo sí deberá mapearse
	@Temporal(TemporalType.DATE) // Indicar formato de fecha
	private Date creadoEn;

	@Transient // Indica que el atributo no es persistente, no está mapeado con ningún campo de
				// la base de datos
	private Integer port;
}