package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;


@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();
	
	@Override
	public void altaDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
		   throw new IllegalArgumentException("El documento ya existe");
		}
		
		documentos.add(documento);			
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar ya existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
		
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		
		Documento documetoEncontrado = null;
		
		for (int i = 0; i< documentos.size(); i++) {
			if(documentos.get(i).getCodigo().equals(codigo)) {
				 documetoEncontrado = documentos.get(i);
				break;
			}
			
		}
	
		if (Objects.nonNull(documetoEncontrado)) {
			documentos.remove( documetoEncontrado);	
		}
			
		}

	}