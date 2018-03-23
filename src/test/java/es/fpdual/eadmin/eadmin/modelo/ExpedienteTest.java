package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Test;

public class ExpedienteTest {
	
	private static final Integer CODIGO_EXPEDIENTE = 1;
	private static final String  NOMBRE_EXPEDIENTE = "nombre";
	private static final Date FECHA_ARCHIVADO = new Date();
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean EXPEDIENTE_PUBLICO = true;
	
	final	Expediente expediente = new Expediente(CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_ARCHIVADO,FECHA_CREACION,EXPEDIENTE_PUBLICO,EstadoExpediente.INICIADO, null);
	
	
	
	@Test
	
	public void deberiaComprobarGetters() {
		
		assertEquals(Integer.valueOf(CODIGO_EXPEDIENTE),expediente.getCodigo());
		assertEquals(NOMBRE_EXPEDIENTE, expediente.getNombre());
		assertEquals(FECHA_CREACION, expediente.getFechaCreacion());
		assertEquals(EXPEDIENTE_PUBLICO, expediente.getPublico());
	
		
		@Test
		public void  deberiaComprobarToString() {
			
			equals( "Expediente codigo=" + expediente.getCodigo() + ", nombre=" + expediente.getNombre() + ", fechaCreacion=" + expediente.getFechaCreacion()
					+ ", fechaArchivado=" + expediente.fechaArchivado() + ", publico=" + expediente.getPublico() + ", estado=" + expediente.getEstado() + ", documentos="
					+ expediente.getDocumentos());
		}
		
	}
	
	
}

