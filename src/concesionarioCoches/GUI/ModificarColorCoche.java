package concesionarioCoches.GUI;

import javax.swing.JOptionPane;
import concesionarioCoches.Coche;
import concesionarioCoches.Colores;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.ColorNoValidoException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Modifica el color del coche.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ModificarColorCoche extends VentanaPadre {

	/**
	 * Create the dialog.
	 */
	public ModificarColorCoche() {
		super();
		setTitle("Modificar color");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarColorCoche();
			}

		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCocheConcesionario();
			}
		});
		okButton.setText("Modificar");
		btnLimpiar.setText("Mostrar");
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);

	}

	/**
	 * Muestra el coche del concesionario por su matr&iacute;cula.
	 */
	private void mostrarCocheConcesionario() {
		try {
			Coche coche = General.concesionario.get(matriculaTxtField.getText());
			mostrarCoche(coche);
		} catch (MatriculaNoValidaException e1) {
			JOptionPane.showMessageDialog(getContentPane(), "La matrícula no es válida..", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(getContentPane(), "El coche no existe..", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Modifica el color del coche
	 */
	private void modificarColorCoche() {
		try {
			Coche coche = General.concesionario.get(matriculaTxtField.getText());
			modificarColor(coche, getColorSeleccionado());
			JOptionPane.showMessageDialog(okButton, "Color modificado con éxito.");
		} catch (MatriculaNoValidaException e1) {
			JOptionPane.showMessageDialog(getContentPane(), "La matrícula no es válida..", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (ColorNoValidoException e1) {
			JOptionPane.showMessageDialog(getContentPane(), "El color no es válido..", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(getContentPane(), "El coche no existe..", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Modifica el color del coche pasado por parametro.
	 * 
	 * @param coche
	 *            coche a modificar.
	 * @param colorSeleccionado
	 *            color seleccionado.
	 * @throws ColorNoValidoException
	 *             Cuando el color no esv&aacute;lido.
	 */
	protected void modificarColor(Coche coche, Colores colorSeleccionado) throws ColorNoValidoException {
		coche.setColor(colorSeleccionado);
	}
}
