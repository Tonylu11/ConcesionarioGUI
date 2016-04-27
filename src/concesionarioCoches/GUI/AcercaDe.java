package concesionarioCoches.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Acerca del programa.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class AcercaDe extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public AcercaDe() {
		setTitle("Acerca de");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 284, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		textPane.setText(
				"Acerca de Concesionario de Coches IES Gran Capit\u00E1n\r\nVersi\u00F3n: 4.0\r\nCreado por Antonio Luque Bravo\r\nCurso: 1\u00BADAW \r\nCopyright \u00A9 All Right Reserved");
		textPane.setBounds(0, 0, 278, 132);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton atrasButton = new JButton("Atr\u00E1s");
				atrasButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				atrasButton.setActionCommand("Cancel");
				buttonPane.add(atrasButton);
			}
		}
	}
}
