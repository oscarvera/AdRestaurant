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


public class Salir extends JPanel{

	private JFrame frame;
	private JButton btnSi;
	private JButton btnNo;
	Cliente clie;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Salir(Cliente c) {
		clie=c;
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
		
		
		JLabel lblSalir = new JLabel("\u00BFSeguro que deseas SALIR?");
		lblSalir.setBounds(288, 251, 343, 64);
		lblSalir.setForeground(new Color(255, 255, 255));
		lblSalir.setBackground(new Color(255, 255, 0));
		lblSalir.setFont(new Font("Fira Sans OT", Font.PLAIN, 26));
		frame.getContentPane().add(lblSalir);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 514, 895, 93);
		frame.getContentPane().add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 895, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 93, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_1);
		
	
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(870, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
		);
	
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Salir.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel.setBounds(107, 72, 680, 110);
		frame.getContentPane().add(lblNewLabel);
		
	
		
		btnNo = new JButton("NO");
		btnNo.setBounds(509, 385, 227, 37);
		frame.getContentPane().add(btnNo);
		btnNo.setBackground(new Color(255, 255, 255));
		btnNo.setForeground(new Color(255, 153, 51));
		btnNo.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menucliente=new MenuCliente(clie);
				frame.dispose();
			}
		});
		frame.setVisible(true);
		
		btnSi = new JButton("SI");
		btnSi.setBounds(180, 385, 227, 37);
		frame.getContentPane().add(btnSi);
		btnSi.setBackground(new Color(255, 255, 255));
		btnSi.setForeground(new Color(255, 153, 51));
		btnSi.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		frame.setVisible(true);
		
	
	}
}
