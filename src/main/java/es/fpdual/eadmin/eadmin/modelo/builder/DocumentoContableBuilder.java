package es.fpdual.eadmin.eadmin.modelo.builder;

import java.math.BigDecimal;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilder extends DocumentoBuilder {
	
	protected BigDecimal importe;
	protected String DniInteresado;
	
	@Override
	public DocumentoContable construir() {
		return new DocumentoContable(this.codigo,this.nombre,this.fechaCreacion,this.publico,this.estado,importe,DniInteresado); 
	}
	
	public DocumentoContableBuilder conImporte(BigDecimal importe) {
		this.importe = importe;
		return this;
	}
	
	public DocumentoContableBuilder conNifIntersado(String nifInteresado) {
		this.DniInteresado = nifInteresado;
		return this;
	}
	
	public DocumentoContableBuilder clonar(DocumentoContable documentoContable) {
		super.clonar(documentoContable);
		this.importe = documentoContable.getImporte();
		this.DniInteresado = documentoContable.getDniInteresado();
		return this;
	}

}
