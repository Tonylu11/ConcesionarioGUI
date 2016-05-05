package concesionarioCoches.GUI;

import javax.swing.JOptionPane;
import concesionarioCoches.Coche;
import concesionarioCoches.Colores;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.ColorNoValidoException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.Gestion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		azulRButton.setSelected(true);
		matriculaTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					mostrarCoche(Gestion.concesionario.get(matriculaTxtField.getText()));
				} catch (MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "La matrícula no es válida..", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (CocheNoExisteException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "El coche no existe..", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		setTitle("Modificar color");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarColorCoche();
			}
		});
		button5.setText("Modificar");
		button3.setVisible(false);
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		button1.setVisible(false);
		button2.setVisible(false);

	}

	/**
	 * Modifica el color del coche
	 */
	private void modificarColorCoche() {
		try {
			Coche coche = Gestion.concesionario.get(matriculaTxtField.getText());
			modificarColor(coche, getColorSeleccionado());
			JOptionPane.showMessageDialog(button5, "Color modificado con éxito.");
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
