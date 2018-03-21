package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DocumentoTest {
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	final	Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO ,FECHA_CREACION,DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO);
	
	@Test
	public void deberiaComprobarGetters() {
		
	
		assertEquals(Integer.valueOf(CODIGO_DOCUMENTO), documento.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO,documento.getNombre());
		assertEquals(FECHA_CREACION, documento.getFechaCreacion());
		assertEquals(DOCUMENTO_PUBLICO, documento.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, documento.getEstado());
		
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		
		final	Documento documento2 = new Documento(5, null,null,null,null);
		
		final Boolean resultado = documento2.equals(documento);
		
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final Boolean resultado = documento.equals("Prueba");
		assertFalse(resultado);
	}
	
	
//	@Test
//	public void probarElMetodoToString() {
//		
//		assertEquals("Documento con codigo"+1,documento.toString());
//	}
	

}
