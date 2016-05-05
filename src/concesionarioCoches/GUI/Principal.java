package concesionarioCoches.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionarioCoches.Concesionario;
import concesionarioCoches.Fichero;
import concesionarioCoches.Gestion;

import java.awt.Insets;
import java.awt.Window;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * La página principal tendrá como título el fichero abierto ("Sin título" en
 * caso de no tener asociado ningún fichero). Será al estilo del Notepad.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class Principal extends JFrame {
	/**
	 * Ventana principal del programa.
	 */
	private static JFrame nuevo = new JFrame();
	/**
	 * Panel que contiene la ventana principal.
	 */
	private static JPanel contentPane = new JPanel();
	/**
	 * Panel de botones
	 */
	private JMenuBar menuBar;
	/**
	 * Menu de archivo.
	 */
	private JMenu mnArchivo;
	/**
	 * Menu de concesionario.
	 */
	private JMenu mnConcesionario;
	/**
	 * Menu a&ntilde;adir coche.
	 */
	private JMenuItem mntmAadirCoche;
	/**
	 * A&ntilde;adir coche.
	 */
	private AnnadirCoche annadirCoche = new AnnadirCoche();
	/**
	 * Eliminar coche.
	 */
	private EliminarCoche eliminarCoche = new EliminarCoche();
	/**
	 * Modificar color del coche.
	 */
	private ModificarColorCoche modificarColorCoche = new ModificarColorCoche();
	/**
	 * Mostrar coche por matr&iacute;cula.
	 */
	private BuscarCochePorMatricula mostrarCoche = new BuscarCochePorMatricula();
	/**
	 * Muestra coches ordenados por su color.
	 */
	private MostrarPorColor mostrarCochesPorColor = new MostrarPorColor();
	/**
	 * Mostrar concesionario.
	 */
	private MostrarConcesionario mostrarConcesionario = new MostrarConcesionario();
	/**
	 * Menu con informaci&oacute;n acerca del programa.
	 */
	private AcercaDe acercaDe = new AcercaDe();
	/**
	 * Menu con ayuda para el programa.
	 */
	private Ayuda ayuda = new Ayuda();
	/**
	 * Archivo para el almacen del concesionario en ficheros.
	 */
	private File file;
	/**
	 * Extensi&oacute;n para el filtro de JFileChooser.
	 */
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .obj", "obj");
	/**
	 * El JFileChooser para elegir donde guardar el archivo.
	 */
	private JFileChooser guardar = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "No se ha podido ejecutar el programa..", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		guardar.setFileFilter(filtro);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/icono-pantalla.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (Gestion.isModificado()) {
					guardarCerrarVentana();
				} else
					System.exit(0);
			}
		});
		setTitle("Sin Título - Concesionario IES Gran Capitán");
		setResizable(false);
		setBounds(100, 100, 554, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/ventana-principal-fondo.png")));
		lblNewLabel.setBounds(0, 0, 548, 331);

		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 0));
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mnArchivo.setIcon(new ImageIcon(Principal.class.getResource("/img/ficheros-menu.png")));
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir..");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionAbrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como..");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mnArchivo.add(mntmSalir);
		mnConcesionario = new JMenu("Concesionario");
		mnConcesionario.setMnemonic('C');
		mnConcesionario.setIcon(new ImageIcon(Principal.class.getResource("/img/concesionario-menu.png")));
		menuBar.add(mnConcesionario);
		mntmAadirCoche = new JMenuItem("A\u00F1adir Coche");
		mntmAadirCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirCoche.limpiarCampos();
				annadirCoche.setVisible(true);
			}
		});
		mntmAadirCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnConcesionario.add(mntmAadirCoche);

		JMenuItem mntmEliminarCoche = new JMenuItem("Eliminar Coche");
		mntmEliminarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.concesionario.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "No hay coches en el concesionario..", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				eliminarCoche.limpiarCampos();
				eliminarCoche.setVisible(true);
			}
		});
		mntmEliminarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnConcesionario.add(mntmEliminarCoche);

		JMenuItem mntmContarCoches = new JMenuItem("Contar Coches");
		mntmContarCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmContarCoches,
						"Número total de coches en el concesionario: " + Gestion.concesionario.size());
			}
		});

		JMenuItem mntmModificarColorDe = new JMenuItem("Modificar Color de Coche");
		mntmModificarColorDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.concesionario.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "No hay coches en el concesionario..", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				modificarColorCoche.limpiarCampos();
				modificarColorCoche.setVisible(true);
			}
		});
		mntmModificarColorDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnConcesionario.add(mntmModificarColorDe);
		mntmContarCoches.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnConcesionario.add(mntmContarCoches);

		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setMnemonic('M');
		mnMostrar.setIcon(new ImageIcon(Principal.class.getResource("/img/mostrar-menu.png")));
		menuBar.add(mnMostrar);

		JMenuItem mntmMostrarCoches = new JMenuItem("Mostrar Concesionario");
		mntmMostrarCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.concesionario.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "No hay coches en el concesionario..", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				mostrarConcesionario.actualizar();
				mostrarConcesionario.setVisible(true);
			}
		});
		mntmMostrarCoches.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK));
		mnMostrar.add(mntmMostrarCoches);

		JMenuItem mntmMostrarCoche = new JMenuItem("Mostrar Coche");
		mntmMostrarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.concesionario.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "No hay coches en el concesionario..", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				mostrarCoche.limpiarCampos();
				mostrarCoche.setVisible(true);
			}
		});
		mntmMostrarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_MASK));
		mnMostrar.add(mntmMostrarCoche);
		JMenuItem mntmMostrarCochesPorColor = new JMenuItem("Mostrar Coches por Color");
		mntmMostrarCochesPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.concesionario.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "No hay coches en el concesionario..", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				mostrarCochesPorColor.limpiarCampos();
				mostrarCochesPorColor.setVisible(true);
			}
		});
		mntmMostrarCochesPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK));
		mnMostrar.add(mntmMostrarCochesPorColor);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		mnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/img/ayuda-menu.png")));
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mnAyuda.add(mntmAyuda);
	}

	/**
	 * M&eacute;todo usado cuando se intenta cerrar la ventana con la X del
	 * sistema operativo.
	 */
	private void guardarCerrarVentana() {
		int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el concesionario?");
		if (opcion == 0) {
			JFileChooser guardar = new JFileChooser();
			guardar.setFileFilter(filtro);
			opcion = guardar.showSaveDialog(this);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				file = guardar.getSelectedFile();
				try {
					Fichero.guardar(Gestion.concesionario, file);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (opcion == JFileChooser.CANCEL_OPTION)
				nuevo.setVisible(false);
		} else if (opcion == 2) {
			nuevo.setVisible(false);
		} else
			System.exit(0);
	}

	/**
	 * M&eacute;todo para generar un nuevo concesionario preguntando si desea
	 * guardar el concesionario si &eacute;ste no estuviera guardado
	 * previamente.
	 */
	private void nuevo() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el concesionario?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(Gestion.concesionario, file);
						Gestion.setModificado(false);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION)
					nuevo.setVisible(false);
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else {
				Gestion.setModificado(false);
				reiniciarConcesionario();
			}
		} else {
			Gestion.setModificado(false);
			reiniciarConcesionario();
		}
	}

	/**
	 * Reinicia el concesionario creando uno nuevo y cambiando el t&iacute;tulo
	 * de la ventana.
	 */
	private void reiniciarConcesionario() {
		Gestion.concesionario = new Concesionario();
		setTitle("Sin Título - Concesionario IES Gran Capitán");
	}

	/**
	 * Gesti&oacute;n al accionar Abrir en el men&uacute;.
	 */
	private void actionAbrir() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el concesionario?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(Gestion.concesionario, file);
						Gestion.setModificado(false);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION) {
					nuevo.setVisible(false);
				}
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else {
				Gestion.setModificado(false);
				abrir();
			}
		} else {
			Gestion.setModificado(false);
			abrir();
		}
	}

	/**
	 * Abre un archivo con JFileChooser.
	 */
	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = abrir.getSelectedFile();
			try {
				Gestion.concesionario = (Concesionario) Fichero.abrir(file);
				setTitle(file.getName());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(contentPane, "La información no se ha podido recuperar..", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			Gestion.setModificado(false);
		}
	}

	/**
	 * Guarda un archivo con JFileChooser.
	 */
	private void guardar() {
		if (Gestion.getArchivoSeleccionado() == null) {
			JFileChooser guardar = new JFileChooser();
			guardar.setFileFilter(filtro);
			int opcion = guardar.showSaveDialog(this);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				file = guardar.getSelectedFile();
				try {
					Fichero.guardar(Gestion.concesionario, file);
					setTitle(file.getName());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				Gestion.setModificado(false);
				Gestion.setArchivoSeleccionado(file);
			} else if (opcion == JFileChooser.CANCEL_OPTION)
				nuevo.setVisible(false);
		} else
			try {
				Fichero.guardar(Gestion.concesionario, file);
				Gestion.setModificado(false);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
	}

	/**
	 * Guarda un archivo, pero preguntando d&oacute;nde y su nombre, si el
	 * fichero existe le pregunta&aacute; al usuario si desea sobreescribirlo.
	 */
	private void guardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		guardarComo.setFileFilter(filtro);
		int opcion = guardarComo.showSaveDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = guardarComo.getSelectedFile();
			try {
				if (deseaSobreescribir()) {
					Fichero.guardar(Gestion.concesionario, file);
					setTitle(file.getName());
					Gestion.setModificado(false);
				}
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * M&eacute;todo para preguntar si desea sobreescribir el archivo ya
	 * existente.
	 * 
	 * @return devuelve true si el usuario desea sobreescribirlo, false de lo
	 *         contrario. Si no existiese devolver&iacute;a true.
	 */
	private boolean deseaSobreescribir() {
		if (file.exists()) {
			int sobreescribir = JOptionPane.showConfirmDialog(nuevo, "¿Deseas sobrescribir el archivo?");
			if (sobreescribir == 0) {
				return true;
			} else {
				nuevo.setVisible(false);
				return false;
			}
		}
		return true;
	}

	/**
	 * M&eacute;todo para el men&uacute; salir.
	 */
	private void salir() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el concesionario?");
			if (opcion == 0) {
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(Gestion.concesionario, file);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "El archivo no se ha encontrado..", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, "Error de Entrada/Salida..", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION)
					nuevo.setVisible(false);
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else
				nuevo.setVisible(false);
		} else
			System.exit(0);
	}
}
