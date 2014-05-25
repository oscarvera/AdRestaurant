package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import BBDD.Consulta;
import Clases.Cliente;

import javax.swing.SwingConstants;


public class Salir extends JPanel{

	private JFrame frame;
	private JButton btnSi;
	private JButton btnNo;
	private Cliente clie;
	private Consulta consulta;
	static Locale currentLocale;
	static ResourceBundle messages;

	/**
	 * Create the application.
	 */
	public Salir(ResourceBundle messages, Cliente c) {
		this.messages=messages;
		clie=c;
		initialize();
		this.consulta=clie.getConexionConsulta();
	}
	/**
	 * @wbp.parser.constructor
	 */
	public Salir(ResourceBundle messages, Consulta c) {
		this.messages=messages;
		initialize();
		this.consulta=c;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
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
		botonesSalir();
	}


	/**
	 * Todos los botones de la pantalla Salir
	 */
	public void botonesSalir(){		
		JLabel lblSalir = new JLabel(messages.getString("Seguro?"));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(107, 291, 680, 64);
		lblSalir.setForeground(new Color(255, 255, 255));
		lblSalir.setBackground(new Color(255, 255, 0));
		lblSalir.setFont(new Font("Fira Sans OT", Font.PLAIN, 26));
		frame.getContentPane().add(lblSalir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Salir.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel.setBounds(107, 72, 680, 110);
		frame.getContentPane().add(lblNewLabel);

		btnNo = new JButton(messages.getString("NO"));
		btnNo.setFocusable(false);
		btnNo.setBounds(449, 385, 267, 53);
		frame.getContentPane().add(btnNo);
		btnNo.setBackground(new Color(255, 255, 255));
		btnNo.setForeground(new Color(255, 153, 51));
		btnNo.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(clie!=null){
				//MenuCliente menucliente=new MenuCliente(clie, messages);
				frame.dispose();
				//}else{
				//Ingreso ingreso=new Ingreso();
				//}
			}
		});
		frame.setVisible(true);

		btnSi = new JButton(messages.getString("SI"));
		btnSi.setFocusable(false);
		btnSi.setBounds(173, 385, 277, 53);
		frame.getContentPane().add(btnSi);
		btnSi.setBackground(new Color(255, 255, 255));
		btnSi.setForeground(new Color(255, 153, 51));
		btnSi.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consulta.cerrarConexion();
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}
