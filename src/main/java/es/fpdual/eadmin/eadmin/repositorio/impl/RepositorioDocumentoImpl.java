package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {

		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		documentos.add(documento);
		System.out.println(" aEl "+documento.getNombre()+" se ha introducido");
	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar ya existe");
		}
		documentos.set(documentos.indexOf(documento), documento);

	}

	public List<Documento> getDocumentos() {
		return documentos;
	}
	
	@Override
	public void eliminarDocumento(Integer codigo) {

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
		}

	}

//	 Documento documentoEncontrado = documentos.stream().filter(d ->
//	 tieneIgualCodigo(d,codigo))
//	 .findFirst().orElseGet(null);
//	
//	 if(Objects.nonNull(documentoEncontrado))
//	 {
//	 documentos.remove(documentoEncontrado);
//	 }
	

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst();
		
		if(documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {

		return documentos;
	}

}