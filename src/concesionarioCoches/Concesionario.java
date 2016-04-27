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
 * L�gicamente, no podr� a�adirse un coche inv�lido almac�n del concesinario)
 * 
 * Han de conocerse todas sus caracter�sticas Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public class Concesionario implements Serializable {
	/**
	 * Almac�n de los coches del concesionario
	 */
	public ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capit�n";

	/**
	 * A�ade un coche al concesinario
	 * 
	 * @param matricula
	 *            Matr�cula del coche a a�adir
	 * @param color
	 *            Color del coche a a�adir
	 * @param modelo
	 *            Modelo del coche a a�adir
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 * @throws MatriculaNoValidaException
	 * @throws CocheYaExisteException
	 * @throws Exception
	 *             Si no se ha podido a�adir el coche al concesionario, porque
	 *             ya hay otro con la misma matr�cula o porque faltan datos
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
	 * Devuelve el n�mero de coches en el almac�n del concesionario
	 * 
	 * @return N�mero de coches en el almac�n del concesionario
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almac�n indicado por la matr�cula
	 * 
	 * @param matricula
	 *            Matr�cula a buscar
	 * @return Coche contenido en el almac�n. null si no existe
	 * @throws MatriculaNoValidaException
	 *             Si la matr�cula no es v�lida
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		try {
			return almacen.get(almacen.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("El coche no est� en el concesionario.");
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
