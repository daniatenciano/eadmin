package es.fpdual.eadmin.eadmin.servicioss.Impl;

import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicioss.ServicioDocumentoo;

@Service
public  class ServicioDocumentoImpl implements ServicioDocumentoo {

	private static final Documento DOCUMENTO = mock(Documento.class);

//	private ServicioDocumento servicioDocumento;

	private RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {

		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documento);
		
		return documentoModificado;
		
		
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoModificado =
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.modificarDocumento(documentoModificado);
		
		return documentoModificado;
		
		
	}

	private Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
		return new Documento(documento.getCodigo(),
				documento.getNombre(),
				dameFechaActual(),
				documento.getPublico(),
				documento.getEstado());
	}

	protected static Date dameFechaActual() {
		return new Date();

	}

	

	@Override
	public void eliminarDocumento(Integer codigo) {

		repositorioDocumento.eliminarDocumento(codigo);
		
	}
}