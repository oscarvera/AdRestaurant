package Pantallas;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Clases.Cliente;

public class MenuCliente {

	private JFrame frame;
	Cliente clie;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente window = new MenuCliente();
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
	public MenuCliente(Cliente clie) {
		this.clie=clie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 86, 889, 481);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarRestaurante busRest=new BuscarRestaurante(clie);
				frame.dispose();
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/Boton1.png")));
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comentarios comen=new Comentarios(clie);
				frame.dispose();
			}
		});
		button.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/ComentsBoton.png")));
		//button.setIcon(new ImageIcon("C:\\Users\\dam1\\Desktop\\boton2.png"));
		
		JButton button_1 = new JButton("New button");
		button_1.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/reservas.png")));
		//button_1.setIcon(new ImageIcon("C:\\Users\\dam1\\Desktop\\reservas.png"));
		
		JButton btnPerfilCliente = new JButton("Perfil Cliente?");
		
		JLabel label_1 = new JLabel("");
		
		JButton btnBoton = new JButton("Boton2");
		
		JButton button_2 = new JButton("Boton2");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button, 0, 0, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnPerfilCliente, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBoton, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 185, Short.MAX_VALUE)
						.addComponent(button_1, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(btnBoton, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(btnPerfilCliente, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(22, 1, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT", Font.PLAIN, 20));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(674, 11, 128, 64);
		frame.getContentPane().add(lblnomUser);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 153, 51));
		btnNewButton_1.setBounds(802, 34, 66, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
}
