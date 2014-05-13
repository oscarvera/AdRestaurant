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

import Clases.Cliente;

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);


		JLabel lblBienvenid = new JLabel("BIENVENID@");
		lblBienvenid.setBounds(380, 180, 135, 64);
		lblBienvenid.setForeground(new Color(255, 255, 255));
		lblBienvenid.setBackground(new Color(255, 255, 0));
		lblBienvenid.setFont(new Font("Fira Sans OT", Font.PLAIN, 22));
		frame.getContentPane().add(lblBienvenid);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblUsuario.setBounds(237, 281, 100, 22);
		frame.getContentPane().add(lblUsuario);

		textLabelUser = new JTextField();
		textLabelUser.setToolTipText("Introduzca su Nombre de Usuario");
		textLabelUser.setColumns(10);
		textLabelUser.setBounds(334, 270, 227, 37);
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
		panel.setBounds(0, 514, 895, 93);
		frame.getContentPane().add(panel);

		btnRegistrar = new JButton("REGISTRATE");
		btnRegistrar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnRegistrar.setToolTipText("Simple y cómodo, REGISTRATE AHORA!");
		btnRegistrar.setBackground(new Color(255, 153, 51));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro regcli=new Registro();
				frame.dispose();

			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/QuieresReg.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(121)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(239))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(27))
		);
		panel.setLayout(gl_panel);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setForeground(new Color(255, 153, 51));
		btnIngresar.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final Cliente clie;
				clie=new Clases.Cliente(textLabelUser.getText());
				MenuCliente menuclie=new MenuCliente(clie);
				frame.dispose();

			}
		});
		btnIngresar.setBounds(334, 374, 227, 37);
		btnIngresar.setEnabled(false);
		frame.getContentPane().add(btnIngresar);


		textLabelPass = new JPasswordField();
		textLabelPass.setToolTipText("Introduzca su contraseña");
		textLabelPass.setBounds(334, 321, 227, 37);
		frame.getContentPane().add(textLabelPass);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_1);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(870, Short.MAX_VALUE)
					.addComponent(cerrarImage)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(cerrarImage, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
		);
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
				int eleccion=JOptionPane.showConfirmDialog(frame,"¿Seguro que desea salir?");
				if(eleccion==0){
				System.exit(0);
				}

			}
		});

		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel.setBounds(107, 72, 680, 110);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		textLabelPass.addKeyListener(kl);
}
}