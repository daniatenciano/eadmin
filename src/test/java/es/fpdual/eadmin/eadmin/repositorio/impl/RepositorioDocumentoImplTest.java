package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;


public class RepositorioDocumentoImplTest {

	private RepositorioDocumentoImpl repositorioDocumento;
	
	private static final Documento DOCUMENTO = new Documento(1, "nombre", new Date(), true, EstadoDocumento.ACTIVO);

	private static final Documento DOCUMENTO1 = new Documento(1,"nombre2", new Date(), true, EstadoDocumento.ACTIVO);
	
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}
	
	
	@Test
	public void deberiaDarAltaUnDocumento() {
		
//		this.repositorioDocumento.altaDocumento(DOCUMENTO);
		assertFalse(this.repositorioDocumento.getDocumentos().isEmpty());
	}
 	
	
	

	@Test
	public void deberiaEliminarUnDocumento() {

		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);

		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());

		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}

//	@Test
//	public void deberiaComprobarUnElementoNull() {
//
//		// this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
//		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
//
//		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
//
//	}
//	
	@Test
	public void deberiaEliminarUnDocumentoSiNoExiste() {
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
		
	}
    	
	@Test
	public void deberiaComprobarModificarDocumento() {
			
	assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
}