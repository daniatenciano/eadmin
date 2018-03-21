package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ModeloBaseAdministracionElectronicaTest {
	
	class ModeloBaseAdministracionElectronicaFake extends ModeloBaseAdministracionElectronica {

		public ModeloBaseAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Boolean publico) {
			super(codigo, nombre, fechaCreacion, publico);
		}
		
	}
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final Date  FECHA_CREACION = new Date();
	private static final String NOMBRE = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	

	
	ModeloBaseAdministracionElectronicaFake modelo = new ModeloBaseAdministracionElectronicaFake(CODIGO_DOCUMENTO,NOMBRE,
			FECHA_CREACION,DOCUMENTO_PUBLICO);
	
	

	@Before
	@Test
	public void deberiaProbarGetters() {
		
		assertEquals(Integer.valueOf(CODIGO_DOCUMENTO),modelo.getCodigo());
		assertEquals(NOMBRE, modelo.getNombre());
		assertEquals(FECHA_CREACION, modelo.getFechaCreacion());
		assertEquals(DOCUMENTO_PUBLICO, modelo.getPublico());
	}
	
	
	
	@Before
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		
		ModeloBaseAdministracionElectronicaFake modelo1 = new ModeloBaseAdministracionElectronicaFake(CODIGO_DOCUMENTO,null,null,null);
		
		assertEquals(false,modelo.equals(modelo1));
		
	}
	
	@Before
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		
   	ModeloBaseAdministracionElectronicaFake modelo2 = new ModeloBaseAdministracionElectronicaFake(5, null,null,null);
		
		final Boolean resultado = modelo.equals(modelo2);
		
		assertFalse(resultado);
	}

	
}