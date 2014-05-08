import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegistroRestaurante extends JPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPasswordField pwdJio;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRestaurante window = new RegistroRestaurante();
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
	public RegistroRestaurante() {
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
		frame.setLocationRelativeTo(null);
		
		JLabel lblAdrestaurant = new JLabel("AdRestaurant");
		lblAdrestaurant.setBounds(170, 33, 563, 93);
		lblAdrestaurant.setForeground(new Color(255, 255, 255));
		lblAdrestaurant.setBackground(new Color(255, 255, 255));
		lblAdrestaurant.setFont(new Font("Francois One", Font.PLAIN, 90));
		frame.getContentPane().add(lblAdrestaurant);
		
		JButton btnNewButton = new JButton("CLIENTE");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RegistroCliente regClie=new RegistroCliente();
			frame.dispose();
			}
		});
		btnNewButton.setBounds(165, 137, 263, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRestaurante = new JButton("RESTAURANTE");
		btnRestaurante.setEnabled(false);
		btnRestaurante.setForeground(new Color(255, 153, 51));
		btnRestaurante.setBackground(new Color(255, 255, 255));
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
		lblNombreUsuario.setBounds(54, 180, 155, 22);
		panel.add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 180, 197, 22);
		panel.add(textField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 153, 51));
		lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblContrasea.setBounds(54, 213, 155, 22);
		panel.add(lblContrasea);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 153, 0));
		lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblEmail.setBounds(54, 246, 155, 22);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 246, 197, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 60, 197, 22);
		panel.add(textField_3);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setForeground(new Color(255, 153, 0));
		lblNombre_1.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombre_1.setBounds(54, 60, 155, 22);
		panel.add(lblNombre_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 93, 197, 22);
		panel.add(textField_4);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setForeground(new Color(255, 153, 51));
		lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPrimerApellido.setBounds(54, 93, 155, 22);
		panel.add(lblPrimerApellido);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(219, 126, 197, 22);
		panel.add(textField_5);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setForeground(new Color(255, 153, 0));
		lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblSegundoApellido.setBounds(54, 126, 169, 22);
		panel.add(lblSegundoApellido);
		
		JButton btnNewButton_1 = new JButton("RESGISTRARSE");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroCompleto regCom=new RegistroCompleto();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(332, 293, 210, 33);
		panel.add(btnNewButton_1);
		
		JLabel lblPersonal = new JLabel("PERSONAL");
		lblPersonal.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		lblPersonal.setForeground(new Color(255, 153, 0));
		lblPersonal.setBounds(190, 22, 105, 27);
		panel.add(lblPersonal);
		
		JLabel lblRestaurante = new JLabel("RESTAURANTE");
		lblRestaurante.setForeground(new Color(255, 153, 0));
		lblRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		lblRestaurante.setBounds(607, 22, 138, 27);
		panel.add(lblRestaurante);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setForeground(new Color(255, 153, 51));
		lblCiudad.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblCiudad.setBounds(476, 180, 155, 22);
		panel.add(lblCiudad);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(641, 180, 197, 22);
		panel.add(textField_6);
		
		JLabel lblPais = new JLabel("C\u00F3digo Postal:");
		lblPais.setForeground(new Color(255, 153, 51));
		lblPais.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPais.setBounds(476, 213, 155, 22);
		panel.add(lblPais);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(641, 213, 197, 22);
		panel.add(textField_7);
		
		JLabel lblNumeroRef = new JLabel("N\u00FAmero Ref.:");
		lblNumeroRef.setForeground(new Color(255, 153, 0));
		lblNumeroRef.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNumeroRef.setBounds(476, 246, 155, 22);
		panel.add(lblNumeroRef);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(641, 246, 197, 22);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(641, 60, 197, 22);
		panel.add(textField_9);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 153, 0));
		lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombre.setBounds(476, 60, 155, 22);
		panel.add(lblNombre);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(641, 93, 197, 22);
		panel.add(textField_10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(new Color(255, 153, 51));
		lblDireccin.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblDireccin.setBounds(476, 93, 155, 22);
		panel.add(lblDireccin);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 153, 0));
		lblTipo.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblTipo.setBounds(476, 126, 169, 22);
		panel.add(lblTipo);
		
		pwdJio = new JPasswordField();
		pwdJio.setBounds(219, 213, 197, 20);
		panel.add(pwdJio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige un tipo", "Chino", "Japon\u00E9s", "Mexicano", "Italiano", "Espa\u00F1ol", "Alem\u00E1n", "Estadounidense"}));
		comboBox.setBounds(641, 127, 197, 22);
		panel.add(comboBox);
		
		JLabel lblyaEstaRegistrado = new JLabel("\u00BFYa est\u00E1s registrado?");
		lblyaEstaRegistrado.setForeground(new Color(255, 255, 255));
		lblyaEstaRegistrado.setFont(new Font("Fira Sans OT", Font.PLAIN, 16));
		lblyaEstaRegistrado.setBackground(new Color(255, 153, 51));
		lblyaEstaRegistrado.setBounds(182, 564, 216, 34);
		frame.getContentPane().add(lblyaEstaRegistrado);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
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
		frame.setVisible(true);
	}
}
