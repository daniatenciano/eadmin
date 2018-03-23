package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoPropuestaTest {
	
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final BigDecimal IMPORTE = new BigDecimal(0.01);
	private static final Integer DOCUMENTO_EJERCICIO = 1;
	
	
//	DocumentoPropuestaTest documento = new DocumentoPropuestaTest(FECHA_CREACION,NOMBRE_DOCUMENTO, DOCUMENTO_PUBLICO,CODIGO_DOCUMENTO,
//			CODIGO_DOCUMENTO,IMPORTE,DOCUMENTO_EJERCICIO);

	
	@Test
	public void deberiaCrearUnObjeto () {
		DocumentoPropuesta documento =  new DocumentoPropuesta (null, null, null, null, null,null,null);
	}

	
	
}
