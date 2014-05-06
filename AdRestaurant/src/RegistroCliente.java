import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;


public class RegistroCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente window = new RegistroCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public RegistroCliente() {
		initialize();
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdrestaurant = new JLabel("AdRestaurant");
		lblAdrestaurant.setBounds(170, 33, 563, 93);
		lblAdrestaurant.setForeground(new Color(255, 255, 255));
		lblAdrestaurant.setBackground(new Color(255, 255, 255));
		lblAdrestaurant.setFont(new Font("Francois One", Font.PLAIN, 90));
		frame.getContentPane().add(lblAdrestaurant);
		
		JButton btnNewButton = new JButton("CLIENTE");
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(new Color(255, 153, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(165, 137, 263, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRestaurante = new JButton("RESTAURANTE");
		btnRestaurante.setForeground(new Color(255, 255, 255));
		btnRestaurante.setBackground(new Color(255, 153, 0));
		btnRestaurante.setBounds(428, 137, 263, 36);
		frame.getContentPane().add(btnRestaurante);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 194, 889, 348);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setForeground(new Color(255, 153, 51));
		lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombreUsuario.setBounds(258, 173, 155, 22);
		panel.add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(423, 173, 197, 22);
		panel.add(textField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 153, 51));
		lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblContrasea.setBounds(258, 206, 155, 22);
		panel.add(lblContrasea);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 153, 0));
		lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblEmail.setBounds(258, 239, 155, 22);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(423, 239, 197, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(423, 46, 197, 22);
		panel.add(textField_3);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 153, 0));
		lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombre.setBounds(258, 46, 155, 22);
		panel.add(lblNombre);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(423, 85, 197, 22);
		panel.add(textField_4);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setForeground(new Color(255, 153, 51));
		lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPrimerApellido.setBounds(258, 85, 155, 22);
		panel.add(lblPrimerApellido);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(423, 121, 197, 22);
		panel.add(textField_5);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setForeground(new Color(255, 153, 0));
		lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblSegundoApellido.setBounds(258, 121, 169, 22);
		panel.add(lblSegundoApellido);
		
		JButton btnNewButton_1 = new JButton("RESGISTRARSE");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(332, 293, 210, 33);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(423, 206, 197, 20);
		panel.add(passwordField);
		
		JLabel lblyaEstaRegistrado = new JLabel("\u00BFYa est\u00E1s registrado?");
		lblyaEstaRegistrado.setForeground(new Color(255, 255, 255));
		lblyaEstaRegistrado.setFont(new Font("Fira Sans OT", Font.PLAIN, 16));
		lblyaEstaRegistrado.setBackground(new Color(255, 153, 51));
		lblyaEstaRegistrado.setBounds(182, 564, 216, 34);
		frame.getContentPane().add(lblyaEstaRegistrado);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnIniciarSesin.setForeground(Color.WHITE);
		btnIniciarSesin.setBackground(new Color(255, 153, 51));
		btnIniciarSesin.setBounds(53, 573, 119, 19);
		frame.getContentPane().add(btnIniciarSesin);
		
		JLabel lblInformacionSobreUsuarios = new JLabel("Informaci\u00F3n sobre usuarios");
		lblInformacionSobreUsuarios.setForeground(Color.WHITE);
		lblInformacionSobreUsuarios.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		lblInformacionSobreUsuarios.setBackground(new Color(255, 153, 51));
		lblInformacionSobreUsuarios.setBounds(684, 565, 185, 34);
		frame.getContentPane().add(lblInformacionSobreUsuarios);
		
		//frame.setVisible(true);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
}
