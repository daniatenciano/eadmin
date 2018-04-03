package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicioss.ServicioDocumentoo;

@Service
public  class ServicioDocumentoImpl implements ServicioDocumentoo {


//	private ServicioDocumento servicioDocumento;

	private RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {

		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
		
		
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoModificado =
				obtenerDocumentoConFechaUltimaActualizacion(documento);
		
		repositorioDocumento.modificarDocumento(documentoModificado);
		
		return documentoModificado;
		
		
	}

	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
//		return new Documento(documento.getCodigo(),
//				documento.getNombre(),
//				dameFechaActual(),
//				documento.getPublico(),
//				documento.getEstado());
		
//		return new DocumentoBuilder().conCodigo(documento.getCodigo()).conNombre(documento.getNombre()).conFechaCreacion(dameFechaActual()).
//									conPublico(documento.getPublico()).conEstadoDocumento(documento.getEstado()).construir();
		 
		return  new DocumentoBuilder().clonar(documento).conFechaCreacion(dameFechaActual()).construir();
	}
	
	protected Documento obtenerDocumentoConFechaUltimaActualizacion(Documento documento) {
		
		return new DocumentoBuilder().clonar(documento).conFechaUltimaActualizacion(dameFechaActual()).construir();
	}

	protected static Date dameFechaActual() {
		return new Date();

	}

	

	@Override
	public void eliminarDocumento(Integer codigo) {

		repositorioDocumento.eliminarDocumento(codigo);
		
	}
	
	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
		return resultado;
	}
	
	@Override
	public List<Documento>obtenerTodosLosDocumentos() {
		return repositorioDocumento.obtenerTodosLosDocumentos();
	}

}