package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import BBDD.Consulta;
import Clases.Cliente;
import Clases.Restaurante;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
public class ptnPerfilCliente extends JFrame {

	private JFrame frame;
	Cliente clie;
	Restaurante rest;
	JButton btnReservar;

	static Locale currentLocale;
	static ResourceBundle messages;

	Connection conexion = null;
	private JTextField textNombre;
	private JTextField textPrimerApellido;
	private JTextField textSegundoApellido;
	private JTextField textNombreUsuario;
	private JTextField textEmail;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */


	/**
	 *  Create the frame.
	 * @throws SQLException 
	 * @wbp.parser.constructor
	 */

	/*Constructor desde menu cliente*/
	public ptnPerfilCliente(final Cliente clie,final ResourceBundle messages){
		this.clie=clie;
		this.messages=messages;
		iniciar();

	}
	/*Constructor desde menu restaurante*/
	public ptnPerfilCliente(final Restaurante rest,final ResourceBundle messages) {
		this.rest=rest;
		this.messages=messages;
		iniciar();

	}

	public void iniciar(){
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
		frame.repaint();
		botonX();
		botonesptnPerfilCliente();
	}

	/**
	 *Botón X para Salir de la aplicación con pequeño JPanel Blanco
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
				Salir salir=new Salir(messages);

			}
		});
	}

	/**
	 * Todos los botones de la pantalla botonesptnPerfilCliente
	 */
	public void botonesptnPerfilCliente(){
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 94, 895, 529);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		final JLabel Primer_apellido = new JLabel(clie.getPrimerApellido());
		Primer_apellido.setHorizontalAlignment(SwingConstants.LEFT);
		Primer_apellido.setForeground(new Color(255, 153, 0));
		Primer_apellido.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		Primer_apellido.setBounds(593, 166, 276, 25);
		panel.add(Primer_apellido);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ptnPerfilCliente.class.getResource("/Imagen/perfil.png")));
		lblNewLabel.setBounds(31, 83, 322, 326);
		panel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lblNombre.setBounds(358, 130, 225, 25);
		panel.add(lblNombre);

		final JLabel Nombre = new JLabel(clie.getNombre());
		Nombre.setHorizontalAlignment(SwingConstants.LEFT);
		Nombre.setForeground(new Color(255, 153,0));
		Nombre.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		Nombre.setBounds(593, 129, 251, 25);
		panel.add(Nombre);

		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimerApellido.setForeground(Color.LIGHT_GRAY);
		lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lblPrimerApellido.setBounds(347, 166, 236, 25);
		panel.add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundoApellido.setForeground(Color.LIGHT_GRAY);
		lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lblSegundoApellido.setBounds(374, 202, 209, 25);
		panel.add(lblSegundoApellido);

		final JLabel SegundoApellido = new JLabel(clie.getSegundoApellido());
		SegundoApellido.setHorizontalAlignment(SwingConstants.LEFT);
		SegundoApellido.setForeground(new Color(255, 153, 0));
		SegundoApellido.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		SegundoApellido.setBounds(593, 202, 236, 25);
		panel.add(SegundoApellido);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUsuario.setForeground(Color.LIGHT_GRAY);
		lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lblNombreUsuario.setBounds(358, 257, 225, 25);
		panel.add(lblNombreUsuario);

		final JLabel NombreUsuario = new JLabel(clie.getUsuario());
		NombreUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		NombreUsuario.setForeground(new Color(255, 153, 0));
		NombreUsuario.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		NombreUsuario.setBounds(593, 257, 236, 25);
		panel.add(NombreUsuario);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lblEmail.setBounds(374, 293, 209, 25);
		panel.add(lblEmail);

		JLabel lbTelefono = new JLabel("Tel\u00E9fono:");
		lbTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefono.setForeground(Color.LIGHT_GRAY);
		lbTelefono.setFont(new Font("Fira Sans OT Light", Font.BOLD, 23));
		lbTelefono.setBounds(384, 329, 199, 25);
		panel.add(lbTelefono);

		final JLabel Email = new JLabel(clie.getEmail());
		Email.setHorizontalAlignment(SwingConstants.LEFT);
		Email.setForeground(new Color(255, 153, 0));
		Email.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		Email.setBounds(593, 293, 292, 25);
		panel.add(Email);

		final JLabel Telefono = new JLabel(clie.getTelefono());
		Telefono.setHorizontalAlignment(SwingConstants.LEFT);
		Telefono.setForeground(new Color(255, 153, 0));
		Telefono.setFont(new Font("Fira Sans OT", Font.PLAIN, 25));
		Telefono.setBounds(593, 329, 225, 25);
		panel.add(Telefono);

		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEditar.getText()=="Editar"){

					textNombre = new JTextField();
					textNombre.setBounds(593, 129, 175, 28);
					panel.add(textNombre);
					textNombre.setText(clie.getNombre());
					textNombre.setColumns(10);

					textTelefono = new JTextField();
					textTelefono.setColumns(10);
					textTelefono.setBounds(593, 329, 175, 28);
					textTelefono.setText(clie.getTelefono());
					panel.add(textTelefono);

					textEmail = new JTextField();
					textEmail.setColumns(10);
					textEmail.setBounds(593, 293, 175, 27);
					textEmail.setText(clie.getEmail());
					panel.add(textEmail);


					textSegundoApellido = new JTextField();
					textSegundoApellido.setColumns(10);
					textSegundoApellido.setBounds(593, 202, 175, 28);
					textSegundoApellido.setText(clie.getSegundoApellido());
					panel.add(textSegundoApellido);

					textPrimerApellido = new JTextField();
					textPrimerApellido.setColumns(10);
					textPrimerApellido.setBounds(593, 165, 175, 29);
					textPrimerApellido.setText(clie.getPrimerApellido());
					panel.add(textPrimerApellido);
					frame.repaint();
					btnEditar.setText("Confirmar");

					panel.remove(Telefono);
					panel.remove(Nombre);
					panel.remove(Primer_apellido);
					panel.remove(SegundoApellido);
					panel.remove(Email);

				}else{
					Consulta consul=new Consulta(messages);
					Connection conexion;
					PreparedStatement stmt = null;
					conexion=(Connection) consul.getConexion();

					String consulta = "update clientes set  Nombre=?, primerApellido=?,segundoApellido=?,Email=?,telefono=? where CodigoCliente=?";
					try {
						stmt = conexion.prepareStatement(consulta);
						stmt.setString(1, textNombre.getText());
						stmt.setString(2, textPrimerApellido.getText());
						stmt.setString(3, textSegundoApellido.getText());
						stmt.setString(4, textEmail.getText());
						stmt.setString(5, textTelefono.getText());
						stmt.setInt(6, clie.getCodigoCliente());
						int resultadoConsulta = stmt.executeUpdate();
						clie.actualizar();
						ptnPerfilCliente perfil=new ptnPerfilCliente(clie, messages);
						frame.dispose();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						ErrorRegistro err=new ErrorRegistro("Error en la actualizacion, vuelve a intentarlo más tarde",messages);
						ptnPerfilCliente perfil=new ptnPerfilCliente(clie, messages);
						frame.dispose();
					}



				}











			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnEditar.setFocusable(false);
		btnEditar.setBackground(new Color(255, 153, 0));
		btnEditar.setBounds(557, 401, 171, 23);
		panel.add(btnEditar);

		JLabel lblRestaurante = new JLabel(messages.getString("Restaurante"));
		lblRestaurante.setForeground(Color.WHITE);
		lblRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblRestaurante.setBackground(Color.YELLOW);
		lblRestaurante.setBounds(380, 18, 96, 80);
		frame.getContentPane().add(lblRestaurante);

		JButton btnCerrarsesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarsesion.setFocusable(false);
		btnCerrarsesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingre=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarsesion.setForeground(Color.WHITE);
		btnCerrarsesion.setBackground(new Color(255, 153, 51));
		btnCerrarsesion.setBounds(736, 48, 128, 23);
		frame.getContentPane().add(btnCerrarsesion);


		JButton button = new JButton(messages.getString("VolverMenuPrincipal"));
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menuclie=new MenuCliente(clie, messages);
				frame.dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		button.setBackground(new Color(255, 153, 0));
		button.setBounds(31, 623, 171, 23);
		frame.getContentPane().add(button);


		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ptnPerfilCliente.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-11, 19, 393, 79);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}


