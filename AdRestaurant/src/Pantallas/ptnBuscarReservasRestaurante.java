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
import java.sql.DriverManager;
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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import Clases.Cliente;
import Clases.Restaurante;
 
 public class ptnBuscarReservasRestaurante extends JFrame {
 	Restaurante rest;
 	private JFrame frame;
 	private JTextField textNombreRest;
 	private JTextField textFecha;
 	JPanel panel_1;
 	
 	private JButton btnXFecha;
 	private JButton btnXNombre;
 	private JButton btnXCP;
 	private JButton btnXTipo;
 	
 	static Locale currentLocale;
    static ResourceBundle messages;
    
    private DefaultListModel<InfoReserva> modelo_lista_reservas = new DefaultListModel<InfoReserva>();
    private JList<InfoReserva> lista_reservas = new JList<InfoReserva>(modelo_lista_reservas);
    private ConstructorDeCelda celda = new ConstructorDeCelda();
    
	private PreparedStatement stmt;
	private Connection conexion;
	private ResultSet resultadoConsulta;
 	
 public ptnBuscarReservasRestaurante(Restaurante rest,ResourceBundle messages){
	 this.rest=rest;
	 this.messages=messages;
 	initialize();
 	conectar();
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
 		
 		
 		panel_1 = new JPanel();
 		panel_1.setBorder(new MatteBorder(0, 0, 0, 4, (Color) new Color(255, 153, 51)));
 		panel_1.setBackground(Color.WHITE);
 		
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
 		
 		JButton btnBuscar = new JButton(messages.getString("BUSCAR"));
 		btnBuscar.setFocusable(false);
 		btnBuscar.setBounds(10, 274, 187, 43);
 		btnBuscar.setForeground(new Color(255, 153, 0));
 		btnBuscar.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
 		btnBuscar.setBackground(Color.WHITE);
 		
 
 		
 		
 		
 		//KEYLIST Y FOCUS LISTENERS DE LOS CAMPOS
 		
 		//NOMBRE
 		
 		KeyListener keylisNombre=new KeyListener() {
 			@Override
 			public void keyTyped(KeyEvent arg0) {
 				panel_1.add(btnXNombre);
 				panel_1.repaint();
 			}
 			
 			@Override
 			public void keyReleased(KeyEvent arg0) {
 			}
 			
 			@Override
 			public void keyPressed(KeyEvent arg0) {
 			}
 		};
 		
 		FocusListener focusNombre=new FocusListener() {
 			
 			@Override
 			public void focusLost(FocusEvent arg0) {
 				if(textNombreRest.getText().compareTo((messages.getString("NombreRestaurante")))==0||textNombreRest.getText().isEmpty()){
 					textNombreRest.setText(messages.getString("NombreRestaurante"));
 					textNombreRest.setForeground(Color.LIGHT_GRAY);
 					panel_1.remove(btnXNombre);
 					panel_1.repaint();
 					}
 			}
 			
 			@Override
 			public void focusGained(FocusEvent arg0) {
 				if(textNombreRest.getText().compareTo("Nombre Restaurante")==0||textNombreRest.getText().isEmpty()){
 					textNombreRest.setText("");
 					textNombreRest.setForeground(new Color(255, 153, 51));
 					}
 			}
 		};
 		
 		//DIRECION
 		
 		KeyListener keylisDireccion=new KeyListener() {
 			@Override
 			public void keyTyped(KeyEvent arg0) {
 				panel_1.add(btnXFecha);
 				panel_1.repaint();
 			}
 			
 			@Override
 			public void keyReleased(KeyEvent arg0) {
 			}
 			
 			@Override
 			public void keyPressed(KeyEvent arg0) {
 			}
 		};
 		
 		FocusListener focusDireccion=new FocusListener() {
 			
 			@Override
 			public void focusLost(FocusEvent arg0) {
 				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
 					textFecha.setText(messages.getString("Fecha"));
 					textFecha.setForeground(Color.LIGHT_GRAY);
 					panel_1.remove(btnXFecha);
 					panel_1.repaint();
 					}
 			}
 			
 			@Override
 			public void focusGained(FocusEvent arg0) {
 				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
 					textFecha.setText("");
 					textFecha.setForeground(new Color(255, 153, 51));
 					}
 			}
 		};
 		
 		//Codigo Postal
 		
 				KeyListener keylisCP=new KeyListener() {
 					@Override
 					public void keyTyped(KeyEvent arg0) {
 						panel_1.add(btnXCP);
 						panel_1.repaint();
 					}
 					
 					@Override
 					public void keyReleased(KeyEvent arg0) {
 					}
 					
 					@Override
 					public void keyPressed(KeyEvent arg0) {
 					}
 				};
 				
 				
 				
 				
 		
 				
 		
 		textNombreRest = new JTextField();
 		textNombreRest.setBackground(new Color(255, 255, 255));
 		textNombreRest.setBounds(10, 145, 165, 46);
 		textNombreRest.setText(messages.getString("NombreRestaurante"));
 		textNombreRest.setForeground(Color.LIGHT_GRAY);
 		textNombreRest.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		textNombreRest.setColumns(10);
 		textNombreRest.addFocusListener(focusNombre);
 		textNombreRest.addKeyListener(keylisNombre);
 		textNombreRest.setBorder(null);
 		
 		
 		
 		
 		textFecha = new JTextField();
 		textFecha.setBounds(10, 197, 165, 46);
 		textFecha.setText(messages.getString("Fecha"));
 		textFecha.setForeground(Color.LIGHT_GRAY);
 		textFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		textFecha.setColumns(10);
 		textFecha.addKeyListener(keylisDireccion);
 		textFecha.addFocusListener(focusDireccion);
 		textFecha.setBorder(null);
 		panel_1.setLayout(null);
 		
 		btnXNombre = new JButton("");
 		btnXNombre.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				textNombreRest.setText(messages.getString("Nombre"));
 				textNombreRest.setForeground(Color.LIGHT_GRAY);
 				panel_1.requestFocus();
 				panel_1.remove(btnXNombre);
 				panel_1.repaint();
 			}
 		});
 		btnXNombre.setBounds(175, 145, 22, 46);//175, 28, 22, 46
 		btnXNombre.setBackground(Color.WHITE);
 		btnXNombre.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
 		btnXNombre.setBorder(null);
 		
 		
 		
 		
 		panel_1.add(textNombreRest);
 		panel_1.add(textFecha);
 		panel_1.add(btnBuscar);
 		
 		btnXFecha = new JButton("");
 		btnXFecha.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				textFecha.setText(messages.getString("Direccion"));
 				textFecha.setForeground(Color.LIGHT_GRAY);
 				panel_1.requestFocus();
 				panel_1.remove(btnXFecha);
 				panel_1.repaint();
 				
 			}
 		});
 		btnXFecha.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
 		btnXFecha.setBorder(null);
 		btnXFecha.setBackground(Color.WHITE);
 		btnXFecha.setBounds(175, 196, 22, 46);
 		
 		JScrollPane scrollPane = new JScrollPane(lista_reservas);
 		scrollPane.setBorder(null);
 		
 		JButton btnVerificar = new JButton("Verificar");
 		btnVerificar.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				InfoReserva reservaSelec = (InfoReserva) lista_reservas.getSelectedValue();
 				 conexion=(Connection) rest.getConexionConsulta().getConexion();
 				String consulta="Update reserva set Verificacion=true where Codigo_Cliente="+reservaSelec.getCodigoUsuario()+"AND Codigo_Restaurante="+rest.getCodigoRestaurante()+"AND FechaReserva="+reservaSelec.getFecha();
 				
 			}
 		});
 		btnVerificar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		btnVerificar.setForeground(new Color(255, 255, 255));
 		btnVerificar.setBackground(new Color(255, 153, 0));
 		
 		JButton btnRealizar = new JButton("Realizado");
 		btnRealizar.setBackground(new Color(255, 153,0));
 		btnRealizar.setForeground(new Color(255, 255, 255));
 		btnRealizar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
 		GroupLayout gl_panel = new GroupLayout(panel);
 		gl_panel.setHorizontalGroup(
 			gl_panel.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_panel.createSequentialGroup()
 					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
 					.addPreferredGap(ComponentPlacement.RELATED)
 					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
 						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
 							.addComponent(btnVerificar, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
 							.addPreferredGap(ComponentPlacement.RELATED)
 							.addComponent(btnRealizar, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
 							.addContainerGap())
 						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)))
 		);
 		gl_panel.setVerticalGroup(
 			gl_panel.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_panel.createSequentialGroup()
 					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
 						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
 						.addGroup(gl_panel.createSequentialGroup()
 							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
 							.addPreferredGap(ComponentPlacement.RELATED)
 							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
 								.addComponent(btnRealizar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
 								.addComponent(btnVerificar, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
 					.addContainerGap())
 		);
 		
 		DefaultListModel dlm=new DefaultListModel();
 		panel.setLayout(gl_panel);
 		
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
 		public void conectar(){
 			//Cargamos el driver
 			try{
 				Class.forName("com.mysql.jdbc.Driver");
 			}catch(ClassNotFoundException cnfe){
 				cnfe.printStackTrace();
 			}

 			//Abrimos una conexión
 			this.conexion=null;
 			try {
 				String user = "adrestaurant";
 				this.conexion = (Connection) DriverManager.getConnection("jdbc:mysql://84.126.12.143:3306/adrestaurant", user, "adrestaurant");

 				//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
 				//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
 				this.conexion.setAutoCommit(true);
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
 		
 		/**
 		 * Realiza la búsqueda, cuenta resultados y los muestra en la lista.
 		 */
 		public void realizaBusqueda(){
 			conectar();
 			String consulta="select c.usuario, r.fechaReserva, r.hora, r.fechaCreacion, r.personas,r.Codigo_Cliente,r.verificacion, r.realizacion from reserva r inner join clientes c on r.Codigo_Cliente=c.codigoCliente where r.Codigo_Restaurante=? order by r.fechaCreacion ASC";
 			try {
 				this.stmt = (PreparedStatement) conexion.prepareStatement(consulta);
 				this.stmt.setInt(1, rest.getCodigoRestaurante());
 				this.resultadoConsulta = (ResultSet) this.stmt.executeQuery();
 				modelo_lista_reservas.clear();
 				while(resultadoConsulta.next()){
 					System.out.println(resultadoConsulta.getString("usuario"));
 					modelo_lista_reservas.addElement(new InfoReserva(resultadoConsulta.getString("usuario"),resultadoConsulta.getString("fechaReserva"),resultadoConsulta.getString("hora"),resultadoConsulta.getInt("personas"), resultadoConsulta.getInt("Codigo_Cliente"),resultadoConsulta.getBoolean("verificacion"),resultadoConsulta.getBoolean("realizacion") ));
 				}
 				
 			} catch (SQLException e) {
 				System.out.println("Consulta:"+consulta);
 				e.printStackTrace();
 			}
 		}
 }
 

