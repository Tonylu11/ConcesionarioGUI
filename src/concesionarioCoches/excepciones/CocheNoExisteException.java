package concesionarioCoches.excepciones;

/**
 * Representa a un coche.
 * <p>
 * Un coche tendr� las siguientes caracter�sticas:
 * <ol>
 * <li>Color. Se limitar�n los colores a tres: plata, rojo y azul.</li>
 * 
 * 
 * <li>Modelo. Se limitar�n los modelos de coches a siete: C�rdoba (marca
 * Seat),Toledo (marca Seat),Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2
 * (marca BMW),Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el
 * modelo al dar de alta al coche podr� implementarse un m�todo pedirModelo que
 * mediante la gesti�n de un men�, devolver� el modelo indicado.</li>
 * 
 * 
 * <li>Matr�cula (�nica por coche) El formato de las matr�culas ser� el nuevo:
 * combinaci�n de cuatro n�meros (de 0000 a 9999) y tres letras, comenzando por
 * BBB y terminando por ZZZ, excluyendo vocales, la LL, la � y la Q.</li>
 * 
 * 
 * <ol>
 * <li>Matr�culas v�lidas: 0000-BBB, 0000 BBB, 0000BBB, 1234ZZZ.</li>
 * <li>Matr�culas inv�lidas: 000_BBB, 9999-BBQ, 0000-B�B, 0000-DEF, 0000 bbb,
 * 0000 AAA</li>
 * </ol>
 * </ol>
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public class CocheNoExisteException extends Exception {

	public CocheNoExisteException(String string) {
		super(string);
	}

}
