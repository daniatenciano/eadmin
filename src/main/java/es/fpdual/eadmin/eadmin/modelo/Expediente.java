package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloBaseAdministracionElectronica {
	
	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaArchivado;
	private Boolean publico;
	private EstadoExpediente estado;
	private List<Documento> documentos;

	
	

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado, List<Documento> documentos) {
	    super(codigo,nombre,fechaCreacion,publico);
	    this.estado = estado;
		this.fechaArchivado = fechaArchivado;
		this.documentos = documentos;
	}


	public Expediente(Integer codigoExpediente, Date fechaCreacion2, Date fechaArchivacion, String nombre2,
			Boolean documentoPublico, EstadoExpediente enTramite, List<Documento> documento,
			Date fechaUltimaModificacion) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Expediente codigo=" + codigo + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", fechaArchivado=" + fechaArchivado + ", publico=" + publico + ", estado=" + estado + ", documentos="
				+ documentos;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Expediente) {
			return codigo.equals(((Expediente)obj).getCodigo()) && nombre.equals(((Expediente)obj).getNombre()) && fechaCreacion.equals(((Expediente)
obj).getFechaCreacion()) && fechaArchivado.equals(((Expediente)obj).getFechaCreacion()) && publico.equals(((Expediente)obj).getPublico())
            	&& estado.equals(((Expediente)obj).getEstado());	
					
		}
		return false;
	}
		
		
	@Override
	public int hashCode() {
		return codigo.hashCode()+nombre.hashCode()+fechaCreacion.hashCode()+fechaArchivado.hashCode()+publico.hashCode()+estado.hashCode()
		+ documentos.hashCode();
		
	}


	public String fechaArchivado() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getDocumentos() {
		
		return null;
	}


	public Object indexOf(Expediente expediente) {

		return null;
	}
}