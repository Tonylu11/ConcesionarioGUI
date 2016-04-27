package concesionarioCoches.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Muestra el concesionario.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class MostrarConcesionario extends VentanaPadre {

	/**
	 * Crea el di&aacute;logo.
	 */
	public MostrarConcesionario() {
		super();
		setTitle("Mostrar concesionario");
		azulRButton.setEnabled(false);
		marcaComboBox.setSelectedIndex(-1);
		plataRButton.setEnabled(false);
		rojoRButton.setEnabled(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		matriculaTxtField.setEnabled(false);
		matriculaTxtField.setEditable(false);
		btnLimpiar.setVisible(false);
		okButton.setVisible(false);

		botonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAnterior();
			}

		});
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cocheSiguiente();
			}
		});
	}

	/**
	 * Muestra el coche siguiente.
	 */
	private void cocheSiguiente() {
		mostrarCoche(General.concesionario.get(++indice));
		comprobarTamanno(General.concesionario);
	}

	/**
	 * Muestra el coche anterior.
	 */
	private void cocheAnterior() {
		mostrarCoche(General.concesionario.get(--indice));
		comprobarTamanno(General.concesionario);
	}

}
