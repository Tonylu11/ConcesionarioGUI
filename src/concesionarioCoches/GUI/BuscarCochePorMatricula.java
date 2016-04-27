package concesionarioCoches.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import concesionarioCoches.Coche;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;

/**
 * Muestra un coche del concesionario por su matr&iacute;cula.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class BuscarCochePorMatricula extends VentanaPadre {

	/**
	 * Create the dialog.
	 */
	public BuscarCochePorMatricula() {
		super();
		setTitle("Mostrar coche");
		modeloComboBox.setSelectedIndex(-1);
		marcaComboBox.setSelectedIndex(-1);
		btnLimpiar.setVisible(false);
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);
		okButton.setText("Mostrar");
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		plataRButton.setEnabled(false);
		rojoRButton.setEnabled(false);
		azulRButton.setEnabled(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	/**
	 * Muestra un coche del concesionario.
	 */
	private void mostrarCoche() {
		try {
			Coche coche = General.concesionario.get(matriculaTxtField.getText());
			if (coche.getColor().toString().equals("AZUL"))
				azulRButton.setSelected(true);
			else if (coche.getColor().toString().equals("ROJO"))
				rojoRButton.setSelected(true);
			else if (coche.getColor().toString().equals("PLATA"))
				plataRButton.setSelected(true);
			marcaComboBox.addItem((coche.getModelo().getMarca()));
			modeloComboBox.addItem((coche.getModelo()));
			marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
			modeloComboBox.setSelectedItem(coche.getModelo());
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			JOptionPane.showMessageDialog(okButton, "No se ha podido encontrar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
