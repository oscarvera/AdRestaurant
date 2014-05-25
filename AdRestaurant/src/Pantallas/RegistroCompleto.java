package Pantallas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import BBDD.Consulta;


public class RegistroCompleto extends JPanel{

	private JFrame frame;
	private Consulta consulta;
	Locale currentLocale;
    ResourceBundle messages;
	/**
	 * Create the application.
	 */
	public RegistroCompleto(ResourceBundle messages, Consulta c) {
		this.messages=messages;
		this.consulta=c;
		initialize();
	}

	/**
	 *  Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		botonesRegistroCompleto();
		botonX();
	}
	
		/**
		 * Todos los botones de la pantalla RegistroCompleto
		 */
		public void botonesRegistroCompleto(){
		JButton btnIniciarSesion = new JButton(messages.getString("IS"));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setForeground(new Color(255, 153, 51));
		btnIniciarSesion.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnIniciarSesion.setBounds(316, 415, 227, 37);
		frame.getContentPane().add(btnIniciarSesion);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegistroCompleto.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel_1.setBounds(90, 65, 699, 97);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 224, 895, 160);
		frame.getContentPane().add(panel);
		
		JLabel lblRC = new JLabel(messages.getString("RC"));
		lblRC.setHorizontalAlignment(SwingConstants.CENTER);
		lblRC.setForeground(new Color(255, 153, 0));
		lblRC.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 39));
		lblRC.setBounds(0, 45, 895, 44);
		panel.add(lblRC);
		
		JLabel lblTL = new JLabel(messages.getString("TL"));
		lblTL.setHorizontalAlignment(SwingConstants.CENTER);
		lblTL.setForeground(new Color(255, 153, 0));
		lblTL.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblTL.setBounds(10, 89, 875, 28);
		panel.add(lblTL);
		frame.setVisible(true);
		}
		/**
		 *Botón X para Salir de la aplicación con pequeño JPanel Blanco
		 */
		public void botonX(){
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setBounds(872, 0, 23, 22);
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		panel_1.add(cerrarImage);
		cerrarImage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Salir salir=new Salir(messages, consulta);

			}
		});
	}
}
