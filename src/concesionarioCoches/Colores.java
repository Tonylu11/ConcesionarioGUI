package concesionarioCoches;

/**
 * Representa los colores. Seg�n el enunciado del examen:
 * 
 * <pre>
 * Se limitar�n los colores a tres: plata, rojo y azul. Para solicitar el color
 * al dar de alta al coche podr� implementarse un m�todo pedirColor que mediante
 * la gesti�n de un men�, devolver� el color indicado
 * </pre>
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public enum Colores {
	/**
	 * El color plata
	 */
	PLATA,
	/**
	 * El color rojo
	 */
	ROJO,
	/**
	 * El color azul
	 */
	AZUL;
	/**
	 * Almacena los colores posibles
	 */
	private static final Colores[] VALUES = Colores.values();

	/**
	 * Genera las opciones del men�
	 * 
	 * @return Opciones del men�, incluyendo "Salir"
	 */
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Colores color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve VALUES
	 * 
	 * @return VALUES
	 * @see Colores#VALUES
	 */
	public Colores[] getValues() {
		return VALUES;
	}

}
