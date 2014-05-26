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

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import BBDD.Consulta;
import Clases.Cliente;
import Clases.Restaurante;

import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

public class MenuCliente{

	private JFrame frame;
	Cliente clie;
	Restaurante restaurante;

	static Locale currentLocale;
	static ResourceBundle messages;

	/**
	 *  Create the application.
	 */
	public MenuCliente(Cliente clie, ResourceBundle messages) {
		this.messages=messages;
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
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		botonX();
		botonesMenuCliente();
	}

	public void botonX(){
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
				Salir salir=new Salir(messages, clie);

			}
		});
	}

	public void botonesMenuCliente(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 94, 895, 481);
		frame.getContentPane().add(panel);
		
		JButton btnBuscarRestaurante = new JButton(messages.getString("BuscarRestaurantes"),(new ImageIcon(MenuCliente.class.getResource("/Imagen/BuscarRestaurantes.png"))));
		btnBuscarRestaurante.setForeground(new Color(255, 153, 0));
		btnBuscarRestaurante.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarRestaurante.setFont(new Font("Fira Sans OT", Font.PLAIN, 40));
		btnBuscarRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarRestaurante busRest=new BuscarRestaurante(clie, messages);
				frame.dispose();
			}
		});

		JButton btnComentarios = new JButton(messages.getString("Comentarios1"),(new ImageIcon(MenuCliente.class.getResource("/Imagen/Comentarios.png"))));
		btnComentarios.setForeground(new Color(255, 153, 0));
		btnComentarios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnComentarios.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 40));
		btnComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comentarios comen=new Comentarios(clie, messages);
				frame.dispose();
			}
		});

		JButton btnBuscarReservas = new JButton(messages.getString("BuscarReservas"),(new ImageIcon(MenuCliente.class.getResource("/Imagen/botonReservas.png"))));
		btnBuscarReservas.setForeground(Color.WHITE);
		btnBuscarReservas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarReservas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 24));
		btnBuscarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ptnBuscarReservas reser=new ptnBuscarReservas(clie,messages);
				frame.dispose();
			}
		});

		JLabel label_1 = new JLabel("");

		JButton btnPerfil = new JButton(messages.getString("Perfil"),(new ImageIcon(MenuCliente.class.getResource("/Imagen/perfil.png"))));
		btnPerfil.setForeground(new Color(255, 153, 0));
		btnPerfil.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPerfil.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 40));
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ptnPerfilCliente perfil=new ptnPerfilCliente(clie, messages);
				frame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(99)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnComentarios, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(btnPerfil, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnBuscarRestaurante, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscarReservas, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscarRestaurante, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
						.addComponent(btnBuscarReservas, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(btnPerfil, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnComentarios, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		panel.setLayout(gl_panel);

		JLabel lblnomUser = new JLabel(clie.getNombre());
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
		lblBienvenido.setBounds(379, 33, 128, 64);
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
