package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.modelo.ModeloBaseAdministracionElectronica;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private static List<Documento> documentos = new ArrayList<>();
	RepositorioDocumento repositorioDocumento;
	static ModeloBaseAdministracionElectronica documento;
	private static final RepositorioDocumentoImpl rep = new RepositorioDocumentoImpl();
	Documen

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
		exportExcel("Alta", documento, "documento.xls");

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
			e.printStackTrace();

		}

		for (Documento doc : documentos) {

			writer.println("***************");

			writer.println("Codigo: " + doc.getCodigo());

			writer.println("Nombre: " + doc.getNombre());

			writer.println("Fecha Creacion " + doc.getFechaCreacion());

			writer.println("Publico: " + doc.getPublico());

			writer.println("Estado: " + doc.getEstado());

			writer.println("Fecha UltimaModificación: " + doc.getFechaUltimaModificacion());

			writer.println("**************");
		}
		writer.close();

	}

	// protected void exportar(Documento documento, String ruta) {
	//
	// BufferedWriter bw = null;
	// FileWriter fl = null;
	// File archivo = new File(ruta);
	// HSSFWorkbook workbook = new HSSFWorkbook();
	// HSSFSheet sheet = workbook.createSheet("Mi hoja");
	// HSSFRow nombreFila = sheet.createRow(0);
	// HSSFCell cell = null;
	// String[] titulos = { "Documentos.ID", "Nombre", "Fecha Creacion", "Publico",
	// "Estado",
	// "Fecha Ultima Modificacion" };
	//
	// for (int j = 0; j < titulos.length; j++) {
	// cell = nombreFila.createCell(j);
	// cell.setCellValue(titulos[j]);
	// }
	//
	// HSSFRow nombreFila1 = sheet.createRow(1);
	// cell = nombreFila1.createCell(0);
	// cell.setCellValue(documento.getCodigo());
	// cell = nombreFila1.createCell(1);
	// cell.setCellValue(documento.getNombre());
	// cell = nombreFila1.createCell(2);
	// cell.setCellValue(documento.getFechaCreacion());
	// cell = nombreFila1.createCell(3);
	// cell.setCellValue(documento.getPublico());
	// cell = nombreFila1.createCell(4);
	// cell.setCellValue(documento.getEstado());
	// cell = nombreFila1.createCell(5);
	// cell.setCellValue(documento.getFechaUltimaModificacion());
	//
	// try {
	//
	// // Creamos el flujo de salida de datos,
	// // apuntamos el archivo donde queremos almacenar el libro Excel
	//
	// FileOutputStream salida = new FileOutputStream(archivo, true);
	//
	// // Almacenamos el libro Excel via ese, flujo de datos
	// workbook.write(salida);
	//
	// // Cerramos el libro para concluir operaciones
	//// workbook.close();
	//
	// } catch (FileNotFoundException ex) {
	// System.out.println("ERROR!");
	// } catch (IOException ex) {
	// System.out.println("ERROR!");
	// }
	//
	// Integer numeroLineas = 0;
	//
	// // Datos a escribir en map(Object[])
	// Map<String, Object[]> data = new TreeMap<String, Object[]>();
	// // Cabecera
	// File archivoExcel = new File("FPdUAL.xlsx");
	// if (!archivoExcel.exists()) {
	// data.put("0", new Object[] { "ID", "PC", "NOMBRE", "APELLIDOS" });
	// numeroLineas = 1;
	//
	// } else {
	//
	// RepositorioDocumentoImpl ImportExcel;
	// ArrayList<String[]> datoExcel = ImportExcel.importExcel("FPDual.xlsx", 4);
	// List<Documento> datosExcel;
	// ListIterator<String[]> it = datosExcel.listIterator();
	//
	// while (it.hasNext()) {
	// numeroLineas++;
	// String[] datos = it.next();
	// data.put(numeroLineas.toString(), datos);
	// }
	// }
	// }

	public static void exportExcel(String nombreHoja, Documento documento, String fileName) {

		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName));
			Workbook workbook = WorkbookFactory.create(inputStream);

			int numeroHoja;
			if (nombreHoja.equals("Documentos")) {
				numeroHoja = 0;
			} else if (nombreHoja.equals("Alta")) {
				numeroHoja = 1;
			} else if (nombreHoja.equals("Modificar")) {
				numeroHoja = 2;
			} else {
				numeroHoja = 3;
			}

			Sheet sheet = workbook.getSheetAt(numeroHoja);

			Object[] bookData = { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),
					documento.getEstado().toString() };

			int rowCount = sheet.getLastRowNum();

			Row row = sheet.createRow(++rowCount);

			int columnCount = 0;

			Cell cell = row.createCell(columnCount);
			cell.setCellValue(rowCount);

			for (Object field : bookData) {
				cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(fileName);
			workbook.write(outputStream);
			// workbook.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
			ex.printStackTrace();
		}
	}

	// // Creamos el libro de trabajo
	// XSSFWorkbook libro = new XSSFWorkbook();
	//
	// // Creacion de Hoja
	// XSSFSheet hoja = libro.createSheet(nombreHoja);
	//
	// // Iteramos el map e insertamos los datos
	// Set<String> keyset = data.keySet();
	// int rownum = 0;
	// for (String key : keyset) {
	// // cramos la fila
	// Row row = hoja.createRow(rownum++);
	// // obtenemos los datos de la fila
	// Object[] objArr = data.get(key);
	// int cellnum = 0;
	// // iteramos cada dato de la fila
	// for (Object obj : objArr) {
	// // Creamos la celda
	// Cell cell = row.createCell(cellnum++);
	// // Setteamos el valor con el tipo de dato correspondiente
	// if (obj instanceof String)
	// cell.setCellValue((String) obj);
	// else if (obj instanceof Integer)
	// cell.setCellValue((Integer) obj);
	// }
	// }
	// try {
	// // Escribimos en fichero
	// FileOutputStream out = new FileOutputStream(new File(fileName));
	// libro.write(out);
	// //cerramos el fichero y el libro
	// out.close();
	//// libro.close();
	// System.out.println("Excel exportado correctamente\n");
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// }

	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			// workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}

	@Override
	public void archivoDocumentoarchivo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void altaExpediene(Expediente expediente) {
		// TODO Auto-generated method stub

	}
}