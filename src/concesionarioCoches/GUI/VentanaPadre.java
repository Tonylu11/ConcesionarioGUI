package concesionarioCoches.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Colores;
import concesionarioCoches.Concesionario;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;
import concesionarioCoches.excepciones.CocheNoExisteException;
import concesionarioCoches.excepciones.MatriculaNoValidaException;
import concesionarioCoches.Gestion;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Ventana Padre de todas las Ventanas del Concesionario.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class VentanaPadre extends JDialog {
	/**
	 * La ventana padre.
	 */
	protected static JDialog dialog;
	/**
	 * El panel que contiene toda la ventana.
	 */
	protected final JPanel contentPanel = new JPanel();
	/**
	 * Campo de texto para la matr&iacute;cula.
	 */
	protected JTextField matriculaTxtField;
	/**
	 * ComboBox de la marca del coche.
	 */
	protected JComboBox marcaComboBox;
	/**
	 * ComboBox del modelo del coche.
	 */
	protected JComboBox modeloComboBox;
	/**
	 * Bot&oacute;n para el color azul.
	 */
	protected JRadioButton azulRButton;
	/**
	 * Bot&oacute;n para el color rojo.
	 */
	protected JRadioButton rojoRButton;
	/**
	 * Bot&oacute;n para el color plata.
	 */
	protected JRadioButton plataRButton;
	/**
	 * Agrupaci&oacute;n de los botones de colores.
	 */
	protected ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Bot&oacute;n Aceptar.
	 */
	protected JButton button5;
	/**
	 * Bot&oacute; limpiar.
	 */
	protected JButton button3;
	/**
	 * Bot&oacute;n cancelar.
	 */
	protected JButton button4;
	/**
	 * Panel de botones.
	 */
	protected JPanel buttonPane;
	/**
	 * Colores.
	 */
	protected JPanel colores;
	/**
	 * Bot&oacute;n para volver atr&aacute;s en el listado de coches.
	 */
	protected JButton button1;
	/**
	 * Bot&oacute;n para avanzar en el listado de coches.
	 */
	protected JButton button2;
	/**
	 * &Iacute;ndice para el manejo del listado de coches.
	 */
	protected int indice = 0;

	/**
	 * Constructor de la Ventana Padre.
	 */
	public VentanaPadre() {
		setModal(true);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 364, 198);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel MatriculaLbl = new JLabel("Matr\u00EDcula");
			MatriculaLbl.setBounds(39, 16, 58, 14);
			contentPanel.add(MatriculaLbl);
		}
		{
			matriculaTxtField = new JTextField();
			matriculaTxtField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					comprobarSiMatriculaValida();
				}

				@Override
				public void focusGained(FocusEvent e) {
					matriculaTxtField.setForeground(Color.BLACK);
				}
			});
			matriculaTxtField.setBounds(107, 14, 86, 17);
			contentPanel.add(matriculaTxtField);
			matriculaTxtField.setColumns(10);
		}

		colores = new JPanel();
		colores.setBorder(new TitledBorder(null, "Color", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		colores.setBounds(203, 16, 121, 98);
		contentPanel.add(colores);
		colores.setLayout(null);

		azulRButton = new JRadioButton("Azul");
		azulRButton.setForeground(java.awt.Color.BLUE);
		azulRButton.setBounds(6, 16, 109, 23);
		colores.add(azulRButton);
		buttonGroup.add(azulRButton);

		rojoRButton = new JRadioButton("Rojo");
		rojoRButton.setForeground(java.awt.Color.RED);
		rojoRButton.setBounds(6, 42, 109, 23);
		colores.add(rojoRButton);
		buttonGroup.add(rojoRButton);

		plataRButton = new JRadioButton("Plata");
		plataRButton.setForeground(new java.awt.Color(192, 192, 192));
		plataRButton.setBounds(6, 68, 109, 23);
		colores.add(plataRButton);
		buttonGroup.add(plataRButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 41, 173, 2);
		contentPanel.add(separator);

		marcaComboBox = new JComboBox();
		marcaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				modeloComboBox.setModel(new DefaultComboBoxModel<>(getModeloDeMarca(marcaComboBox)));
			}
		});
		marcaComboBox.setModel(new DefaultComboBoxModel(Marca.values()));
		marcaComboBox.setBounds(107, 54, 86, 20);
		contentPanel.add(marcaComboBox);

		modeloComboBox = new JComboBox();
		modeloComboBox.setModel(new DefaultComboBoxModel(getModeloDeMarca(marcaComboBox)));
		modeloComboBox.setBounds(107, 85, 86, 20);
		contentPanel.add(modeloComboBox);

		JLabel marcaLbl = new JLabel("Marca");
		marcaLbl.setBounds(39, 57, 46, 14);
		contentPanel.add(marcaLbl);

		JLabel modeloLbl = new JLabel("Modelo");
		modeloLbl.setBounds(39, 88, 46, 14);
		contentPanel.add(modeloLbl);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			button1 = new JButton("<");
			button2 = new JButton(">");
			buttonPane.add(button1);
			buttonPane.add(button2);
			{
				button5 = new JButton("Crear");
				button3 = new JButton("Limpiar");
				buttonPane.add(button3);
				button5.setActionCommand("OK");
				buttonPane.add(button5);
				getRootPane().setDefaultButton(button5);
			}
			{
				button4 = new JButton("Atr\u00E1s");
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button4.setActionCommand("Cancel");
				buttonPane.add(button4);
			}
		}
	}

	/**
	 * Comprueba si la matr&iacute;cula es valida, de ser asi la
	 * colorear&aacute; de verde, de lo contrario de rojo.
	 */
	protected void comprobarSiMatriculaValida() {
		if (Coche.esValida(matriculaTxtField.getText())) {
			matriculaTxtField.setForeground(Color.GREEN);
		} else
			matriculaTxtField.setForeground(Color.RED);
	}

	/**
	 * Obtiene el color seleccionado por el usuario.
	 * 
	 * @return Devuelve el color seleccionado.
	 */
	protected Colores getColorSeleccionado() {
		if (rojoRButton.isSelected()) {
			return Colores.ROJO;
		} else if (plataRButton.isSelected()) {
			return Colores.PLATA;
		}
		return Colores.AZUL;
	}

	/**
	 * Devuelve un array con los modelos de dicha marca.
	 * 
	 * @param comboBoxMarca
	 *            ComboBox de marca.
	 * @return Array con los modelos de la marca pasada por parametro.
	 */
	protected Object[] getModeloDeMarca(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo modelo : Modelo.values()) {
			if (modelo.getMarca() == marca)
				modelos.add(modelo);
		}
		return modelos.toArray();
	}

	/**
	 * Actualiza el &iacute;ndice y muestra el primer coche, comprobando los
	 * botones de atras y siguiente.
	 */
	protected void actualizar() {
		indice = 0;
		mostrarCoche(Gestion.concesionario.get(0));
		comprobarTamanno(Gestion.concesionario);
	}

	/**
	 * Comprueba el tama&ntilde;o del concesionario pasado por parametro para
	 * activar o desactivar los botones de atras y siguiente.
	 * 
	 * @param concesionario
	 *            concesionario a comprobar tama&ntilde;o.
	 */
	protected void comprobarTamanno(Concesionario concesionario) {
		if (concesionario.get(indice + 1) != null)
			button2.setEnabled(true);
		else
			button2.setEnabled(false);

		if (concesionario.get(indice - 1) != null)
			button1.setEnabled(true);
		else
			button1.setEnabled(false);
	}

	/**
	 * Muestra el coche pasado por par&aacute;metro.
	 * 
	 * @param coche
	 *            Coche a mostrar.
	 */
	protected void mostrarCoche(Coche coche) {
		if (Gestion.concesionario.get(indice) == null) {
			button1.setEnabled(false);
			return;
		}
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
	}

	/**
	 * Resetea los campos de matr&iacute;cula, marca y modelo y los coloca
	 * vac&iacute;os.
	 */
	protected void limpiarCampos() {
		matriculaTxtField.setText("");
		marcaComboBox.setSelectedIndex(-1);
		modeloComboBox.setSelectedIndex(-1);
	}
}