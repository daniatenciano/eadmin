package es.fpdual.eadmin.eadmin.servicioss;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumentoo {
	
	Documento altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);
	
	void eliminarDocumento(Integer codigo);

	

}
