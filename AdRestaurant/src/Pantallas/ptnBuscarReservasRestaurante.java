 package Pantallas;
 
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;


import Clases.Cliente;
import Clases.Restaurante;
 
 public class ptnBuscarReservasRestaurante extends JFrame {
 	Restaurante rest;
 	private JFrame frame;
 	
 	private JButton btnXFecha;
 	private JButton btnXNombre;
 	private JButton btnXCP;
 	private JButton btnXTipo;
 	
 	static Locale currentLocale;
    static ResourceBundle messages;
    
    private DefaultListModel<InfoReserva> modelo_lista_reservas = new DefaultListModel<InfoReserva>();
    private JList<InfoReserva> lista_reservas = new JList<InfoReserva>(modelo_lista_reservas);
    private ConstructorDeCeldaReservas celda = new ConstructorDeCeldaReservas();
    
	private PreparedStatement stmt;
	private Connection conexion;
	private ResultSet resultadoConsulta;
 	
 public ptnBuscarReservasRestaurante(Restaurante rest,ResourceBundle messages){
	this.rest=rest;
	this.messages=messages;
	this.conexion=this.rest.getConexionConsulta().getConexion();
 	initialize();
	realizaBusqueda();
 	
 }
 	 
 private void initialize() {
 		frame = new JFrame();
 		frame.getContentPane().setLayout(null);
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
 		panel.setBounds(0, 86, 895, 481);
 		frame.getContentPane().add(panel);
 		
 		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setBounds(870, 0, 25, 22);
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		panel_2.add(cerrarImage);
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
				Salir salir=new Salir(messages, rest);

			}
		});
 		
 		//KEYLIST Y FOCUS LISTENERS DE LOS CAMPOS
 		
 		//NOMBRE
 		
 		
 		/**
 		 * Panel deslizante de la lista de reservas
 		 */
 		JScrollPane scroll_lista_reservas = new JScrollPane(); 	
 		scroll_lista_reservas.setBounds(23, 11, 848, 413);
 		scroll_lista_reservas.setBorder(null);
 		
 		/**
 		 * Lista de reservas del restaurante
 		 */
 		
 		JButton btnVerificar = new JButton("Verificar");
 		btnVerificar.setBounds(121, 430, 325, 40);
 		btnVerificar.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				InfoReserva reservaSelec = (InfoReserva) lista_reservas.getSelectedValue();
 				
 				String consulta="Update reserva set Verificacion=true where Codigo_Cliente="+reservaSelec.getCodigoUsuario()+" AND Codigo_Restaurante="+rest.getCodigoRestaurante()+" AND FechaReserva='"+reservaSelec.getFecha()+"'";
 				System.out.println(consulta);
 				try {
					stmt = conexion.prepareStatement(consulta);
					stmt.executeUpdate();
					realizaBusqueda();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		});
 		btnVerificar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		btnVerificar.setForeground(new Color(255, 255, 255));
 		btnVerificar.setBackground(new Color(255, 153, 0));
 		
 		JButton btnRealizar = new JButton("Realizado");
 		btnRealizar.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				InfoReserva reservaSelec = (InfoReserva) lista_reservas.getSelectedValue();
 				
 				String consulta="Update reserva set realizacion=true where Codigo_Cliente="+reservaSelec.getCodigoUsuario()+" AND Codigo_Restaurante="+rest.getCodigoRestaurante()+" AND FechaReserva='"+reservaSelec.getFecha()+"'";
 				System.out.println(consulta);
 				try {
					stmt = conexion.prepareStatement(consulta);
					stmt.executeUpdate();
					realizaBusqueda();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		});
 		btnRealizar.setBounds(466, 430, 325, 40);
 		btnRealizar.setBackground(new Color(255, 153,0));
 		btnRealizar.setForeground(new Color(255, 255, 255));
 		btnRealizar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		panel.setLayout(null);
 		
 		DefaultListModel dlm=new DefaultListModel();
 		panel.add(scroll_lista_reservas);
 		//panel.add(lista_reservas);
 		scroll_lista_reservas.setViewportView(lista_reservas);
 		this.lista_reservas.setCellRenderer(celda);
 		this.lista_reservas.setFocusable(false);
 		this.lista_reservas.setBorder(new EmptyBorder(21, 10, 10, 10));
 		this.lista_reservas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 17));
 		this.lista_reservas.setValueIsAdjusting(true);
 		this.lista_reservas.setForeground(new Color(255, 153, 0));
 		this.lista_reservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		panel.add(btnVerificar);
 		panel.add(btnRealizar);
 		panel.setLayout(null);
 		panel.add(scroll_lista_reservas);
 		panel.add(btnVerificar);
 		panel.add(btnRealizar);
 		
 		JLabel lblnomUser = new JLabel(rest.getNombre());
 		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
 		lblnomUser.setForeground(Color.WHITE);
 		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
 		lblnomUser.setBackground(Color.YELLOW);
 		lblnomUser.setBounds(501, 23, 246, 64);
 		frame.getContentPane().add(lblnomUser);
 		
 		JLabel lblBuscarReservas = new JLabel(messages.getString("BuscarReservas"));
 		lblBuscarReservas.setForeground(Color.WHITE);
 		lblBuscarReservas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		lblBuscarReservas.setBackground(Color.YELLOW);
 		lblBuscarReservas.setBounds(381, 23, 162, 64);
 		frame.getContentPane().add(lblBuscarReservas);
 		
 		JButton btnMenuPrincipal = new JButton(messages.getString("VolverMenuPrincipal"));
 		btnMenuPrincipal.setFocusable(false);
 		btnMenuPrincipal.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
 		btnMenuPrincipal.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				ptnMenuRestaurante menurest=new ptnMenuRestaurante(rest, messages);
 				frame.dispose();
 			}
 		});
 		btnMenuPrincipal.setBackground(new Color(255, 153, 0));
 		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
 		btnMenuPrincipal.setBounds(24, 594, 171, 23);
 		frame.getContentPane().add(btnMenuPrincipal);
 		
 		JButton btnCerrarSesion = new JButton(messages.getString("CerrarSesion"));
 		btnCerrarSesion.setFocusable(false);
 		btnCerrarSesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
 		btnCerrarSesion.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				Ingreso ingreso=new Ingreso();
 				frame.dispose();
 			}
 		});
 		btnCerrarSesion.setForeground(Color.WHITE);
 		btnCerrarSesion.setBackground(new Color(255, 153, 51));
 		btnCerrarSesion.setBounds(757, 45, 128, 23);
 		frame.getContentPane().add(btnCerrarSesion);
 		
 		JLabel label = new JLabel("");
 		label.setIcon(new ImageIcon(ptnBuscarReservasRestaurante.class.getResource("/Imagen/TituloPEQUE.png")));
 		label.setBounds(-11, 23, 393, 64);
 		frame.getContentPane().add(label);
 		frame.setBounds(100, 100, 895, 646);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 	
 }
 		
 		/**
 		 * Realiza la búsqueda, cuenta resultados y los muestra en la lista.
 		 */
 		public void realizaBusqueda(){
 			String consulta="select c.usuario, r.fechaReserva, r.hora, r.fechaCreacion, r.personas,r.Codigo_Cliente,r.verificacion, r.realizacion from reserva r inner join clientes c on r.Codigo_Cliente=c.codigoCliente where r.Codigo_Restaurante=? order by r.fechaCreacion ASC";
 			try {
 				this.stmt = (PreparedStatement) conexion.prepareStatement(consulta);
 				this.stmt.setInt(1, rest.getCodigoRestaurante());
 				this.resultadoConsulta = (ResultSet) this.stmt.executeQuery();
 				modelo_lista_reservas.clear();
 				while(resultadoConsulta.next()){
 					System.out.println(resultadoConsulta.getString("usuario"));
 					modelo_lista_reservas.addElement(new InfoReserva(resultadoConsulta.getString("usuario"),resultadoConsulta.getString("fechaReserva"),resultadoConsulta.getString("hora"),resultadoConsulta.getInt("personas"), resultadoConsulta.getInt("Codigo_Cliente"),resultadoConsulta.getBoolean("realizacion"),resultadoConsulta.getBoolean("verificacion")));
 				}
 				
 			} catch (SQLException e) {
 				System.out.println("Consulta:"+consulta);
 				e.printStackTrace();
 			}
 		}
 }
 

