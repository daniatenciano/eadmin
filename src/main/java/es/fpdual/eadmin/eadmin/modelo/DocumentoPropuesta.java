package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {
	
	private Integer codigo;
	private Integer ejercicio;
	private String grupoPolitico;
	
	public DocumentoPropuesta(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			EstadoDocumento estado, Integer ejercicio, String grupoPolitico ) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.codigo = codigo;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}

	
	@Override
	public String toString() {
		return "DocumentoPropuesta [codigo=" + codigo + ", ejercicio=" + ejercicio + ", grupoPolitico=" + grupoPolitico
				+ "]";
	}
	
	
	

}
