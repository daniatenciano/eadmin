package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DocumentoRegistroTest {
	
	private String dniInteresado;
	private String codigoRegistro;
	private DocumentoRegistro documentoRegistro;
	
	@Before
	public void inicializarNuevoDocumentoRegistro() {
		documentoRegistro = new DocumentoRegistro(null, dniInteresado, null, null, null, codigoRegistro, codigoRegistro);
		
	}
	
	@Test
	public void deberiaComprobarGetterDniInteresado() {
		
		assertEquals(documentoRegistro.getDniInteresado(),this.dniInteresado);
		
	}
	
	@Test
	public void deberiaComprobarGetterCodigoRegistro() {
		assertEquals(documentoRegistro.getCodigoRegistro(),this.codigoRegistro);
		

	}
	
	@Test
	public void deberiaComrpobarToString() {
		assertEquals("DocumentoRegistro [dniInteresado=" + documentoRegistro.getDniInteresado() + ", codigoRegistro=" + documentoRegistro.getCodigoRegistro() + "]",documentoRegistro.toString());
	}
	
	
	
}
