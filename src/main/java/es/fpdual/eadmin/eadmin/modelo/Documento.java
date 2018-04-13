package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {

	
	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Boolean publico;
	private EstadoDocumento estado;

	
	
	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, publico);
		this.estado = estado;

	}
	

	public Object obtenerDocumentoPorCodigo(int i) {
		
		return null;
	}


	public Object[] getFechaUltimaModificacion() {

		return this.getFechaUltimaModificacion();
	}	
}