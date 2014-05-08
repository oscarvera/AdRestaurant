import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegistroCliente extends JPanel{

	private JFrame frame;
	private JTextField textNomUser;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JPasswordField passUser;
	private JButton BotonRegistrarse;
	private JTextField textField;

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
		frame.setLocationRelativeTo(null);
		
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
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroRestaurante regRest=new RegistroRestaurante();
				frame.dispose();
			}
		});
		btnRestaurante.setForeground(new Color(255, 255, 255));
		btnRestaurante.setBackground(new Color(255, 153, 0));
		btnRestaurante.setBounds(428, 137, 263, 36);
		frame.getContentPane().add(btnRestaurante);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 194, 889, 348);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		KeyListener keyLis =new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!textNombre.getText().isEmpty()&&!textApellido1.getText().isEmpty()&&!textApellido2.getText().isEmpty()&&!textNomUser.getText().isEmpty()&&!textEmail.getText().isEmpty()&&!passUser.getText().isEmpty()){
					BotonRegistrarse.setEnabled(true);
				}else{
					BotonRegistrarse.setEnabled(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setForeground(new Color(255, 153, 51));
		lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombreUsuario.setBounds(258, 145, 155, 22);
		panel.add(lblNombreUsuario);
		
		textNomUser = new JTextField();
		textNomUser.setColumns(10);
		textNomUser.setBounds(423, 145, 197, 22);
		panel.add(textNomUser);
		textNomUser.addKeyListener(keyLis);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 153, 51));
		lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblContrasea.setBounds(258, 178, 155, 22);
		panel.add(lblContrasea);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 153, 0));
		lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblEmail.setBounds(258, 211, 155, 22);
		panel.add(lblEmail);
		
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(423, 211, 197, 22);
		panel.add(textEmail);
		textEmail.addKeyListener(keyLis);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(423, 46, 197, 22);
		panel.add(textNombre);
		textNombre.addKeyListener(keyLis);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 153, 0));
		lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblNombre.setBounds(258, 46, 155, 22);
		panel.add(lblNombre);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(423, 79, 197, 22);
		panel.add(textApellido1);
		textApellido1.addKeyListener(keyLis);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setForeground(new Color(255, 153, 51));
		lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPrimerApellido.setBounds(258, 79, 155, 22);
		panel.add(lblPrimerApellido);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(423, 112, 197, 22);
		panel.add(textApellido2);
		textApellido2.addKeyListener(keyLis);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setForeground(new Color(255, 153, 0));
		lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblSegundoApellido.setBounds(258, 112, 169, 22);
		panel.add(lblSegundoApellido);
		
		BotonRegistrarse = new JButton("RESGISTRARSE");
		BotonRegistrarse.setBackground(new Color(255, 153, 0));
		BotonRegistrarse.setForeground(new Color(255, 255, 255));
		BotonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroCompleto regCom=new RegistroCompleto();
				frame.dispose();
			}
		});
		BotonRegistrarse.setBounds(332, 293, 210, 33);
		BotonRegistrarse.setEnabled(false);
		panel.add(BotonRegistrarse);
		
		
		
		passUser = new JPasswordField();
		passUser.setBounds(423, 178, 197, 22);
		panel.add(passUser);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setForeground(new Color(255, 153, 0));
		lblTelfono.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelfono.setBounds(258, 244, 104, 22);
		panel.add(lblTelfono);
		
		textField = new JTextField();
		textField.setBounds(423, 244, 197, 22);
		panel.add(textField);
		textField.setColumns(10);
		passUser.addKeyListener(keyLis);
		
		JLabel lblyaEstaRegistrado = new JLabel("\u00BFYa est\u00E1s registrado?");
		lblyaEstaRegistrado.setForeground(new Color(255, 255, 255));
		lblyaEstaRegistrado.setFont(new Font("Fira Sans OT", Font.PLAIN, 16));
		lblyaEstaRegistrado.setBackground(new Color(255, 153, 51));
		lblyaEstaRegistrado.setBounds(182, 564, 216, 34);
		frame.getContentPane().add(lblyaEstaRegistrado);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
