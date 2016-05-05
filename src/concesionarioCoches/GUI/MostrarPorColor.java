package concesionarioCoches.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import concesionarioCoches.Concesionario;
import concesionarioCoches.excepciones.CocheYaExisteException;
import concesionarioCoches.excepciones.ColorNoValidoException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.excepciones.ModeloNoValidoException;
import concesionarioCoches.Coche;
import concesionarioCoches.Colores;
import concesionarioCoches.Gestion;

/**
 * Muestra el concesionario por el color de los coches.
 * 
 * @author Antonio Luque Bravo
 *
 */
@SuppressWarnings("serial")
public class MostrarPorColor extends VentanaPadre {
	/**
	 * Concesionario para cada color.
	 */
	private Concesionario concesionarioColor;

	/**
	 * Crea el di&aacute;logo.
	 */
	@SuppressWarnings("rawtypes")
	public MostrarPorColor() {
		super();
		setTitle("Mostrar por color");
		marcaComboBox.setSelectedIndex(-1);
		button3.setVisible(false);
		button5.setVisible(false);
		matriculaTxtField.setEnabled(false);
		matriculaTxtField.setEditable(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		matriculaTxtField.setEnabled(false);
		matriculaTxtField.setEditable(false);
		button2.setEnabled(false);
		button1.setEnabled(false);
		rojoRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCochesRojos();
			}
		});
		azulRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCochesAzules();
			}

		});
		plataRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCochesPlata();
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}

		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarSiguiente();
			}
		});
	}

	/**
	 * Muestra el siguiente coche al actual.
	 */
	private void mostrarSiguiente() {
		mostrarCoche(concesionarioColor.get(++indice));
		comprobarTamanno(concesionarioColor);
	}

	/**
	 * Muestra el coche anterior al actual.
	 */
	private void mostrarAnterior() {
		mostrarCoche(concesionarioColor.get(--indice));
		comprobarTamanno(concesionarioColor);
	}

	/**
	 * Crea el mostrar por color.
	 * 
	 * @param color
	 *            color del coche
	 * @throws MatriculaNoValidaException
	 *             Matr&iacute;cula no v&aacute;lida
	 * @throws ColorNoValidoException
	 *             Color no v&aacute;lido
	 * @throws ModeloNoValidoException
	 *             Modelo no v&aacute;lido
	 * @throws CocheYaExistenteException
	 *             Coche ya existente.
	 */
	private void generarConcesionario(Colores color)
			throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException, CocheYaExisteException {
		concesionarioColor = new Concesionario();
		for (Coche coche : Gestion.concesionario.almacen) {
			if (coche.getColor().equals(color))
				concesionarioColor.annadir(coche.getMatricula(), color, coche.getModelo());
		}
	}

	/**
	 * Muestra los coches rojos.
	 */
	private void mostrarCochesRojos() {
		try {
			generarConcesionario(concesionarioCoches.Colores.ROJO);
			if (concesionarioColor.get(0) != null) {
				mostrarCoche(concesionarioColor.get(indice));
				comprobarTamanno(concesionarioColor);
				button2.setVisible(true);
				button1.setVisible(true);
			} else {
				comprobarTamanno(concesionarioColor);
				limpiarCampos();
			}
		} catch (MatriculaNoValidaException | ColorNoValidoException | ModeloNoValidoException
				| CocheYaExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, "No se ha podido generar el concesionario", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Muestra los coches azules.
	 */
	private void mostrarCochesAzules() {
		try {
			generarConcesionario(concesionarioCoches.Colores.AZUL);
			if (concesionarioColor.get(0) != null) {
				mostrarCoche(concesionarioColor.get(indice));
				comprobarTamanno(concesionarioColor);
				button2.setVisible(true);
				button1.setVisible(true);
			} else {
				comprobarTamanno(concesionarioColor);
				limpiarCampos();
			}
		} catch (MatriculaNoValidaException | ColorNoValidoException | ModeloNoValidoException
				| CocheYaExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, "No se ha podido generar el concesionario", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Muestra los coches de color plata.
	 */
	private void mostrarCochesPlata() {
		try {
			generarConcesionario(concesionarioCoches.Colores.PLATA);
			if (concesionarioColor.get(0) != null) {
				mostrarCoche(concesionarioColor.get(indice));
				comprobarTamanno(concesionarioColor);
				button2.setVisible(true);
				button1.setVisible(true);
			} else {
				comprobarTamanno(concesionarioColor);
				limpiarCampos();
			}
		} catch (MatriculaNoValidaException | ColorNoValidoException | ModeloNoValidoException
				| CocheYaExisteException e3) {
			JOptionPane.showMessageDialog(contentPanel, "No se ha podido generar el concesionario", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
