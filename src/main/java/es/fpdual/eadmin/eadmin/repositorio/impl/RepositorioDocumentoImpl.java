package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.ModeloBaseAdministracionElectronica;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private static List<Documento> documentos = new ArrayList<>();
	RepositorioDocumento repositorioDocumento;
	static ModeloBaseAdministracionElectronica documento;

	static String nombreFichero = "log.txt";
	File file = new File(nombreFichero);
	

	public List<Documento> getDocumento() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando en alta Documento");
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		documentos.add(documento);
		logger.info(" Documento con código " + documento.getCodigo() + " creado correctamente ");
		logger.info("Saliendo de alta Documento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entrando en modificar Documento");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar ya existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
		logger.info("Saliendo de modificar Documento");
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando en eliminar Documento");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
			logger.info("Saliendo de eliminar Documento");
		}

	}

	// Documento documentoEncontrado = documentos.stream().filter(d ->
	// tieneIgualCodigo(d,codigo))
	// .findFirst().orElseGet(null);
	//
	// if(Objects.nonNull(documentoEncontrado))
	// {
	// documentos.remove(documentoEncontrado);
	// }

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entrando en Obtener Documento por Código");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		logger.info("Saliendo de Obtener Documento por Código");
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrando en ObtenerTodosLosDocumentos");
		for (Documento documento : documentos) {
			logger.info("********************************************");
			logger.info(" El documento código: " + documento.getCodigo() + " Nombre: " + documento.getNombre()
					+ " Fecha Creacion: " + documento.getFechaCreacion() + "  Estado: " + documento.getEstado() + " ");

			logger.info("**********************************************");
		}
		logger.info("Saliendo de Obtener Todos los Documentos");
		return documentos;
	}

	protected static boolean tienenIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	
	static void archivoDocumento(Documento documento) {
		String nombreFichero = "log.txt";
		FileWriter fw;
		PrintWriter writer = null;
		
		try {
			fw = new FileWriter(nombreFichero,true);
			writer = new PrintWriter(fw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (Documento doc : documentos) {
			writer.println(" El documento código: " + documento.getCodigo() + " Nombre: " + documento.getNombre()
					+ " Fecha Creacion: " + documento.getFechaCreacion() + "  Estado: " + documento.getEstado() + " ");

			writer.close();
		}

	}
	
	
	static void altaDocumento() {
		
	}

	
	
	static void modificarDocumento() {
		
	}
	
	
	
	static void eliminarDocumento() {
		
//		RepositorioDocumento repositorio = new RepositorioDocumento();
		String nombreFichero = "log.txt";
		FileWriter fw;
		PrintWriter writer = null;
		
		try {
			fw = new FileWriter(nombreFichero,true);
			writer = new PrintWriter(fw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (Documento doc : documentos) {
			
			writer.println(" El documento código: " + documento.getCodigo() + " Nombre: " + documento.getNombre()
					+ " Fecha Creacion: " + documento.getFechaCreacion() + "  Estado: " + documento.getEstado() + " ");

			writer.close();
		
		}
	
	}
	
	
	@Override
	public void archivoDocumentoarchivo() {
		
	}

}