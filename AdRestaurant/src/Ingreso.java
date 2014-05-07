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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Ingreso extends JPanel{

	private JFrame frame;
	private JTextField textLabelUser;
	private JPasswordField textLabelPass;
	private JButton btnIngresar;
	private JButton btnRegistrar;

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
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setUndecorated(true);
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
		
		textLabelUser = new JTextField();
		textLabelUser.setToolTipText("Introduzca su Nombre de Usuario");
		textLabelUser.setColumns(10);
		textLabelUser.setBounds(339, 270, 227, 37);
		frame.getContentPane().add(textLabelUser);
		KeyListener kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {	
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!textLabelUser.getText().isEmpty()&&!textLabelPass.getText().isEmpty()){
				btnIngresar.setEnabled(true);
			}else{
				btnIngresar.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		};
		textLabelUser.addKeyListener(kl);
		
		JLabel lblPass = new JLabel("CONTRASE\u00D1A:");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPass.setBounds(219, 327, 114, 22);
		frame.getContentPane().add(lblPass);
		
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
		
		btnRegistrar = new JButton("REGISTRARSE");
		btnRegistrar.setToolTipText("Simple y cómodo, REGISTRATE AHORA!");
		btnRegistrar.setBackground(new Color(255, 153, 51));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroCliente regcli=new RegistroCliente();
				frame.dispose();
			
			}
		});
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrar.gridx = 4;
		gbc_btnRegistrar.gridy = 1;
		panel.add(btnRegistrar, gbc_btnRegistrar);
		
		btnIngresar = new JButton("INGRESAR");
		
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setForeground(new Color(255, 153, 51));
		btnIngresar.setFont(new Font("Fira Sans OT", Font.PLAIN, 11));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menuclie=new MenuCliente();
				frame.dispose();
			}
		});
		btnIngresar.setBounds(339, 374, 227, 37);
		btnIngresar.setEnabled(false);
		frame.getContentPane().add(btnIngresar);
		
		
		textLabelPass = new JPasswordField();
		textLabelPass.setToolTipText("Introduzca su contraseña");
		textLabelPass.setBounds(339, 321, 227, 37);
		frame.getContentPane().add(textLabelPass);
		frame.setVisible(true);
		textLabelPass.addKeyListener(kl);
		
	}
}
