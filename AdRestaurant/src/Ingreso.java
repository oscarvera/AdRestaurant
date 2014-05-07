import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Ingreso extends JPanel{

	private JFrame frame;
	private JTextField txtN;
	private JPasswordField pwdKp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso window = new Ingreso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ingreso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenid = new JLabel("BIENVENID@");
		lblBienvenid.setBounds(377, 163, 135, 64);
		lblBienvenid.setForeground(new Color(255, 255, 255));
		lblBienvenid.setBackground(new Color(255, 255, 0));
		lblBienvenid.setFont(new Font("Fira Sans OT", Font.PLAIN, 22));
		frame.getContentPane().add(lblBienvenid);
		
		JLabel lblAdrestaurant = new JLabel("AdRestaurant");
		lblAdrestaurant.setBounds(168, 77, 563, 93);
		lblAdrestaurant.setForeground(new Color(255, 255, 255));
		lblAdrestaurant.setBackground(new Color(255, 255, 255));
		lblAdrestaurant.setFont(new Font("Francois One", Font.PLAIN, 90));
		frame.getContentPane().add(lblAdrestaurant);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblUsuario.setBounds(237, 281, 100, 22);
		frame.getContentPane().add(lblUsuario);
		
		txtN = new JTextField();
		txtN.setToolTipText("Introduzca su Nombre de Usuario");
		txtN.setColumns(10);
		txtN.setBounds(339, 270, 227, 37);
		frame.getContentPane().add(txtN);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblContrasea.setBounds(219, 327, 114, 22);
		frame.getContentPane().add(lblContrasea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 514, 879, 93);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {120, 70, 100, 50, 0, 0};
		gbl_panel.rowHeights = new int[]{28, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblnoEstasRegistrado = new JLabel("\u00BFNo est\u00E1s registrado?");
		lblnoEstasRegistrado.setFont(new Font("Fira Sans OT", Font.PLAIN, 33));
		lblnoEstasRegistrado.setForeground(new Color(255, 153, 51));
		lblnoEstasRegistrado.setBackground(new Color(255, 153, 51));
		GridBagConstraints gbc_lblnoEstasRegistrado = new GridBagConstraints();
		gbc_lblnoEstasRegistrado.fill = GridBagConstraints.BOTH;
		gbc_lblnoEstasRegistrado.insets = new Insets(0, 0, 0, 5);
		gbc_lblnoEstasRegistrado.gridx = 1;
		gbc_lblnoEstasRegistrado.gridy = 1;
		panel.add(lblnoEstasRegistrado, gbc_lblnoEstasRegistrado);
		
		JButton btnNewButton_1 = new JButton("REGISTRARSE");
		btnNewButton_1.setToolTipText("Simple y cómodo, REGISTRATE AHORA!");
		btnNewButton_1.setBackground(new Color(255, 153, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroCliente regcli=new RegistroCliente();
				frame.dispose();
			
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("INGRESAR");
		
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setFont(new Font("Fira Sans OT", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menuclie=new MenuCliente();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(339, 374, 227, 37);
		frame.getContentPane().add(btnNewButton);
		
		pwdKp = new JPasswordField();
		pwdKp.setToolTipText("Introduzca su contraseña");
		pwdKp.setBounds(339, 321, 227, 37);
		frame.getContentPane().add(pwdKp);
		frame.setVisible(true);
	}
}
