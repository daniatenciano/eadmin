package es.fpdual.eadmin.eadmin;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;


@Component

public class CargarDatosIniciales implements ApplicationRunner {


	public final RepositorioDocumento repositorioDocumeto;
	private static final Date Fecha = new Date();


	@Autowired

	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento) {

		this.repositorioDocumeto = repositorioDocumento;

	}


	@Override

	public void run(ApplicationArguments args) throws Exception {

	
		Documento documento = new Documento(1, "Documento1", Fecha, true, EstadoDocumento.ACTIVO);
		
		Documento documento2 = new Documento(2, "Documento2", Fecha, true, EstadoDocumento.APROBADO);

		this.repositorioDocumeto.altaDocumento(documento);

		this.repositorioDocumeto.altaDocumento(new Documento(3, "Documento3", Fecha, false, EstadoDocumento.ACTIVO));

		this.repositorioDocumeto.altaDocumento(new Documento(4, "Documento4", Fecha, true, EstadoDocumento.APROBADO));

		RepositorioDocumentoImpl.archivarTodosLosDocumentos(this.repositorioDocumeto.obtenerTodosLosDocumentos());

		this.repositorioDocumeto.modificarDocumento(documento);

	}
}