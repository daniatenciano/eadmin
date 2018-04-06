package es.fpdual.eadmin.eadmin.servicioss;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumentoo {

	Documento altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);

	void eliminarDocumento(Integer codigo);

	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);

	public abstract List<Documento> obtenerTodosLosDocumentos();

}
