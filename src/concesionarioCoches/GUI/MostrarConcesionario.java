package concesionarioCoches.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import concesionarioCoches.Gestion;

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
		button3.setVisible(false);
		button5.setVisible(false);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAnterior();
			}

		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cocheSiguiente();
			}
		});
	}

	/**
	 * Muestra el coche siguiente.
	 */
	private void cocheSiguiente() {
		mostrarCoche(Gestion.concesionario.get(++indice));
		comprobarTamanno(Gestion.concesionario);
	}

	/**
	 * Muestra el coche anterior.
	 */
	private void cocheAnterior() {
		mostrarCoche(Gestion.concesionario.get(--indice));
		comprobarTamanno(Gestion.concesionario);
	}

}
