package es.fpdual.eadmin.eadmin.controlador;

import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicioss.ServicioDocumentoo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;



public class ControladorEadminTest {
	
	ServicioDocumentoo servicioDocumento = mock(ServicioDocumentoo.class);
	ControladorEadmin controlador;
	
	@Before
	public void incializarEnCadaTest() {
		this.controlador = new ControladorEadmin(servicioDocumento);
	}
	
	
	@Test
	public void deberiaDevolverTodosLosDocumentos() {
	
		final List<Documento> documentos = new ArrayList<>();
		when(this.servicioDocumento.obtenerTodosLosDocumentos()).thenReturn(documentos);	
		List<Documento> resultado = this.controlador.getTodosDocumentos().getBody();
		assertEquals(resultado,documentos);
	}

//	@Test
//	public void deberiaEliminarUnDocumento() {	
//		final List<Documento> documentos = new ArrayList<>();
//		
//		Documento documento = mock(Documento.class);
//		
//		when(documento.getCodigo()).thenReturn(1);
//		
//		List<Documento> resultado = this.controlador.getTodosDocumentos().getBody();
//		
//		assertEquals(resultado, documento);
//		
//	}

}
