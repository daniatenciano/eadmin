package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicioss.ServicioDocumentoo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


public class ServicioDocumentoImplTest {
//	private static final Documento DOCUMENTO = null;
	private Date fechaCreacion = new Date();
	private Boolean publico = true;
	private ServicioDocumentoImpl servicioDocumento;
	private static final Integer codigoDoc = 1;


	Documento documento1 = new Documento(1, "nombre", fechaCreacion, publico, EstadoDocumento.ACTIVO);

	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	
	private static final Documento DOCUMENTO = mock(Documento.class);
	
//	private RepositorioDocumento repositorioDocumento1 = mock(RepositorioDocumento.class);

	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = spy (new ServicioDocumentoImpl(repositorioDocumento));

	}

	@Test
	public void deberiaAlmacenarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaCorrecta(DOCUMENTO);		
		this.servicioDocumento.altaDocumento(DOCUMENTO);
		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
			
	}
	
//	@Test
//	public void deberiaModificarDocumento() {
//		
//		final Documento documentoModificado = mock(Documento.class);
//		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaCorrecta(DOCUMENTO);	
//		this.servicioDocumento.modificarDocumento(DOCUMENTO);	
//		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
//		
//	}
	
	
	@Test
	public void deberiaEliminarDocumento()  {
		
		when(DOCUMENTO.getCodigo()).thenReturn(codigoDoc);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(codigoDoc);
	}

	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		when(repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		final Documento resultado = this.servicioDocumento.obtenerDocumentoPorCodigo(1);
		assertEquals(resultado, DOCUMENTO);
	}
	
	@Test
	public void deberiaOtenerTodosLosDocumentos() {
		
		final List<Documento> documentos = new ArrayList<>();
		
		when(repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(documentos);
		
		final List<Documento> resultado = this.servicioDocumento.obtenerTodosLosDocumentos();
		assertSame(documentos,resultado);
		
	}
	
	@Test
	public void TestDocumentoFechaCorrecta() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaCorrecta(DOCUMENTO);
		final Documento resultado = servicioDocumento.altaDocumento(DOCUMENTO);
		verify (repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(resultado,documentoModificado);
	}

	@Test
	public void deberiaModificarDocumentoFechaCorrecta() {
		final Documento documentoModificado = mock(Documento.class);
		
		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaUltimaActualizacion(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado,documentoModificado);
	}
}
