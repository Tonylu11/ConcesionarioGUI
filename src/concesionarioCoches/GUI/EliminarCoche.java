package concesionarioCoches.GUI;

import java.awt.HeadlessException;
import concesionarioCoches.Coche;
import concesionarioCoches.Gestion;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Elimina un coche por su matr&iacute;cula.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class EliminarCoche extends VentanaPadre {

	/**
	 * Create the dialog.
	 */
	public EliminarCoche() {
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
		setTitle("Eliminar coche");
		marcaComboBox.setSelectedIndex(-1);
		button3.setVisible(false);
		plataRButton.setEnabled(false);
		rojoRButton.setEnabled(false);
		azulRButton.setEnabled(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		button1.setVisible(false);
		button2.setVisible(false);
		button5.setText("Eliminar");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCoche();
			}
		});
	}

	/**
	 * Elimina un coche del concesionario.
	 */
	private void eliminarCoche() {
		try {
			if (Gestion.concesionario.eliminar(matriculaTxtField.getText())) {
				JOptionPane.showMessageDialog(button5, "Coche eliminado con éxito");
				Gestion.setModificado(true);
			} else
				JOptionPane.showMessageDialog(contentPanel, "El coche no se encuentra en el concesionario.", "Error",
						JOptionPane.ERROR_MESSAGE);
		} catch (MatriculaNoValidaException | HeadlessException | CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(button5, "El coche no se ha podido eliminar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
