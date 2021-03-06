package Pantallas;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import Clases.Cliente;
import Clases.Restaurante;


public class ptnReservaCompletada extends JPanel{
	Cliente clie;
	Restaurante rest;
	static Locale currentLocale;
	static ResourceBundle messages;

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ptnReservaCompletada(Cliente clie, Restaurante rest, ResourceBundle messages) {
		this.messages=messages;
		this.rest=rest;
		this.clie=clie;
		initialize();
	}

	/**
	 *  Initialize the contents of the frame.
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
		botonesptnReservaCompletada();
	}
	/**
	 *Bot�n X para Salir de la aplicaci�n con peque�o JPanel Blanco
	 */
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
	/**
	 * Todos los botones de la pantalla ptnReservaCompletada
	 */
	public void botonesptnReservaCompletada(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 224, 895, 160);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel ReservaCompleta = new JLabel(messages.getString("ReservaCompletada"));
		ReservaCompleta.setForeground(new Color(255, 153, 0));
		ReservaCompleta.setHorizontalAlignment(SwingConstants.CENTER);
		ReservaCompleta.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 39));
		ReservaCompleta.setBounds(0, 45, 895, 44);
		panel.add(ReservaCompleta);

		JLabel lblNewLabel_2 = new JLabel(messages.getString("ReservaCreada"));
		lblNewLabel_2.setForeground(new Color(255, 153, 0));
		lblNewLabel_2.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 89, 875, 28);
		panel.add(lblNewLabel_2);

		JButton btnIniciarSesion = new JButton(messages.getString("VolverMenuPrincipal"));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setForeground(new Color(255, 153, 51));
		btnIniciarSesion.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuCliente(clie, messages);
				frame.dispose();
			}
		});
		btnIniciarSesion.setBounds(316, 415, 227, 37);
		frame.getContentPane().add(btnIniciarSesion);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegistroCompleto.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel_1.setBounds(90, 65, 699, 97);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
	}
}
