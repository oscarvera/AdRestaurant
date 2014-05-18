package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout.Alignment;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;

public class Registro extends JPanel{

	private JFrame frame;
	private JTextField textNomUser;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JPasswordField passUser;
	private JButton btnRegistrarse;
	private JButton btnCliente;
	private JButton btnRestaurante;
	private JTextField textTelefono;
	JPanel panel = new JPanel();

	private JButton btnRegRest;
	private JTextField textNomUserRest;
	private JTextField textEmailRest;
	private JTextField textNombreRest;
	private JTextField textProvinciaRest;
	private JTextField textCodPostRest;
	private JTextField textTelefonoRest;
	private JTextField textPoblacionRest;
	private JTextField textDireccionRest;
	private JPasswordField pwdContraRest;
	private JComboBox comboTipoRest;
	
	private JLabel Flecha1;
	private JLabel Flecha2;
	
	static Locale currentLocale;
    static ResourceBundle messages;
    
    private JLabel lblNC;
    private JLabel lblNR;

	/**
	 * Create the application.
	 */
	public Registro(ResourceBundle messages) {
		this.messages=messages;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblAdrestaurant = new JLabel("AdRestaurant");
		lblAdrestaurant.setBounds(170, 33, 563, 93);
		lblAdrestaurant.setForeground(new Color(255, 255, 255));
		lblAdrestaurant.setBackground(new Color(255, 255, 255));
		lblAdrestaurant.setFont(new Font("Francois One", Font.PLAIN, 90));
		frame.getContentPane().add(lblAdrestaurant);
		
		btnCliente = new JButton(messages.getString("CLIENTE"));
		btnCliente.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCliente.setForeground(new Color(255, 153, 0));
		btnCliente.setBackground(Color.WHITE);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNC.setVisible(false);
				Flecha1.setVisible(false);
				Flecha2.setVisible(false);
				lblNR.setVisible(false);
				
				panel.removeAll();
				panel.setBackground(new Color(255, 255, 255));
				panel.setBounds(0, 194, 895, 348);
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				KeyListener keyLis =new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub			
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						if(!textNombre.getText().isEmpty()&&!textApellido1.getText().isEmpty()&&!textNomUser.getText().isEmpty()&&!textEmail.getText().isEmpty()&&!(passUser.getPassword().length==0)&&!textTelefono.getText().isEmpty()){
							btnRegistrarse.setEnabled(true);
						}else{
							btnRegistrarse.setEnabled(false);
						}	
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub		
					}
				};
				
				JLabel lblNombreUsuario = new JLabel(messages.getString("NU"));
				lblNombreUsuario.setForeground(new Color(255, 153, 51));
				lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombreUsuario.setBounds(258, 145, 155, 22);
				panel.add(lblNombreUsuario);
				
				textNomUser = new JTextField();
				textNomUser.setColumns(10);
				textNomUser.setBounds(423, 145, 197, 22);
				panel.add(textNomUser);
				textNomUser.addKeyListener(keyLis);
				
				JLabel lblContrasea = new JLabel(messages.getString("Pass"));
				lblContrasea.setForeground(new Color(255, 153, 51));
				lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblContrasea.setBounds(258, 178, 155, 22);
				panel.add(lblContrasea);
				
				JLabel lblEmail = new JLabel(messages.getString("Email"));
				lblEmail.setForeground(new Color(255, 153, 0));
				lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblEmail.setBounds(258, 211, 155, 22);
				panel.add(lblEmail);
				
				textEmail = new JTextField();
				textEmail.setColumns(10);
				textEmail.setBounds(423, 211, 197, 22);
				panel.add(textEmail);
				textEmail.addKeyListener(keyLis);
				
				textNombre = new JTextField();
				textNombre.setColumns(10);
				textNombre.setBounds(423, 46, 197, 22);
				panel.add(textNombre);
				textNombre.addKeyListener(keyLis);
				
				JLabel lblNombre = new JLabel(messages.getString("Nombre"));
				lblNombre.setForeground(new Color(255, 153, 0));
				lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombre.setBounds(258, 46, 155, 22);
				panel.add(lblNombre);
				
				textApellido1 = new JTextField();
				textApellido1.setColumns(10);
				textApellido1.setBounds(423, 79, 197, 22);
				panel.add(textApellido1);
				textApellido1.addKeyListener(keyLis);
				
				JLabel lblPrimerApellido = new JLabel(messages.getString("PA"));
				lblPrimerApellido.setForeground(new Color(255, 153, 51));
				lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPrimerApellido.setBounds(258, 79, 155, 22);
				panel.add(lblPrimerApellido);
				
				textApellido2 = new JTextField();
				textApellido2.setColumns(10);
				textApellido2.setBounds(423, 112, 197, 22);
				panel.add(textApellido2);
				textApellido2.addKeyListener(keyLis);
				
				JLabel lblSegundoApellido = new JLabel(messages.getString("SA"));
				lblSegundoApellido.setForeground(new Color(255, 153, 0));
				lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblSegundoApellido.setBounds(258, 112, 169, 22);
				panel.add(lblSegundoApellido);
				
				/**
				 * Botón Registrarse del cliente. Al accionarse llama a comprobarDatos().
				 */
				
				btnRegistrarse = new JButton(messages.getString("REGISTRARSE"));
				btnRegistrarse.setBackground(new Color(255, 153, 0));
				btnRegistrarse.setForeground(new Color(255, 255, 255));
				btnRegistrarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Comprueba que los datos introducidos son correctos.
						comprobarDatosCliente();				
					}
				});
				btnRegistrarse.setBounds(332, 293, 210, 33);
				btnRegistrarse.setEnabled(false);
				panel.add(btnRegistrarse);
				
				passUser = new JPasswordField();
				passUser.setBounds(423, 178, 197, 22);
				panel.add(passUser);
				
				JLabel lblTelfono = new JLabel(messages.getString("Telefono"));
				lblTelfono.setForeground(new Color(255, 153, 0));
				lblTelfono.setFont(new Font("Dialog", Font.BOLD, 18));
				lblTelfono.setBounds(258, 244, 104, 22);
				panel.add(lblTelfono);
				
				textTelefono = new JTextField();
				textTelefono.setBounds(423, 244, 197, 22);
				panel.add(textTelefono);
				textTelefono.setColumns(10);
				textTelefono.addKeyListener(keyLis);
				btnCliente.setEnabled(false);
				
				btnCliente.setEnabled(false);
				btnRestaurante.setEnabled(true);
				frame.repaint();
			}
		});
		btnCliente.setBounds(165, 137, 263, 36);
		frame.getContentPane().add(btnCliente);
		
		btnRestaurante = new JButton(messages.getString("RESTAURANTE"));
		btnRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNC.setVisible(false);
				Flecha1.setVisible(false);
				Flecha2.setVisible(false);
				lblNR.setVisible(false);
							
				panel.removeAll();
				panel.setBackground(new Color(255, 255, 255));
				panel.setBounds(0, 194, 895, 348);
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				KeyListener keyLis =new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub					
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						if(!textNombreRest.getText().isEmpty()&&!textCodPostRest.getText().isEmpty()&&!textDireccionRest.getText().isEmpty()&&!textEmailRest.getText().isEmpty()&&!textNombreRest.getText().isEmpty()&&!(pwdContraRest.getPassword().length==0)&&!textNomUserRest.getText().isEmpty()&&!textPoblacionRest.getText().isEmpty()&&!textProvinciaRest.getText().isEmpty()&&(comboTipoRest.getSelectedIndex()!=0)){
							 btnRegRest.setEnabled(true);
						}else{
							 btnRegRest.setEnabled(false);
						}					
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
					}
				};
				
				comboTipoRest = new JComboBox();
				comboTipoRest.setModel(new DefaultComboBoxModel(new String[] {"Elige un tipo", "Chino", "Japon\u00E9s", "Mexicano", "Italiano", "Espa\u00F1ol", "Alem\u00E1n", "Estadounidense"}));
				comboTipoRest.setBounds(219, 94, 197, 22);
				panel.add(comboTipoRest);
				comboTipoRest.addKeyListener(keyLis);
						
				JLabel lblNombreUsuario = new JLabel(messages.getString("NU"));
				lblNombreUsuario.setForeground(new Color(255, 153, 51));
				lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombreUsuario.setBounds(54, 213, 155, 22);
				panel.add(lblNombreUsuario);
					
				textNomUserRest = new JTextField();
				textNomUserRest.setColumns(10);
				textNomUserRest.setBounds(219, 213, 197, 22);
				panel.add(textNomUserRest);
				textNomUserRest.addKeyListener(keyLis);
				
				JLabel lblContrasea = new JLabel(messages.getString("Pass"));
				lblContrasea.setForeground(new Color(255, 153, 51));
				lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblContrasea.setBounds(434, 213, 155, 22);
				panel.add(lblContrasea);
				
				JLabel lblEmail = new JLabel(messages.getString("Email"));
				lblEmail.setForeground(new Color(255, 153, 0));
				lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblEmail.setBounds(54, 246, 155, 22);
				panel.add(lblEmail);
				
				textEmailRest = new JTextField();
				textEmailRest.setColumns(10);
				textEmailRest.setBounds(219, 246, 197, 22);
				panel.add(textEmailRest);
				textEmailRest.addKeyListener(keyLis);
				
				textNombreRest = new JTextField();
				textNombreRest.setColumns(10);
				textNombreRest.setBounds(219, 28, 197, 22);
				panel.add(textNombreRest);
				textNombreRest.addKeyListener(keyLis);
				
				JLabel lblNombre_1 = new JLabel(messages.getString("Nombre"));
				lblNombre_1.setForeground(new Color(255, 153, 0));
				lblNombre_1.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombre_1.setBounds(54, 27, 155, 22);
				panel.add(lblNombre_1);
				
				btnRegRest = new JButton(messages.getString("REGISTRARSE"));
				btnRegRest.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
				btnRegRest.setBackground(new Color(255, 153, 0));
				btnRegRest.setForeground(new Color(255, 255, 255));
				btnRegRest.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						comprobarDatosRestaurante();
					}
				});
				btnRegRest.setBounds(332, 293, 210, 33);
				btnRegRest.setEnabled(false);
				panel.add(btnRegRest);
				
				JLabel lblProvincia = new JLabel(messages.getString("Provincia"));
				lblProvincia.setForeground(new Color(255, 153, 51));
				lblProvincia.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblProvincia.setBounds(476, 60, 155, 22);
				panel.add(lblProvincia);
				
				textProvinciaRest = new JTextField();
				textProvinciaRest.setColumns(10);
				textProvinciaRest.setBounds(641, 61, 197, 22);
				panel.add(textProvinciaRest);
				textProvinciaRest.addKeyListener(keyLis);
				
				JLabel lblPais = new JLabel(messages.getString("CP"));
				lblPais.setForeground(new Color(255, 153, 51));
				lblPais.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPais.setBounds(476, 93, 155, 22);
				panel.add(lblPais);
				
				textCodPostRest = new JTextField();
				textCodPostRest.setColumns(10);
				textCodPostRest.setBounds(641, 94, 197, 22);
				panel.add(textCodPostRest);
				textCodPostRest.addKeyListener(keyLis);
				
				JLabel lblPoblacion = new JLabel(messages.getString("Poblacion"));
				lblPoblacion.setForeground(new Color(255, 153, 0));
				lblPoblacion.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPoblacion.setBounds(476, 27, 155, 22);
				panel.add(lblPoblacion);
				
				textPoblacionRest = new JTextField();
				textPoblacionRest.setColumns(10);
				textPoblacionRest.setBounds(641, 28, 197, 22);
				panel.add(textPoblacionRest);
				textPoblacionRest.addKeyListener(keyLis);
				
				textDireccionRest = new JTextField();
				textDireccionRest.setColumns(10);
				textDireccionRest.setBounds(219, 61, 197, 22);
				panel.add(textDireccionRest);
				textDireccionRest.addKeyListener(keyLis);
				
				JLabel lblDireccin = new JLabel(messages.getString("Direccion"));
				lblDireccin.setForeground(new Color(255, 153, 51));
				lblDireccin.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblDireccin.setBounds(54, 60, 155, 22);
				panel.add(lblDireccin);
				
				JLabel lblTipo = new JLabel (messages.getString("Tipo"));
				lblTipo.setForeground(new Color(255, 153, 0));
				lblTipo.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblTipo.setBounds(54, 94, 169, 22);
				panel.add(lblTipo);
				
				pwdContraRest = new JPasswordField();
				pwdContraRest.setBounds(599, 213, 197, 20);
				panel.add(pwdContraRest);
				pwdContraRest.addKeyListener(keyLis);
				
				
				
				JLabel lblAptoParaliticos = new JLabel(messages.getString("AP"));
				lblAptoParaliticos.setForeground(new Color(255, 153, 0));
				lblAptoParaliticos.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblAptoParaliticos.setBounds(54, 127, 155, 22);
				panel.add(lblAptoParaliticos);
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("");
				chckbxNewCheckBox.setBackground(Color.WHITE);
				chckbxNewCheckBox.setBounds(219, 126, 27, 23);
				panel.add(chckbxNewCheckBox);
				
				JLabel lblImagen1 = new JLabel(messages.getString("IMG1"));
				lblImagen1.setForeground(new Color(255, 153, 51));
				lblImagen1.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblImagen1.setBounds(318, 127, 92, 22);
				panel.add(lblImagen1);
				
				JLabel lblImagen2 = new JLabel(messages.getString("IMG2"));
				lblImagen2.setForeground(new Color(255, 153, 51));
				lblImagen2.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblImagen2.setBounds(577, 127, 92, 22);
				panel.add(lblImagen2);
				
				Panel panel_11 = new Panel();
				panel_11.setBackground(new Color(255, 153, 51));
				panel_11.setBounds(34, 176, 821, 5);
				panel.add(panel_11);
				
				JLabel lblTelefono = new JLabel(messages.getString("Telefono"));
				lblTelefono.setForeground(new Color(255, 153, 51));
				lblTelefono.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblTelefono.setBounds(434, 246, 155, 22);
				panel.add(lblTelefono);
				
				textTelefonoRest = new JTextField();
				textTelefonoRest.setColumns(10);
				textTelefonoRest.setBounds(599, 248, 197, 22);
				panel.add(textTelefonoRest);
				
				btnCliente.setEnabled(true);
				btnRestaurante.setEnabled(false);
				frame.repaint();
			}
		});
		btnRestaurante.setForeground(new Color(255, 140, 0));
		btnRestaurante.setBackground(new Color(255, 255, 255));
		btnRestaurante.setBounds(428, 137, 263, 36);
		frame.getContentPane().add(btnRestaurante);
		
		
		
		JLabel lblyaEstaRegistrado = new JLabel(messages.getString("YAREG"));
		lblyaEstaRegistrado.setForeground(new Color(255, 255, 255));
		lblyaEstaRegistrado.setFont(new Font("Fira Sans OT", Font.PLAIN, 16));
		lblyaEstaRegistrado.setBackground(new Color(255, 153, 51));
		lblyaEstaRegistrado.setBounds(182, 564, 216, 34);
		frame.getContentPane().add(lblyaEstaRegistrado);
		
		JButton btnIniciarSesin = new JButton (messages.getString("IS"));
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnIniciarSesin.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnIniciarSesin.setForeground(Color.WHITE);
		btnIniciarSesin.setBackground(new Color(255, 153, 51));
		btnIniciarSesin.setBounds(24, 573, 148, 19);
		frame.getContentPane().add(btnIniciarSesin);
		
		JLabel lblInformacionSobreUsuarios = new JLabel (messages.getString("INFOUSER"));
		lblInformacionSobreUsuarios.setForeground(Color.WHITE);
		lblInformacionSobreUsuarios.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		lblInformacionSobreUsuarios.setBackground(new Color(255, 153, 51));
		lblInformacionSobreUsuarios.setBounds(684, 565, 185, 34);
		frame.getContentPane().add(lblInformacionSobreUsuarios);
		
		Flecha1 = new JLabel("");
		Flecha1.setIcon(new ImageIcon(Registro.class.getResource("/Imagen/flecha.png")));
		Flecha1.setBounds(175, 184, 185, 151);
		frame.getContentPane().add(Flecha1);
		
		Flecha2 = new JLabel("New label");
		Flecha2.setIcon(new ImageIcon(Registro.class.getResource("/Imagen/flecha2.png")));
		Flecha2.setBounds(467, 195, 250, 209);
		frame.getContentPane().add(Flecha2);
		
		lblNC = new JLabel(messages.getString("NC"));
		lblNC.setForeground(Color.WHITE);
		lblNC.setHorizontalAlignment(SwingConstants.CENTER);
		lblNC.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		lblNC.setBounds(24, 327, 404, 36);
		frame.getContentPane().add(lblNC);
		
		lblNR = new JLabel(messages.getString("NR"));
		lblNR.setHorizontalAlignment(SwingConstants.CENTER);
		lblNR.setForeground(Color.WHITE);
		lblNR.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		lblNR.setBounds(465, 389, 404, 36);
		frame.getContentPane().add(lblNR);
		
		frame.setVisible(true);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	/**
	 * Comprueba los datos de registro del cliente. Si lo son abre la pantalla RegistroCompleto.
	 *  Si son incorrectos abre la ventana ErrorRegistro. 
	 */
	public void comprobarDatosCliente(){
		ArrayList <String> mensajesError = new ArrayList <String>();
		ArrayList <String> componentesError = new ArrayList <String>();
		
		//Comprobamos el número de teléfono
		String textoIntroducido=this.textTelefono.getText();	
		Pattern pat = Pattern.compile("[0-9]{9}");
	    Matcher mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorTELF"));
	    	componentesError.add("textTelefono");
	    } 
	    
		//Comprobamos el nombre
	    textoIntroducido = this.textNombre.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBRE"));
	    	componentesError.add("textNombre");
	    } 
	    
	    //Comprobamos el primer apellido
	    textoIntroducido = this.textApellido1.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("Error1APELLIDO"));
	    	componentesError.add("textApellido1");
	    } 
	    
	    //Comprobamos el segundo apellido
	    textoIntroducido = this.textApellido2.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("Error2APELLIDO"));
	    	componentesError.add("textApellido2");
	    } 
	    
	    //Comprobamos el nombre de usuario
	    textoIntroducido = this.textNomUser.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBREUSUARIO")); 
	    	componentesError.add("textNomUser");
	    } 
	    
	    //Comprobamos el email
	    textoIntroducido = this.textEmail.getText();	
		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorEMAIL")); 
	    	componentesError.add("textEmail");
	    } 
	    
	    //Si hay errores, abre la pantalla ErrorRegistro y le pasa el array de errores. Si está correcto
	    if(mensajesError.size()>0){
	    	JDialog aviso = new ErrorRegistro(mensajesError, componentesError);
	    	aviso.setVisible(true);
	    }else{
			RegistroCompleto regCom=new RegistroCompleto(messages);
			frame.setEnabled(false);
			//frame.dispose();
		}
	}
	
	/**
	 * Comprueba los datos de registro del restaurante. Si lo son abre la pantalla RegistroCompleto.
	 *  Si son incorrectos abre la ventana ErrorRegistro. 
	 */	
	public void comprobarDatosRestaurante(){
		ArrayList <String> mensajesError = new ArrayList <String>();
		ArrayList <String> componentesError = new ArrayList <String>();
		
		//Comprobamos el número de teléfono
		String textoIntroducido=this.textTelefonoRest.getText();	
		Pattern pat = Pattern.compile("[0-9]{9}");
	    Matcher mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorTELF")); 
	    	componentesError.add("textTelefonoRest");
	    } 
	    
	    //Comprobamos el nombre
	    textoIntroducido = this.textNombreRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBRE")); 
	    	componentesError.add("textNombreRest");
	    } 
	    
	    //Comprobamos el nombre de usuario
	    textoIntroducido = this.textNomUserRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBREUSUARIO")); 
	    	componentesError.add("textNomUserRest");
	    } 
	    
	    //Comprobamos el email
	    textoIntroducido = this.textEmailRest.getText();	
		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorEMAIL")); 
	    	componentesError.add("textEmailRest");
	    } 
	    
	    //Comprobamos la direccion
	    textoIntroducido = this.textDireccionRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorDIRECCION")); 
	    	componentesError.add("textDireccionRest");
	    } 
	    
	    //Comprobamos la Poblacion
	    textoIntroducido = this.textPoblacionRest.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorPOBLACION")); 
	    	componentesError.add("textPoblacionRest");
	    } 
	    
	    //Comprobamos la Provincia
	    textoIntroducido = this.textProvinciaRest.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorPROVINCIA")); 
	    	componentesError.add("textProvinciaRest");
	    } 
	    
	    //Comprobamos el codigo postal
	    textoIntroducido = this.textCodPostRest.getText();	
		pat = Pattern.compile("[0-9]{5}");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorCP")); 
	    	componentesError.add("textCodPostRest");
	    } 
	    
	    //Si hay errores, abre la pantalla ErrorRegistro y le pasa el array de errores.
	    if(mensajesError.size()>0){
	    	JDialog aviso = new ErrorRegistro(mensajesError, componentesError);
	    	aviso.setVisible(true);
	    }else{
			RegistroCompleto regCom=new RegistroCompleto(messages);
			frame.setEnabled(false);
			//frame.dispose();
		}
	}
	
}
	
