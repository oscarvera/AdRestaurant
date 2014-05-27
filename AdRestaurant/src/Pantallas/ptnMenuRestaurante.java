package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import BBDD.Consulta;
import Clases.Restaurante;

public class ptnMenuRestaurante extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	Restaurante rest;
	static Locale currentLocale;
    static ResourceBundle messages;
	
	/**
	 * Create the frame.
	 */
	public ptnMenuRestaurante(Restaurante rest,ResourceBundle messages){
		this.rest=rest;
		this.messages=messages;
		initialize();
	}
	
	private void initialize() {
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
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton(messages.getString("Perfil"));
		btnNewButton_1.setBounds(182, 68, 232, 345);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ptnRestaurante ptnrest=new ptnRestaurante(rest, messages);
				frame.dispose();
			}
		});
		
		JButton button = new JButton(messages.getString("Reservas"));
		button.setBounds(487, 68, 232, 345);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptnBuscarReservasRestaurante reser=new ptnBuscarReservasRestaurante(rest, messages);
				frame.dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setBounds(870, 0, 25, 22);
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		panel_1.add(cerrarImage);
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
				Consulta c = rest.getConexionConsulta();
				Salir salir=new Salir(messages, c);
			}
		});
		
		
		
		
		
		JLabel lblnomUser = new JLabel(rest.getNombre());
		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(500, 33, 239, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBienvenido = new JLabel(messages.getString("WLCOME1"));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBienvenido.setBackground(Color.YELLOW);
		lblBienvenido.setBounds(379, 33, 86, 64);
		frame.getContentPane().add(lblBienvenido);
		
		JButton btnCerrarsesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarsesion.setFocusable(false);
		btnCerrarsesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarsesion.setForeground(Color.WHITE);
		btnCerrarsesion.setBackground(new Color(255, 153, 51));
		btnCerrarsesion.setBounds(757, 55, 128, 23);
		frame.getContentPane().add(btnCerrarsesion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/TituloPEQUE.png")));
		lblNewLabel.setBounds(-18, 33, 393, 64);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
