package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class RepositorioExpedienteImpl implements RepositorioExpediente {
	
	
	private List<Expediente> expediente = new ArrayList();
	
	
	public List<Expediente> getExpediene() {
		return expediente;
	}
	
	@Override
	public void altaDocumento(Expediente expediente) {
		
		if(expediente.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya se encuentra en la lista");
		}
		
		expediente.add(expediente);
	}
	
	@Override
	public void modificarDocumento(Expediente expediente) {
		
		if(expediente.contains(expediente)) {
			throw new IllegalArgumentException("El expediente que quieres modificar no existe");
		}
		
		expediente.set(expediente.indexOf(expediente),expediente);
	}
	
	@Override
	public void eliminarDocumento(Integer codigo) {
		
		Optional<Expediente> expedienteEncontrado = expediente.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst();
		
		if(expedienteEncontrado.isPresent()) {
			expediente.remove(expedienteEncontrado.get());
		}
	}

	protected static boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}
	
}

	
	
