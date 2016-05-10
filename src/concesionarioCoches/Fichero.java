package concesionarioCoches;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Crea otra versi�n de Concesionario de coches, ahora almacenar� el
 * concesionario completo en el sistema de ficheros, del que se podr� recuperar
 * en cualquier momento. Utiliza el c�digo del gitbub
 * https://github.com/lmagarin/Concesionario-de-coches/issues/1 Para ello: A�ade
 * una opci�n Ficheros al men� principal Crea un men� para gestionar los
 * ficheros. Tendr� las opciones t�picas: nuevo, abrir, guardar, guardar como...
 * El concesionario podr� guardarse en un fichero (guardar y guardar como...) El
 * concesionario podr� leerse de un fichero (abrir) Podr� crearse un
 * concesionario nuevo (nuevo) En caso de que se pueda perder informaci�n del
 * concesionario, se le preguntar� al usuario (nuevo, abrir, guardar como...) Se
 * le a�adir� la extensi�n ".obj". Deber�s utilizar la clase File, que es una
 * representaci�n abstracta de los nombres de los ficheros y directorios. Podr�s
 * usar los m�todos: File file = new File(String pathname) file.getPath();
 * file.exists(); PD: Utiliza el ARM para evitar el tener que utilizar el
 * close() de los flujos PPD: Procura colocar la creaci�n del flujo en la misma
 * l�nea, evitando el uso de variables innecesarias
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class Fichero {
	public static Object abrir(File archivo) throws ClassNotFoundException, IOException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
			return (Object) ois.readObject();
		}
	}

	public static void guardar(Object obj, File archivo) throws FileNotFoundException, IOException {
		archivo = annadirExtension(archivo);
		try (ObjectOutputStream salida = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivo, false)))) {
			salida.writeObject(obj);
		}
	}

	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

	public static boolean confirmarExistencia(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}
