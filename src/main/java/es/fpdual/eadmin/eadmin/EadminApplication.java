package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioExpediente;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LoggerFactory.getLogger(EadminApplication.class);
	private static final Date Fecha = null;

	public final RepositorioDocumento repositorioDocumento = null;
	public final RepositorioExpediente repositorioExpediente = null;

	Expediente expediente1 = new Expediente(1, "expediente1", Fecha, Fecha, true, EstadoExpediente.INICIADO, null);
	Expediente expediente2 = new Expediente(2, "expediente2", Fecha, Fecha, false, EstadoExpediente.EN_TRAMITE, null);

	public static void main(String[] args) {

		logger.info("Esto es una prueba");

		// Debug.
		logger.debug("Depuración");

		// Info.
		logger.info("Informacion");

		// Trace.
		logger.trace("Traza");

		// Warning.
		logger.warn("Advertencia");

		// Error.
		logger.error("Error");

		logger.info("Inicio run");

		SpringApplication.run(EadminApplication.class, args);

		logger.info("Fin run");

	}

}