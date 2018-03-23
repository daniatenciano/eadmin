package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class DocumentoContableTest {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final BigDecimal IMPORTE = new BigDecimal(0.01);
	private static final String DNI_INTERESADO = "987654321M";

	final DocumentoContable documentoContable = new DocumentoContable(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO,
			FECHA_CREACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO, IMPORTE, DNI_INTERESADO);

	@Test
	public void comprobarLosGettersdeDocumentoContable() {
		documentoContable.getImporte();
		documentoContable.getDniInteresado();

	}

	@Test
	public void comprobarelNOMBRE_DOCUMENTO() {
		documentoContable.getNombre();

	}
	
	@Test
	public void comprobarToString() {
		assertEquals( "DocumentoContable [importe=" + documentoContable.getImporte() + ", dniInteresado=" + documentoContable.getDniInteresado()+ "]", documentoContable.toString());
	}
	
}
