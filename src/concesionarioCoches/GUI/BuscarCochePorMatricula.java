package concesionarioCoches.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import concesionarioCoches.Coche;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.Gestion;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		setTitle("Mostrar coche");
		modeloComboBox.setSelectedIndex(-1);
		marcaComboBox.setSelectedIndex(-1);
		button3.setVisible(false);
		button1.setVisible(false);
		button2.setVisible(false);
		button5.setVisible(false);
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		plataRButton.setEnabled(false);
		rojoRButton.setEnabled(false);
		azulRButton.setEnabled(false);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
