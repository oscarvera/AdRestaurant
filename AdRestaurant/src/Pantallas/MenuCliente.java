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
import java.util.Locale;
import java.util.ResourceBundle;

import Clases.Cliente;
import Clases.Restaurante;

import javax.swing.SwingConstants;

public class MenuCliente {

	private JFrame frame;
	Cliente clie;
	Restaurante restaurante;
	static Locale currentLocale;
    static ResourceBundle messages;

	/**
	 *  Create the application.
	 */
	public MenuCliente(Cliente clie, ResourceBundle messages) {
		this.clie=clie;
		this.messages=messages;
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
		
		
		
		JButton btnBuscarRestaurante = new JButton("Buscar Restaurante");
		btnBuscarRestaurante.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/Boton1ES.png")));
		btnBuscarRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarRestaurante busRest=new BuscarRestaurante(clie, messages);
				frame.dispose();
			}
		});
		
		
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comentarios comen=new Comentarios(clie, messages);
				frame.dispose();
			}
		});
		
		//button.setIcon(new ImageIcon("C:\\Users\\dam1\\Desktop\\boton2.png"));
		
		JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ptnBuscarReservas reser=new ptnBuscarReservas(clie,messages);
				frame.dispose();
			}
		});
		
		JLabel label_1 = new JLabel("");
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/perfil.png")));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ptnPerfilCliente perfil=new ptnPerfilCliente(clie, messages);
				frame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(99)
							.addComponent(btnBuscarRestaurante, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
					.addGap(101))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPerfil, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_1, 0, 0, Short.MAX_VALUE)
						.addComponent(btnBuscarRestaurante, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(btnPerfil, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		panel.setLayout(gl_panel);
		
		if(messages.getLocale().getLanguage().equals("es")){
			btnPerfil.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/1perfilES.png")));
			btnBuscarRestaurante.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/Boton1ES.png")));
			button.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/ComentsBoton.png")));
			button_1.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/BotonReservasES.png")));
		}else if (messages.getLocale().getLanguage().equals("en")) {
			btnPerfil.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/1perfilEN.png")));
			btnBuscarRestaurante.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/Boton1EN.png")));
			button.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/BotonComentariosEN.png")));
			button_1.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/BotonReservasEN.png")));
		}else if (messages.getLocale().getLanguage().equals("ca")) {
			btnPerfil.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/1perfilCA.png")));
			btnBuscarRestaurante.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/Boton1CA.png")));
			button.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/BotonComentariosCA.png")));
			button_1.setIcon(new ImageIcon(MenuCliente.class.getResource("/Imagen/BotonReservasCA.png")));
		}
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(500, 33, 239, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBienvenido.setBackground(Color.YELLOW);
		lblBienvenido.setBounds(379, 33, 86, 64);
		frame.getContentPane().add(lblBienvenido);
		
		JButton btnCerrarsesion = new JButton("Cerrar Sesi\u00F3n");
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
