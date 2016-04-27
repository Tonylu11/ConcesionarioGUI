package concesionarioCoches.GUI;

import java.awt.HeadlessException;
import concesionarioCoches.Gestion;
import concesionarioCoches.Modelo;
import concesionarioCoches.excepciones.CocheYaExisteException;
import concesionarioCoches.excepciones.ColorNoValidoException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.excepciones.ModeloNoValidoException;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A&ntilde;ade un coche al concesionario con interfaz gr&aacute;fica.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class AnnadirCoche extends VentanaPadre {

	/**
	 * Create the dialog.
	 */
	public AnnadirCoche() {
		super();
		setTitle("A\u00F1adir coche");
		botonAnterior.setVisible(false);
		botonSiguiente.setVisible(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCoche();
			}
		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}

		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
	}

	/**
	 * Da de alta un coche en el concesionario.
	 */
	private void altaCoche() {
		try {
			if (General.concesionario.annadir(matriculaTxtField.getText(), getColorSeleccionado(),
					(Modelo) modeloComboBox.getSelectedItem())) {
				JOptionPane.showMessageDialog(okButton, "Coche añadido con éxito");
				Gestion.setModificado(true);
			}
		} catch (HeadlessException | MatriculaNoValidaException | ColorNoValidoException | ModeloNoValidoException
				| CocheYaExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, "El coche no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}