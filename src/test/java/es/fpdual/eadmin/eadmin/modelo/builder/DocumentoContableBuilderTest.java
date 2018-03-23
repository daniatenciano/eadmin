package es.fpdual.eadmin.eadmin.modelo.builder;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilderTest {
	
	private DocumentoContable documento;
	
	@Before

	
	@Test
	public void deberiaComprobarDocumentoContable() {
		Documento documento = new DocumentoBuilder().conCodigo(1).conNombre("nombre").conFechaCreacion(null).conPublico(null).conEstadoDocumento(null).conFechaCreacion(null).construir();
				
	}
	
}