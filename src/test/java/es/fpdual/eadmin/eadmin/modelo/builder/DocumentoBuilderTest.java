package es.fpdual.eadmin.eadmin.modelo.builder;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public class DocumentoBuilderTest {
	
	private Documento documento;
	
	@Before
	public void deberiaCrearDocumento() {
		Documento documento = new DocumentoBuilder().conCodigo(1).conNombre("nombre").conFechaCreacion(null).conPublico(null).conEstadoDocumento(null).conFechaCreacion(null).construir();
	}
	
	@Test
	public void deberiaComprobarDocumento(Documento documento) {
		new DocumentoBuilder().clonar(documento);
		
	}
		
}
