package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

public class ExpedienteTest {
	
	private static final Integer CODIGO_EXPEDIENTE = 1;
	private static final String  NOMBRE_EXPEDIENTE = "nombre";
	private static final Date FECHA_ARCHIVADO = new Date();
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean EXPEDIENTE_PUBLICO = true;
	
	final	Expediente expediente = new Expediente(CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_ARCHIVADO,FECHA_CREACION,EXPEDIENTE_PUBLICO,EstadoExpediente.INICIADO);
	
	
	
	
	
	
	
	
	
	

	
	@Test
	
	public class deberiaComprobarGetters() {
		
		
		
	}
	

}
