package concesionarioCoches.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana Ayuda para el programa de Concesionario.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 */
public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setResizable(false);
		setModal(false);
		setBounds(100, 100, 589, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 330);
		contentPanel.add(scrollPane);

		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setContentType("text/html");
		editor.setText(
				"<h1>Ayuda para Concesionario I.E.S Gran Capit&aacute;n</h1>\r\n<h2>Men&uacute;s implementados:</h2>\r\n<ol>\r\n\t<li>Men&uacute; Archivo contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Nuevo (Tecla de acceso r&aacute;pido Ctrl+N): Crea un nuevo concesionario de coches, pidiendo guardar si hubo alg&uacute;n concesionario anterior sin guardar.</li>\r\n\t\t<li>Abrir (Tecla de acceso r&aacute;pido Ctrl+O): Abre un archivo que contenga un concesionario previamente guardado, debe contener la extensi&oacute;n .obj</li>\r\n\t\t<li>Guardar (Tecla de acceso r&aacute;pido Ctrl+G): Guarda un concesionario en la carpeta que le indiques si no existiese tal archivo, de ser as&iacute; se guardar&aacute; automaticamente.</li>\r\n\t\t<li>Guardar como: Guarda un concesionario en la carpeta que le indiques.</li>\r\n\t\t<li>Salir: Sale del programa.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Concesionario contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>A&ntilde;adir Coche (Tecla de acceso r&aacute;pido Ctrl+A): A&ntilde;ade un coche al concesionario de I.E.S Gran Capit&aacute;n, pidiendo su matr&iacute;cula, color, marca y modelo.</li>\r\n\t\t<li>Eliminar Coche (Tecla de acceso r&aacute;pido Ctrl+D): Elimina un coche del concesionario por su matr&iacute;cula.</li>\r\n\t\t<li>Modificar color de Coche (Tecla de acceso r&aacute;pido Ctrl+M): Modifica el color del coche mostrado por matr&iacute;cula.</li>\r\n\t\t<li>Contar Coches (Tecla de acceso r&aacute;pido Ctrl+C): Cuenta los coches del concesionario.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Mostrar contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Mostrar Concesionario (Tecla de acceso r&aacute;pido Mayus+A): Muestra los coches existentes en el concesionario con su matr&iacute;cula, color, marca y modelo.</li>\r\n\t\t<li>Mostrar Coche (Tecla de acceso r&aacute;pido Mayus+C): Busca un coche del concesionario por su matr&iacute;cula, mostrando su color, marca y modelo correspondientes.</li>\r\n\t\t<li>Mostrar Coches por Color (Tecla de acceso r&aacute;pido Mayus+S): Busca un coche del concesionario por su color, mostrando su matr&iacute;cula, marca y modelo.</li>\r\n\r\n\t</ul>\r\n\t<li>Men&uacute; Ayuda contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Acerca de..: Muestra informaci&oacute; del creador, su versi&oacute;n y el tipo de licencia que posee el programa.</li>\r\n\t\t<li>Ayuda (Tecla de acceso r&aacute;pido Ctrl+H): Manual de los distintos men&uacute;s que implementa este programa.</li>\r\n\t</ul>\r\n</ol>\r\n");
		scrollPane.setViewportView(editor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
