package Pantallas;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Clases.Cliente;
import Clases.Restaurante;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class BuscarRestaurante extends JFrame{
	Cliente clie;
	private JFrame frame;
	private JTextField textCP;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JPanel panel_1;
	private JComboBox comboTipo;
	private String consulta;
	private ResultSet resultadoConsulta;
	private String[] arrayResultados;
	
	private JButton btnXDireccion;
	private JButton btnXNombre;
	private JButton btnXCP;
	private JButton btnXTipo;
	private PreparedStatement stmt;
	private Connection conexion;
	private int numeroResultados;
	private Restaurante restauranteSeleccionado;
	
	static Locale currentLocale;
    static ResourceBundle messages;
    
    /**
     * Variables para la lista de búsqueda
     */
    private DefaultListModel<InfoRestaurante> modelo_lista_restaurantes = new DefaultListModel<InfoRestaurante>();
    private JList<InfoRestaurante> lista_restaurantes = new JList<InfoRestaurante>(modelo_lista_restaurantes);
    private ConstructorDeCelda celda = new ConstructorDeCelda();
    

	/**
	 * Create the application.
	 */
	 //Constructor. Recibe un objeto cliente.
	public BuscarRestaurante(Cliente clie, ResourceBundle messages) {
		this.messages=messages;
		this.clie=clie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-14, 32, 393, 64);
		frame.getContentPane().add(label);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 97, 895, 488);
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
				Salir salir=new Salir(messages, clie);

			}
		});
		
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 0, 4, (Color) new Color(255, 153, 51)));
		panel_1.setBackground(Color.WHITE);
		
		/**
		 * Panel deslizante de la busqueda, con layout.
		 */
		lista_restaurantes.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 11));
		JScrollPane scroll_lista_restaurantes = new JScrollPane(lista_restaurantes);
		scroll_lista_restaurantes.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scroll_lista_restaurantes, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scroll_lista_restaurantes, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addGap(11))
		);
		
		/**
		 * La lista de restaurantes encontrados.
		 */
		lista_restaurantes.setCellRenderer(celda);
		lista_restaurantes.setFocusable(false);		
		scroll_lista_restaurantes.setViewportView(lista_restaurantes);
		
		JButton btnBuscar = new JButton(messages.getString("BUSCAR"));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				realizaBusqueda();
			}
		});
		btnBuscar.setFocusable(false);
		btnBuscar.setBounds(10, 241, 187, 43);
		btnBuscar.setForeground(new Color(255, 153, 0));
		btnBuscar.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnBuscar.setBackground(Color.WHITE);
		

		
		
		
		//KEYLIST Y FOCUS LISTENERS DE LOS CAMPOS
		
		//LISTA
		
		this.lista_restaurantes.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            InfoRestaurante restauranteSelec = (InfoRestaurante) list.getSelectedValue();
		            restauranteSeleccionado = new Restaurante(restauranteSelec.getCodigo(), clie.getConexionConsulta());
		            ptnRestaurante datosRestaurante = new ptnRestaurante(clie, restauranteSeleccionado, messages);
		            datosRestaurante.setFrameBusqueda(frame);
		            //frame.setEnabled(false);
		            frame.dispose();
		        }    
		    }
		});
		
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
				if(textNombre.getText().compareTo(messages.getString("Nombre1"))==0||textNombre.getText().isEmpty()){
					textNombre.setText(messages.getString("Nombre1"));
					textNombre.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXNombre);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textNombre.getText().compareTo(messages.getString("Nombre1"))==0||textNombre.getText().isEmpty()){
					textNombre.setText("");
					textNombre.setForeground(new Color(255, 153, 51));
					}
			}
		};
		
		//DIRECION
		
		KeyListener keylisDireccion=new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				panel_1.add(btnXDireccion);
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
				if(textDireccion.getText().compareTo(messages.getString("Direccion1"))==0||textDireccion.getText().isEmpty()){
					textDireccion.setText(messages.getString("Direccion1"));
					textDireccion.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXDireccion);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textDireccion.getText().compareTo(messages.getString("Direccion1"))==0||textDireccion.getText().isEmpty()){
					textDireccion.setText("");
					textDireccion.setForeground(new Color(255, 153, 51));
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
				
				FocusListener focusCP=new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent arg0) {
						if(textCP.getText().compareTo(messages.getString("CP1"))==0||textCP.getText().isEmpty()){
							textCP.setText(messages.getString("CP1"));
							textCP.setForeground(Color.LIGHT_GRAY);
							panel_1.remove(btnXCP);
							panel_1.repaint();
							}
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						if(textCP.getText().compareTo(messages.getString("CP1"))==0||textCP.getText().isEmpty()){
							textCP.setText("");
							textCP.setForeground(new Color(255, 153, 51));
							}
					}
				};
				
				
		//Tipo	
				ItemListener itemLisTipo= new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						if(comboTipo.getSelectedItem().toString()=="Tipo"){
							comboTipo.setForeground(Color.LIGHT_GRAY);
							panel_1.remove(btnXTipo);
							panel_1.repaint();
							}else{
								comboTipo.setForeground(new Color(255, 153, 51));
								panel_1.add(btnXTipo);
								panel_1.repaint();
								
							}
						
					}
				};
				
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(255, 255, 255));
		textNombre.setBounds(10, 28, 165, 46);
		textNombre.setText(messages.getString("Nombre1"));
		textNombre.setForeground(Color.LIGHT_GRAY);
		textNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textNombre.setColumns(10);
		textNombre.addFocusListener(focusNombre);
		textNombre.addKeyListener(keylisNombre);
		textNombre.setBorder(null);
	
		textDireccion = new JTextField();
		textDireccion.setBounds(10, 80, 165, 46);
		textDireccion.setText(messages.getString("Direccion1"));
		textDireccion.setForeground(Color.LIGHT_GRAY);
		textDireccion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textDireccion.setColumns(10);
		textDireccion.addKeyListener(keylisDireccion);
		textDireccion.addFocusListener(focusDireccion);
		textDireccion.setBorder(null);
		
		textCP = new JTextField();
		textCP.setBounds(10, 132, 165, 46);
		textCP.setText(messages.getString("CP1"));
		textCP.setForeground(Color.LIGHT_GRAY);
		textCP.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textCP.setColumns(10);
		textCP.addKeyListener(keylisCP);
		textCP.addFocusListener(focusCP);
		textCP.setBorder(null);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {messages.getString("Tipo1"),messages.getString("Chino"),messages.getString("Japones"), messages.getString("Mexicano"), messages.getString("Italiano"),messages.getString("Español"),messages.getString("Aleman"), messages.getString("Americano")}));
		comboTipo.setBounds(10, 184, 165, 46);
		comboTipo.setForeground(Color.LIGHT_GRAY);
		comboTipo.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		comboTipo.setBackground(Color.WHITE);
		comboTipo.setBorder(null);
		comboTipo.addItemListener(itemLisTipo);
		
		
		JLabel lblOtrasBusquedas = new JLabel(messages.getString("OtrasBusquedas"));
		lblOtrasBusquedas.setBounds(10, 285, 190, 64);
		lblOtrasBusquedas.setForeground(new Color(255, 153, 51));
		lblOtrasBusquedas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblOtrasBusquedas.setBackground(Color.YELLOW);
		
		JButton btnMejorValorado = new JButton(messages.getString("MejorValorado"));
		btnMejorValorado.setFocusable(false);
		btnMejorValorado.setBounds(20, 351, 165, 43);
		btnMejorValorado.setForeground(new Color(255, 153, 0));
		btnMejorValorado.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnMejorValorado.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		btnXNombre = new JButton("");
		btnXNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setText(messages.getString("Nombre1"));
				textNombre.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXNombre);
				panel_1.repaint();
			}
		});
		btnXNombre.setBounds(175, 28, 22, 46);
		btnXNombre.setBackground(Color.WHITE);
		btnXNombre.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXNombre.setBorder(null);
		
		
		
		
		panel_1.add(textNombre);
		panel_1.add(textDireccion);
		panel_1.add(textCP);
		panel_1.add(comboTipo);
		panel_1.add(btnBuscar);
		panel_1.add(btnMejorValorado);
		panel_1.add(lblOtrasBusquedas);
		
		JButton btnNuevos = new JButton(messages.getString("Nuevos"));
		btnNuevos.setFocusable(false);
		btnNuevos.setForeground(new Color(255, 153, 0));
		btnNuevos.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnNuevos.setBackground(Color.WHITE);
		btnNuevos.setBounds(20, 403, 165, 43);
		panel_1.add(btnNuevos);
		
		btnXDireccion = new JButton("");
		btnXDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textDireccion.setText(messages.getString("Direccion1"));
				textDireccion.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXDireccion);
				panel_1.repaint();
				
			}
		});
		btnXDireccion.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXDireccion.setBorder(null);
		btnXDireccion.setBackground(Color.WHITE);
		btnXDireccion.setBounds(175, 80, 22, 46);
		
		
		btnXCP = new JButton("");
		btnXCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCP.setText(messages.getString("CP1"));
				textCP.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXCP);
				panel_1.repaint();
			}
		});
		btnXCP.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXCP.setBorder(null);
		btnXCP.setBackground(Color.WHITE);
		btnXCP.setBounds(175, 132, 22, 46);
		
		
		btnXTipo = new JButton("");
		btnXTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboTipo.setSelectedIndex(0);
				comboTipo.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXTipo);
				panel_1.repaint();
			}
		});
		btnXTipo.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXTipo.setBorder(null);
		btnXTipo.setBackground(Color.WHITE);
		btnXTipo.setBounds(175, 184, 22, 46);
		
		panel.setLayout(gl_panel);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(500, 32, 248, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBuscarRestaurante = new JLabel(messages.getString("BuscarRestaurante"));
		lblBuscarRestaurante.setForeground(Color.WHITE);
		lblBuscarRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBuscarRestaurante.setBackground(Color.YELLOW);
		lblBuscarRestaurante.setBounds(389, 32, 162, 64);
		frame.getContentPane().add(lblBuscarRestaurante);
		
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
		btnMenuPrincipal.setBounds(24, 601, 171, 23);
		frame.getContentPane().add(btnMenuPrincipal);
		
		JButton btnCerrarSesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarSesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(255, 153, 51));
		btnCerrarSesion.setBounds(758, 54, 128, 23);
		frame.getContentPane().add(btnCerrarSesion);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Modifica una consulta según los filtros establecidos.
	 */
	public void estableceConsulta(){
		//Contamos el número de filtos activados para la búsqueda.
		boolean primeraConsulta=true;
		this.consulta = "SELECT nombre, direccion, poblacion, tipo, codigoRestaurante FROM Restaurantes";
		if(!this.textDireccion.getText().equals(messages.getString("Direccion1"))||!this.textCP.getText().equals(messages.getString("CP1"))
			||!this.textNombre.getText().equals(messages.getString("Nombre1"))||this.comboTipo.getSelectedIndex()!=0){
				this.consulta = consulta+" WHERE";
			if(!this.textDireccion.getText().equals(messages.getString("Direccion1"))){
				if(primeraConsulta){
					this.consulta = this.consulta+" Direccion LIKE '%"+this.textDireccion.getText()+"%'";
					primeraConsulta=false;
				}
			}
			if(!this.textCP.getText().equals(messages.getString("CP1"))){
				if(primeraConsulta){
					this.consulta = this.consulta+" codigoPostal="+this.textCP.getText()+"";
					primeraConsulta=false;
				}else{
					System.out.println(textCP.getText());
					this.consulta = this.consulta+" AND codigoPostal="+this.textCP.getText()+"";
				}
			}
			if(!this.textNombre.getText().equals(messages.getString("Nombre1"))){
				if(primeraConsulta){
					this.consulta = this.consulta+" Nombre LIKE '%"+this.textNombre.getText()+"%'";
					primeraConsulta=false;
				}else{
					this.consulta = this.consulta+" AND Nombre LIKE'%"+this.textNombre.getText()+"%'";
				}
			}
			if(this.comboTipo.getSelectedIndex()!=0){
				if(primeraConsulta){
					String tipo = (String)this.comboTipo.getSelectedItem();
					this.consulta = this.consulta+" tipo='"+tipo+"'";
					primeraConsulta=false;
				}else{
					String tipo = (String)this.comboTipo.getSelectedItem();
					this.consulta = this.consulta+" AND tipo='"+tipo+"'";
				}		
			}
		}
		System.out.println(consulta);
		this.consulta = consulta+";";
	}
	
	/**
	 * Realiza la conexión con la BD
	 */
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
			this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143:3306/adrestaurant", user, "adrestaurant");

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
		estableceConsulta();
		try {
			this.stmt = conexion.prepareStatement(this.consulta);
			this.resultadoConsulta = this.stmt.executeQuery();
			modelo_lista_restaurantes.clear();
			while(resultadoConsulta.next()){
				modelo_lista_restaurantes.addElement(new InfoRestaurante(resultadoConsulta.getString("Nombre"),resultadoConsulta.getString("Tipo"),resultadoConsulta.getString("Direccion"),resultadoConsulta.getString("Poblacion"), resultadoConsulta.getInt("codigoRestaurante")));
			}
			
		} catch (SQLException e) {
			System.out.println("Consulta:"+this.consulta);
			e.printStackTrace();
		}
	}
}