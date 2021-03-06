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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractListModel;
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
import javax.swing.border.MatteBorder;

import BBDD.Consulta;
import Clases.Cliente;
import Clases.Restaurante;

import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
 
 public class ptnBuscarReservas extends JFrame {
 	Cliente clie;
 	private JFrame frame;
 	
 	private JButton btnXFecha;
 	private JButton btnXNombre;
 	private JButton btnXCP;
 	private JButton btnXTipo;
 	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private DefaultListModel<InfoReserva> modelo_lista_reservas = new DefaultListModel<InfoReserva>();
    private JList<InfoReserva> lista_reservas = new JList<InfoReserva>(modelo_lista_reservas);
    private ConstructorDeCeldaReservas celda = new ConstructorDeCeldaReservas();
 	
 	static Locale currentLocale;
    static ResourceBundle messages;
 	
 public ptnBuscarReservas(Cliente clie,ResourceBundle messages){
	 this.clie=clie;
	 this.conexion=this.clie.getConexionConsulta().getConexion();
	 this.messages=messages;
	 initialize();
	 buscarReservas();
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

//		JLabel cerrarImage = new JLabel("");
//		cerrarImage.setBounds(870, 0, 25, 22);
//		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
//		panel_2.add(cerrarImage);
//		cerrarImage.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//			}
//
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				Salir salir=new Salir(messages, clie);
//
//			}
//		});
// 		
// 		//KEYLIST Y FOCUS LISTENERS DE LOS CAMPOS
// 		
// 		//NOMBRE
// 		
// 		KeyListener keylisNombre=new KeyListener() {
// 			@Override
// 			public void keyTyped(KeyEvent arg0) {
// 				panel_1.add(btnXNombre);
// 				panel_1.repaint();
// 			}
// 			
// 			@Override
// 			public void keyReleased(KeyEvent arg0) {
// 			}
// 			
// 			@Override
// 			public void keyPressed(KeyEvent arg0) {
// 			}
// 		};
// 		
// 		FocusListener focusNombre=new FocusListener() {
// 			
// 			@Override
// 			public void focusLost(FocusEvent arg0) {
// 				if(textNombreRest.getText().compareTo((messages.getString("NombreRestaurante")))==0||textNombreRest.getText().isEmpty()){
// 					textNombreRest.setText(messages.getString("NombreRestaurante"));
// 					textNombreRest.setForeground(Color.LIGHT_GRAY);
// 					panel_1.remove(btnXNombre);
// 					panel_1.repaint();
// 					}
// 			}
// 			
// 			@Override
// 			public void focusGained(FocusEvent arg0) {
// 				if(textNombreRest.getText().compareTo("Nombre Restaurante")==0||textNombreRest.getText().isEmpty()){
// 					textNombreRest.setText("");
// 					textNombreRest.setForeground(new Color(255, 153, 51));
// 					}
// 			}
// 		};
// 		
// 		//DIRECION
// 		
// 		KeyListener keylisDireccion=new KeyListener() {
// 			@Override
// 			public void keyTyped(KeyEvent arg0) {
// 				panel_1.add(btnXFecha);
// 				panel_1.repaint();
// 			}
// 			
// 			@Override
// 			public void keyReleased(KeyEvent arg0) {
// 			}
// 			
// 			@Override
// 			public void keyPressed(KeyEvent arg0) {
// 			}
// 		};
// 		
// 		FocusListener focusDireccion=new FocusListener() {
// 			
// 			@Override
// 			public void focusLost(FocusEvent arg0) {
// 				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
// 					textFecha.setText(messages.getString("Fecha"));
// 					textFecha.setForeground(Color.LIGHT_GRAY);
// 					panel_1.remove(btnXFecha);
// 					panel_1.repaint();
// 					}
// 			}
// 			
// 			@Override
// 			public void focusGained(FocusEvent arg0) {
// 				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
// 					textFecha.setText("");
// 					textFecha.setForeground(new Color(255, 153, 51));
// 					}
// 			}
// 		};
// 		
// 		//Codigo Postal
// 		
// 				KeyListener keylisCP=new KeyListener() {
// 					@Override
// 					public void keyTyped(KeyEvent arg0) {
// 						panel_1.add(btnXCP);
// 						panel_1.repaint();
// 					}
// 					
// 					@Override
// 					public void keyReleased(KeyEvent arg0) {
// 					}
// 					
// 					@Override
// 					public void keyPressed(KeyEvent arg0) {
// 					}
// 				};
// 		
// 		btnXNombre = new JButton("");
// 		btnXNombre.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent arg0) {
// 				textNombreRest.setText(messages.getString("Nombre"));
// 				textNombreRest.setForeground(Color.LIGHT_GRAY);
// 				panel_1.requestFocus();
// 				panel_1.remove(btnXNombre);
// 				panel_1.repaint();
// 			}
// 		});
// 		btnXNombre.setBounds(175, 145, 22, 46);//175, 28, 22, 46
// 		btnXNombre.setBackground(Color.WHITE);
// 		btnXNombre.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
// 		btnXNombre.setBorder(null);
// 		
// 		btnXFecha = new JButton("");
// 		btnXFecha.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent arg0) {
// 				textFecha.setText(messages.getString("Direccion"));
// 				textFecha.setForeground(Color.LIGHT_GRAY);
// 				panel_1.requestFocus();
// 				panel_1.remove(btnXFecha);
// 				panel_1.repaint();
// 				
// 			}
// 		});
// 		btnXFecha.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
// 		btnXFecha.setBorder(null);
// 		btnXFecha.setBackground(Color.WHITE);
// 		btnXFecha.setBounds(175, 196, 22, 46);
// 		
 		/**
 		 * Panel deslizante de la lista y su layout.
 		 */
 		JScrollPane scroll_lista_reservas = new JScrollPane(this.lista_reservas); 		
 		scroll_lista_reservas.setBorder(null);
 		GroupLayout gl_panel = new GroupLayout(panel);
 		gl_panel.setHorizontalGroup(
 			gl_panel.createParallelGroup(Alignment.LEADING)
 				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
 					.addContainerGap()
 					.addComponent(scroll_lista_reservas, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
 		);
 		gl_panel.setVerticalGroup(
 			gl_panel.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_panel.createSequentialGroup()
 					.addComponent(scroll_lista_reservas, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
 					.addContainerGap())
 		);
 		
 		/**
 		 * Lista reservas
 		 */
 		this.lista_reservas.setCellRenderer(celda);
		this.lista_reservas.setFocusable(false);		
		scroll_lista_reservas.setViewportView(this.lista_reservas);
 		lista_reservas.setBorder(new EmptyBorder(21, 10, 10, 10));
 		lista_reservas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 17));
 		lista_reservas.setValueIsAdjusting(true);
 		lista_reservas.setForeground(new Color(255, 153, 0));
 		lista_reservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		scroll_lista_reservas.setViewportView(lista_reservas);
 		panel.setLayout(gl_panel);
 		
 		/**
 		 * Listener de la lista reservas. Al clickar sobre una, se abre el perfil de ese restaurante
 		 */
 		this.lista_reservas.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            InfoReserva restauranteSelec = (InfoReserva) list.getSelectedValue();
		            Restaurante restauranteSeleccionado = new Restaurante(restauranteSelec.getCodigoRestaurante(), clie.getConexionConsulta());
		            ptnRestaurante datosRestaurante = new ptnRestaurante(clie, restauranteSeleccionado, messages);
		            datosRestaurante.setFrameBusqueda(frame);
		            //frame.setEnabled(false);
		            frame.dispose();
		        }    
		    }
		});
 		
 		JLabel lblnomUser = new JLabel(clie.getNombre());
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
 				MenuCliente menuclie=new MenuCliente(clie, messages);
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
 		label.setIcon(new ImageIcon(ptnBuscarReservas.class.getResource("/Imagen/TituloPEQUE.png")));
 		label.setBounds(-11, 23, 393, 64);
 		frame.getContentPane().add(label);
 		frame.setBounds(100, 100, 895, 646);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 	
 	}
 
 	/**
 	 * Realiza la b�squeda de reservas seg�n los filtros.
 	 */
 	public void buscarReservas(){
		this.consulta="select rest.codigoRestaurante, rest.nombre, r.fechaReserva, r.hora, r.personas, r.verificacion, r.realizacion "
				+ "from reserva r INNER JOIN Restaurantes rest ON r.Codigo_Restaurante=rest.codigoRestaurante "
				+ "where r.codigo_Cliente=? order by r.fechaReserva DESC;";
 		try {
			this.stmt = conexion.prepareStatement(this.consulta);
			this.stmt.setInt(1, this.clie.getCodigoCliente());
			this.resultadoConsulta = this.stmt.executeQuery();
			this.modelo_lista_reservas.clear();
			while(resultadoConsulta.next()){
				this.modelo_lista_reservas.addElement(new InfoReserva(resultadoConsulta.getInt("codigoRestaurante"), 
						resultadoConsulta.getString("Nombre"), resultadoConsulta.getString("fechaReserva"),
						resultadoConsulta.getString("hora"), resultadoConsulta.getInt("personas"), 
						resultadoConsulta.getBoolean("realizacion"), resultadoConsulta.getBoolean("verificacion"), messages));
			}
			
		} catch (SQLException e) {
			System.out.println("Consulta:"+this.consulta);
			e.printStackTrace();
		}
	}
}
 

