package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public abstract class RepositorioExpedienteImpl implements RepositorioExpediente {

	private List<Expediente> expediente = new ArrayList();

	static String nombreFichero = "log.txt";
	File file = new File(nombreFichero);

	public List<Expediente> getExpediene() {
		return expediente;
	}

	@Override
	public void altaDocumento(Expediente expediente) {

		if (expediente.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya se encuentra en la lista");
		}
		expediente.add(expediente);
	}

	public String altaDocumentoTxt(Expediente expediente) {
		FileWriter fw = null;
		PrintWriter pw = null;
		String fichero = "Alta.txt";

		try {
			fw = new FileWriter(fichero, true);
			pw = new PrintWriter(fw);
			pw.println(expediente);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return "El fichero Guardado";
	}

	@Override
	public String archivoModificarTxt(Expediente expediente) {

		FileWriter fw = null;
		PrintWriter pw = null;
		String fichero = "Modificar.txt";

		try {

			fw = new FileWriter(fichero, true);
			pw = new PrintWriter(fw);
			pw.println(expediente);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			pw.close();

		}
		return "El fichero se ha Guardado";

	}

	public String eliminarExpedienteTxt(Expediente expediente) {

		FileWriter fw = null;
		PrintWriter pw = null;
		String fichero = "Eliminar.txt";

		try {
			fw = new FileWriter(fichero, true);
			pw = new PrintWriter(fw);
			pw.println(expediente);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return "El fichero se ha Guardado";
	}

}
