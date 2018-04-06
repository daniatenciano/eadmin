package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioDocumento {
	
	public abstract void altaDocumento(Documento documento);
	
	public abstract void modificarDocumento(Documento documento);
	
	public abstract void eliminarDocumento(Integer codigodoc);
	
	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);
	
	public abstract List<Documento> obtenerTodosLosDocumentos();

	public abstract void archivoDocumentoarchivo();

	public abstract void altaExpediene(Expediente expediente);
	
	
	
	

}