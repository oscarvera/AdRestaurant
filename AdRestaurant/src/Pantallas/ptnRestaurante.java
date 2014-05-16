package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import Clases.Cliente;
import Clases.Restaurante;
public class ptnRestaurante extends JFrame {

	private JFrame frame;
	Cliente clie;
	Restaurante rest;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ptnRestaurante(Cliente clie, Restaurante rest) {
		this.clie=clie;
		this.rest=rest;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 94, 895, 481);
		frame.getContentPane().add(panel);
		
		JLabel lblReservaEn = new JLabel("Reserva en:");
		lblReservaEn.setForeground(Color.LIGHT_GRAY);
		lblReservaEn.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel(rest.getNombre());
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 32));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(219)
					.addComponent(lblReservaEn)
					.addGap(36)
					.addComponent(lblNewLabel)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReservaEn)
						.addComponent(lblNewLabel))
					.addContainerGap(376, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(21, 9, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(599, 18, 128, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBienvenido.setBackground(Color.YELLOW);
		lblBienvenido.setBounds(384, 19, 86, 64);
		frame.getContentPane().add(lblBienvenido);
		
		JButton btnCerrarsesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarsesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarsesion.setForeground(Color.WHITE);
		btnCerrarsesion.setBackground(new Color(255, 153, 51));
		btnCerrarsesion.setBounds(737, 40, 128, 23);
		frame.getContentPane().add(btnCerrarsesion);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
