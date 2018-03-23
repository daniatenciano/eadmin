package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	public abstract void altaDocumento(Expediente expediente);
	public abstract void modificarDocumento(Expediente expediente);
	public abstract void eliminarDocumento(Integer codigo);

}
