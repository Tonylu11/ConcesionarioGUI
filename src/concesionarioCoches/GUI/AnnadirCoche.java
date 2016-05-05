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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		azulRButton.setSelected(true);
		button1.setVisible(false);
		button2.setVisible(false);
		button4.setText("Atrás");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCoche();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}

		});
		button4.addActionListener(new ActionListener() {
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
			if (Gestion.concesionario.annadir(matriculaTxtField.getText(), getColorSeleccionado(),
					(Modelo) modeloComboBox.getSelectedItem())) {
				JOptionPane.showMessageDialog(button5, "Coche añadido con éxito");
				Gestion.setModificado(true);
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(contentPanel, "El coche no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (MatriculaNoValidaException e) {
			JOptionPane.showMessageDialog(contentPanel, "La matrícula no es válida.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (ColorNoValidoException e) {
			JOptionPane.showMessageDialog(contentPanel, "El color no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ModeloNoValidoException e) {
			JOptionPane.showMessageDialog(contentPanel, "El modelo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (CocheYaExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, "El coche ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}