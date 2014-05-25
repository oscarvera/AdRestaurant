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
public class ptnRestaurante extends JFrame {

	private JFrame frame;
	Cliente clie;
	Restaurante rest;
	JButton btnReservar;
	private JFrame frameBusqueda;
	static Locale currentLocale;
	static ResourceBundle messages;

	Connection conexion = null;

	/**
	 * Launch the application.
	 */


	/**
	 *  Create the frame.
	 * @throws SQLException 
	 * @wbp.parser.constructor
	 */

	/**
	 * Constructor desde menu cliente o desde lista
	 * @param clie
	 * @param rest
	 * @param messages
	 */
	public ptnRestaurante(final Cliente clie, final Restaurante rest,final ResourceBundle messages){
		this.clie=clie;
		this.rest=rest;
		this.messages=messages;
		iniciar();
	}
	/**
	 * Constructor desde menu restaurante 
	 * @param rest
	 * @param messages
	 * @wbp.parser.constructor
	 */
	public ptnRestaurante(final Restaurante rest,final ResourceBundle messages) {
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
		botonX();
		botonesptnRestaurante();
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
	 * Todos los botones de la pantalla ptnRestaurante
	 */
	public void botonesptnRestaurante(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 94, 895, 529);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel(rest.getNombre());
		lblNewLabel.setBounds(42, 29, 724, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));

		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(22, 88, 360, 235);
		lblImagen.setIcon(new ImageIcon(ptnRestaurante.class.getResource("/Imagen/olawu.jpg")));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 359, 846, 164);

		JLabel lblNewLabel_1 = new JLabel(messages.getString("Comentarios"));
		lblNewLabel_1.setBounds(22, 334, 128, 19);
		lblNewLabel_1.setForeground(new Color(255, 153, 0));
		lblNewLabel_1.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 18));

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(386, 88, 507, 235);
		panel_11.setBackground(new Color(255, 255, 255));

		if(clie!=null){
			btnReservar = new JButton(messages.getString("Reservar"));
			btnReservar.setFocusable(false);
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ptnCrearReserva creaReser=new ptnCrearReserva(clie, rest, messages);
					frame.dispose();
				}
			});
			btnReservar.setBounds(745, 29, 108, 36);
			btnReservar.setForeground(new Color(255, 153, 0));
			btnReservar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
			btnReservar.setBackground(null);
			panel.add(btnReservar);
		}

		JLabel lbTipo = new JLabel(messages.getString("Tipo"));
		lbTipo.setBounds(10, 28, 109, 22);
		lbTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTipo.setForeground(Color.LIGHT_GRAY);
		lbTipo.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textTipo = new JLabel(rest.getTipo());
		textTipo.setBounds(129, 29, 231, 21);
		textTipo.setForeground(new Color(255, 153, 0));
		textTipo.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel lbTelefono = new JLabel(messages.getString("Telefono"));
		lbTelefono.setBounds(10, 95, 109, 22);
		lbTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefono.setForeground(Color.LIGHT_GRAY);
		lbTelefono.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textTelefono = new JLabel(String.valueOf(rest.getTelefono()));
		textTelefono.setBounds(129, 96, 154, 21);
		textTelefono.setForeground(new Color(255, 153, 0));
		textTelefono.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel lbDireccion = new JLabel(messages.getString("Direccion"));
		lbDireccion.setBounds(10, 62, 109, 22);
		lbDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDireccion.setForeground(Color.LIGHT_GRAY);
		lbDireccion.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textDireccion = new JLabel(rest.getDireccion());
		textDireccion.setBounds(129, 61, 246, 21);
		textDireccion.setForeground(new Color(255, 153, 0));
		textDireccion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel lbPoblacion = new JLabel(messages.getString("Poblacion"));
		lbPoblacion.setBounds(10, 128, 109, 22);
		lbPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPoblacion.setForeground(Color.LIGHT_GRAY);
		lbPoblacion.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textPoblacion = new JLabel(rest.getPoblacion());
		textPoblacion.setBounds(129, 128, 154, 21);
		textPoblacion.setForeground(new Color(255, 153, 0));
		textPoblacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel textProvincia = new JLabel(rest.getProvincia());
		textProvincia.setBounds(382, 129, 125, 21);
		textProvincia.setForeground(new Color(255, 153, 0));
		textProvincia.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel lbProvincia = new JLabel(messages.getString("Provincia"));
		lbProvincia.setBounds(258, 128, 117, 22);
		lbProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProvincia.setForeground(Color.LIGHT_GRAY);
		lbProvincia.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel lbCP = new JLabel(messages.getString("CP"));
		lbCP.setBounds(10, 161, 109, 22);
		lbCP.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCP.setForeground(Color.LIGHT_GRAY);
		lbCP.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textCP = new JLabel(rest.getCodigoPostal());
		textCP.setBounds(129, 160, 125, 21);
		textCP.setForeground(new Color(255, 153, 0));
		textCP.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));

		JLabel lbMinusvalidos = new JLabel(messages.getString("AP"));
		lbMinusvalidos.setBounds(10, 194, 199, 22);
		lbMinusvalidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinusvalidos.setForeground(Color.LIGHT_GRAY);
		lbMinusvalidos.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));

		JLabel textMinusvalidos= new JLabel(messages.getString("NO"));
		textMinusvalidos.setBounds(219, 192, 212, 21);
		if(rest.getMinusvalidoApto()){
			textMinusvalidos.setText(messages.getString("SI"));
		}else{
			textMinusvalidos.setText(messages.getString("NO"));
		}


		textMinusvalidos.setForeground(new Color(255, 153, 0));
		textMinusvalidos.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		panel_11.setLayout(null);
		panel_11.add(lbTipo);
		panel_11.add(textTipo);
		panel_11.add(lbTelefono);
		panel_11.add(textTelefono);
		panel_11.add(lbPoblacion);
		panel_11.add(textPoblacion);
		panel_11.add(lbDireccion);
		panel_11.add(textDireccion);
		panel_11.add(lbProvincia);
		panel_11.add(textProvincia);
		panel_11.add(lbCP);
		panel_11.add(textCP);
		panel_11.add(lbMinusvalidos);
		panel_11.add(textMinusvalidos);
		panel.setLayout(null);

		panel.add(lblImagen);
		panel.add(panel_11);
		panel.add(lblNewLabel_1);
		panel.add(scrollPane);
		panel.add(lblNewLabel);



		Consulta consul=new Consulta(messages);
		conexion=(Connection) consul.getConexion();
		String consulta= "SELECT realizacion FROM reserva WHERE Codigo_Cliente=? AND Codigo_Restaurante=?";
		PreparedStatement stmt;
		ResultSet resultadoConsulta1 = null;
		ResultSet resultadoConsulta2;
		boolean hayComentarios;
		//Dos consultas. Comentarios y boton comentarios
		if(clie!=null){
			boolean puedeComentar=false;
			int siNo=0;
			hayComentarios=false;
			try{
				stmt = conexion.prepareStatement(consulta);
				stmt.setInt(1, clie.getCodigoCliente());
				stmt.setInt(2, rest.getCodigoRestaurante());
				resultadoConsulta2 = stmt.executeQuery();
				while(resultadoConsulta2.next()){


					siNo=resultadoConsulta2.getInt("realizacion");
					System.out.println(""+siNo);
					if(siNo==1){
						consulta= "SELECT Codigo_Cliente FROM comentarios WHERE Codigo_Cliente=? AND Codigo_Restaurante=?";
						stmt = conexion.prepareStatement(consulta);
						stmt.setInt(1, clie.getCodigoCliente());
						stmt.setInt(2, rest.getCodigoRestaurante());
						resultadoConsulta2 = stmt.executeQuery();
						if(resultadoConsulta2.next()){
							puedeComentar=false;
						}else{
							puedeComentar=true;
							System.out.println(""+puedeComentar);
						}


					}
				}
			}


			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Hola");
			}

			JButton btnNuevoComentario = new JButton("Nuevo Comentario");
			btnNuevoComentario.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {


					ptnCrearComentario nuevoComent=new ptnCrearComentario(clie, rest, messages);
					frame.dispose();
				}
			});
			btnNuevoComentario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 11));
			btnNuevoComentario.setForeground(new Color(255, 153, 0));
			btnNuevoComentario.setBounds(160, 334, 150, 19);
			panel.add(btnNuevoComentario);
			if(puedeComentar==false){
				btnNuevoComentario.setEnabled(false);
			}
			btnNuevoComentario.setBackground(null);
		}


		DefaultListModel dlm=new DefaultListModel();
		JList list = new JList();
		list.setBorder(new EmptyBorder(3, 3, 3, 3));
		list.setFont(new Font("Fira Sans OT", Font.PLAIN, 11));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		//LISTAR COMENTARIOS
		consulta= "SELECT cli.usuario, c.fechaCreacion, c.txtComentario FROM comentarios c INNER JOIN clientes cli on cli.codigoCliente=c.Codigo_Cliente WHERE Codigo_Restaurante=?";
		try {
			stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, rest.getCodigoRestaurante());
			resultadoConsulta1 = stmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String usuario;
		String fechacreacion;
		String text;
		hayComentarios=false;
		try {
			while(resultadoConsulta1.next()){
				usuario=resultadoConsulta1.getString("usuario");
				if(resultadoConsulta1.getInt("fechaCreacion")!=0000-00-00){
					fechacreacion=resultadoConsulta1.getString("fechaCreacion");
				}else{
					fechacreacion="null";
				}
				text=resultadoConsulta1.getString("txtComentario");
				String reserva="<html><div width=600px><font color=silver size=5>"+usuario+" </font>     <font color=silver size=3>  "+fechacreacion+"</font><br><font size=4>"+text+"</font><br></html>";
				dlm.addElement(reserva);
				hayComentarios=true;

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(hayComentarios==false){
			String reserva="<html>No hay comentarios en este restaurante<br><font color=silver>Te proponemos ir al restaurante, probarlo y opinar sobre él</font></html>";
			dlm.addElement(reserva);
		}
		list.setModel(dlm);
		if(clie!=null){
			JLabel lblnomUser = new JLabel(clie.getNombre());
			lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
			lblnomUser.setForeground(Color.WHITE);
			lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
			lblnomUser.setBackground(Color.YELLOW);
			lblnomUser.setBounds(486, 19, 241, 79);
			frame.getContentPane().add(lblnomUser);
		}else{
			JLabel lblnomUser = new JLabel(rest.getNombre());
			lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
			lblnomUser.setForeground(Color.WHITE);
			lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
			lblnomUser.setBackground(Color.YELLOW);
			lblnomUser.setBounds(486, 19, 241, 79);
			frame.getContentPane().add(lblnomUser);

		}

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
				if(clie!=null){
					MenuCliente menuclie=new MenuCliente(clie, messages);
					frame.dispose();
				}else{
					ptnMenuRestaurante menurest=new ptnMenuRestaurante(rest, messages);
				}

			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		button.setBackground(new Color(255, 153, 0));
		button.setBounds(31, 623, 171, 23);
		frame.getContentPane().add(button);


		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ptnRestaurante.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-11, 19, 393, 79);
		frame.getContentPane().add(label);

		JButton btnVolverBusqueda = new JButton("Volver a la b\u00FAsqueda");
		btnVolverBusqueda.setBounds(212, 623, 89, 23);
		frame.getContentPane().add(btnVolverBusqueda);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		btnVolverBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frameBusqueda.setEnabled(true);
				frameBusqueda.setVisible(true);
			}
		});

	}

	public void setFrameBusqueda(JFrame f){
		this.frameBusqueda=f;
	}
}


