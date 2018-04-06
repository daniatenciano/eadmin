package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	public abstract void altaDocumento(Expediente expediente);
	public abstract void modificarDocumento(Expediente expediente);
	public abstract void eliminarDocumento(Integer codigo);
	public abstract void eliminarArchivoDocumento(Expediente expediente);
	public abstract void RepositorioExpediente(Expediente expediente);
	String archivoModificarTxt(Expediente expediente);
	String eliminarDocumentoTxt(Expediente expediente);
	String altaDocumentoTxt(Expediente expediente);
	
}

