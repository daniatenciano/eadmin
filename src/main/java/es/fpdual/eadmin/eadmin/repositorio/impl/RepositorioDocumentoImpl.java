package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.ModeloBaseAdministracionElectronica;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public abstract class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private static List<Documento> documentos = new ArrayList<>();
	RepositorioDocumento repositorioDocumento;
	static ModeloBaseAdministracionElectronica documento;
	private static final RepositorioDocumentoImpl rep = new RepositorioDocumentoImpl();

	static String nombreFichero = "log.txt";
	File file = new File(nombreFichero);

	public List<Documento> getDocumento() {

		return documentos;

	}

	@Override

	public void altaDocumento(Documento documento) {

		logger.info("Entrado en el metodo : " + rep.getNombreMetodo());

		if (documentos.contains(documento)) {// si existe el documento pues no entra.

			throw new IllegalArgumentException("El documento ya existe");

		}

		rep.documentoTXTAlta(documento);
		documentos.add(documento);
		logger.info("{} creado correctamente", documento.toString());
		logger.info("Saliendo del metodo : " + rep.getNombreMetodo());

	}

	public String documentoTXTAlta(Documento documento) {
		FileWriter fw = null;
		PrintWriter pw = null;
		String nFichero = "Alta.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);
			pw.println(documento);
			pw.close();

		} catch (IOException e) {

			e.printStackTrace();
			pw.close();
		}

		return "Fichero Guardado";

	}

	public String getNombreMetodo() {
		// Retorna el nombre del metodo desde el cual se hace el llamado
		return new Exception().getStackTrace()[1].getMethodName();

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
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Documento doc : documentos) {
			writer.println(" El documento código: " + documento.getCodigo() + " Nombre: " + documento.getNombre()
					+ " Fecha Creacion: " + documento.getFechaCreacion() + "  Estado: " + documento.getEstado() + " ");

			writer.close();
		}

	}

	public String altaDocumentoTxt(Documento documento) {
		FileWriter fw = null;
		PrintWriter pw = null;
		String nFichero = "Alta.txt";

		try {

			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);
			pw.println(documento);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		return "Fichero Guardado";

	}

	public String archivoModificarTxt(Documento documento) {

		FileWriter fw = null;
		PrintWriter pw = null;
		String nFichero = "Moficiar.txt";

		try {

			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);
			pw.println(documento);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

	public String eliminarDocumentoTxt(Documento documento) {

		FileWriter fw = null;
		PrintWriter pw = null;
		String nFichero = "Eliminar.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);
			pw.println(documento);
			pw.close();

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

	public static void archivarTodosLosDocumentos(List<Documento> documentos) {

		String nombreFichero = "documentos.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		for (Documento doc : documentos) {

			writer.println("************");

			writer.println("Codigo: " + doc.getCodigo());

			writer.println("Nombre: " + doc.getNombre());

			writer.println("Fecha Creacion " + doc.getFechaCreacion());

			writer.println("Publico: " + doc.getPublico());

			writer.println("Estado: " + doc.getEstado());

			writer.println("Fecha UltimaModificación: " + doc.getFechaUltimaModificacion());

			writer.println("************");
		}
		writer.close();

	}

	protected void exportar(Documento documento, String ruta) {

		BufferedWriter bw = null;
		FileWriter fl = null;
		File archivo = new File(ruta);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Mi hoja");
		HSSFRow nombreFila = sheet.createRow(0);
		HSSFCell cell = null;
		String[] titulos = { "Documentos.ID", "Nombre", "Fecha Creacion", "Publico", "Estado",
				"Fecha Ultima Modificacion" };

		for (int j = 0; j < titulos.length; j++) {
			cell = nombreFila.createCell(j);
			cell.setCellValue(titulos[j]);
		}

		HSSFRow nombreFila = sheet.createRow(1);
		cell = nombreFila.createCell(0);
		cell.setCellValue(documento.getCodigo());
		cell = nombreFila.createCell(1);
		cell.setCellValue(documento.getNombre());
		cell = nombreFila.createCell(2);
		cell.setCellValue(documento.getFechaCreacion(), toString());
		cell = nombreFila.createCell(3);
		cell.setCellValue(documento.getPublico());
		cell = nombreFila.createCell(4);
		cell.setCellValue(documento.getEstado(), toString());
		cell = nombreFila.createCell(5);
		cell.setCellValue(documento.getFechaUltimaModificacion(), toString());

		try {

			// Creamos el flujo de salida de datos,
			// apuntamos el archivo donde queremos almacenar el libro Excel

			FileOutputStream salida = new FileOutputStream(archivo, true);

			// Almacenamos el libro Excel via ese, flujo de datos
			workbook.write(salida);

			// Cerramos el libro para concluir operaciones
			workbook.close();

		} catch (FileNotFoundException ex) {
			System.out.println("ERROR!");
		} catch (IOException ex) {
			System.out.println("ERROR!");
		}

		Integer numeroLineas = 0;

		// Datos a escribir en map(Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		// Cabecera
		File archivoExcel = new File("FPdUAL.xlsx");
		if (!archivoExcel.exists()) {
			data.put("0", new Object[] { "ID", "PC", "NOMBRE", "APELLIDOS" });
			numeroLineas = 1;

		} else {
			ArrayList<String[]> datoExcel = ImportExcel.importExcel("FPDual.xlsx", 4);
			List<Documento> datosExcel;
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				data.put(numeroLineas.toString(), datos);
			}
		}
	}
}