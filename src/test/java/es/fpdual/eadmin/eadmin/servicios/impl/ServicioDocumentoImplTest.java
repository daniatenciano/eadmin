package es.fpdual.eadmin.eadmin.servicios.impl;

//import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
//import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicioss.ServicioDocumentoo;
import es.fpdual.eadmin.eadmin.servicioss.Impl.ServicioDocumentoImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;


public class ServicioDocumentoImplTest {
//	private static final Documento DOCUMENTO = null;
	private Date fechaCreacion = new Date();
	private Boolean publico = true;
	private ServicioDocumentoo servicioDocumento;
	private static final Integer codigoDoc = 1;

	Documento documento1 = new Documento(1, "nombre", fechaCreacion, publico, EstadoDocumento.ACTIVO);

	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	
	private static final Documento DOCUMENTO = mock(Documento.class);
	
//	private RepositorioDocumento repositorioDocumento1 = mock(RepositorioDocumento.class);

	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);

	}

	@Test
	public void deberiaAlmacenarUnDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);	
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(15/4/2018));
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);
		verify(this.repositorioDocumento).altaDocumento(DOCUMENTO);
		assertEquals(resultado.getCodigo(), DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(), DOCUMENTO.getNombre());
		assertNotEquals(resultado.getFechaCreacion(),DOCUMENTO.getFechaCreacion());

	
	}
	
	@Test
	public void deberiaModificarDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(any());
		assertEquals(Integer.valueOf(1), resultado.getCodigo());
		assertEquals("nombre",resultado.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), DOCUMENTO.getFechaCreacion());
		
		
	}
	
	
	@Test
	public void deberiaEliminarDocumento()  {
		
		when(DOCUMENTO.getCodigo()).thenReturn(codigoDoc);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(codigoDoc);
	}

}
