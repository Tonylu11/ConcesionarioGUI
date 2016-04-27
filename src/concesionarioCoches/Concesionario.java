package concesionarioCoches;

import java.io.Serializable;
import java.util.ArrayList;

import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.CocheYaExisteException;
import concesionarioCoches.excepciones.ColorNoValidoException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.excepciones.ModeloNoValidoException;

/**
 * Representa un concesionario de coches.
 * 
 * Lógicamente, no podrá añadirse un coche inválido almacén del concesinario)
 * 
 * Han de conocerse todas sus características Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public class Concesionario implements Serializable {
	/**
	 * Almacén de los coches del concesionario
	 */
	public ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";

	/**
	 * Añade un coche al concesinario
	 * 
	 * @param matricula
	 *            Matrícula del coche a añadir
	 * @param color
	 *            Color del coche a añadir
	 * @param modelo
	 *            Modelo del coche a añadir
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 * @throws MatriculaNoValidaException
	 * @throws CocheYaExisteException
	 * @throws Exception
	 *             Si no se ha podido añadir el coche al concesionario, porque
	 *             ya hay otro con la misma matrícula o porque faltan datos
	 */
	public boolean annadir(String matricula, Colores color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException, CocheYaExisteException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya existe en el concesionario. ");
		Gestion.setModificado(true);
		return almacen.add(coche);
	}

	public boolean eliminar(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (almacen.contains(coche)) {
			Gestion.setModificado(true);
			return almacen.remove(coche);
		} else
			throw new CocheNoExisteException("El coche no existe");

	}

	/**
	 * Devuelve el número de coches en el almacén del concesionario
	 * 
	 * @return Número de coches en el almacén del concesionario
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almacén indicado por la matrícula
	 * 
	 * @param matricula
	 *            Matrícula a buscar
	 * @return Coche contenido en el almacén. null si no existe
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		try {
			return almacen.get(almacen.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("El coche no está en el concesionario.");
		}
	}

	/**
	 * Devuelve el elemento por su indice. null si no existe.
	 * 
	 * @param index
	 *            indice
	 * @return Elemento por su indice. null si no existe.
	 */
	public Coche get(int index) {
		if (almacen.isEmpty() | index < 0 | index > almacen.size() - 1)
			return null;
		return almacen.get(index);

	}

	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	public ArrayList<Coche> getCochesColor(Colores color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}
