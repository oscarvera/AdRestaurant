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

import Pantallas.Ingreso;
import Pantallas.Registro;


public class AntiguoRegistroRestaurante extends JPanel {

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
					AntiguoRegistroRestaurante window = new AntiguoRegistroRestaurante();
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
	public AntiguoRegistroRestaurante() {
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
			Registro regClie=new Registro();
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
		
		JPanel panelRest = new JPanel();
		
		
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
