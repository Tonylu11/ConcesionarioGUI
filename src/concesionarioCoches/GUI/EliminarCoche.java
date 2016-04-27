package concesionarioCoches.GUI;

import java.awt.HeadlessException;
import concesionarioCoches.Coche;
import concesionarioCoches.Gestion;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Eliminar coche");
		marcaComboBox.setSelectedIndex(-1);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche();
			}
		});
		plataRButton.setEnabled(false);
		rojoRButton.setEnabled(false);
		azulRButton.setEnabled(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);
		okButton.setText("Eliminar");
		btnLimpiar.setText("Mostrar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCoche();
			}
		});
	}

	/**
	 * Muestra el coche.
	 */
	private void mostrarCoche() {
		try {
			Coche coche = General.concesionario.get(matriculaTxtField.getText());
			matriculaTxtField.setText(coche.getMatricula());
			if (coche.getColor().toString().equals("ROJO"))
				rojoRButton.setSelected(true);
			else if (coche.getColor().toString().equals("PLATA"))
				plataRButton.setSelected(true);
			else if (coche.getColor().toString().equals("AZUL")) {
				azulRButton.setSelected(true);
			}
			marcaComboBox.addItem(coche.getModelo().getMarca());
			marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
			modeloComboBox.addItem(coche.getModelo());
			modeloComboBox.setSelectedItem(coche.getModelo());
		} catch (MatriculaNoValidaException | CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, "El coche no se encuentra en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Elimina un coche del concesionario.
	 */
	private void eliminarCoche() {
		try {
			if (General.concesionario.eliminar(matriculaTxtField.getText())) {
				JOptionPane.showMessageDialog(okButton, "Coche eliminado con éxito");
				Gestion.setModificado(true);
			} else
				JOptionPane.showMessageDialog(contentPanel, "El coche no se encuentra en el concesionario.", "Error",
						JOptionPane.ERROR_MESSAGE);
		} catch (MatriculaNoValidaException | HeadlessException | CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(okButton, "El coche no se ha podido eliminar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
