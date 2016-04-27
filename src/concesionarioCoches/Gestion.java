package concesionarioCoches;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Alta de un coche (se pedirá matricula, color y modelo),</li>
 * <li>Baja de un coche (por matrícula)</li>
 * <li>Mostrar un coche (por matrícula)</li>
 * <li>Mostrar concesionario (todos los coches del concesionario)</li>
 * <li>Contar el número de coches en el concesionario</li>
 * <li>Mostrar coches de un color</li>
 * </ol>
 * <p>
 * Lógicamente, no podrá añadirse un coche inválido o ya contenido (No pueden
 * existir dos coches con la misma matrícula en el concesionario) Por cada p que
 * se dé de alta, han de conocerse todas sus características. Ninguna de las
 * características del coche puede ser por defecto.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public class Gestion {
	/**
	 * Bandera para saber si esta modificado o no.
	 */
	private static boolean modificado;
	/**
	 * Archivo seleccionado en el programa.
	 */
	private static File archivoSeleccionado;

	/**
	 * Get para el archivo seleccionado en el programa.
	 * 
	 * @return devuelve el archivo.
	 */
	public static File getArchivoSeleccionado() {
		return archivoSeleccionado;
	}

	/**
	 * Modifica el archivo seleccionado por el programa.
	 * 
	 * @param archivoSeleccionado
	 *            archivo nuevo a ser seleccionado.
	 */
	public static void setArchivoSeleccionado(File archivoSeleccionado) {
		Gestion.archivoSeleccionado = archivoSeleccionado;
	}

	/**
	 * Get que devuelve el estado del campo modificado.
	 * 
	 * @return estado del campo modificado.
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Modifica el estado de la bandera modificado.
	 * 
	 * @param modif
	 *            Nuevo estado de la bandera pasado por par&aacute;metro.
	 */
	public static void setModificado(boolean modif) {
		modificado = modif;
	}
}
