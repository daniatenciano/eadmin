package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpedienteImpl;
import org.junit.Before;
import org.junit.Test;

public class RepositorioExpedienteImplTest {
	
	private RepositorioExpedienteImpl repositorioExpediente;
	private static final Integer CODIGO_EXPEDIENTE = 1;
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ARCHIVACION = new Date();
	private static final String NOMBRE = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static List<Documento> documento;
	private static final Date FECHA_ULTIMA_MODIFICACION = new Date();
	
	Expediente expediente = new Expediente (CODIGO_EXPEDIENTE,FECHA_CREACION,FECHA_ARCHIVACION,NOMBRE,DOCUMENTO_PUBLICO,EstadoExpediente.EN_TRAMITE,documento,FECHA_ULTIMA_MODIFICACION);
	
	
	
	@Before
	public void inicializarCadaTest() {
		this.repositorioExpediente = new RepositorioExpedienteImpl();
	}
	
	@Test
	public void deberiaDarAltaUnExpediente() {
		this.repositorioExpediente.altaExpediente(expediente);
		assertFalse(this.repositorioExpediente.getExpediente().isEmpty());
	}
	


}