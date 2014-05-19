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
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;

import Clases.Cliente;

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
	private Registro registro;
	private Border borde;
	private FocusListener focus;
	
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
		this.registro=this;
		this.messages=messages;
		initialize();
		this.borde=BorderFactory.createLineBorder(new Color(255, 134, 0));
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
		
		JLabel lblAdrestaurant = new JLabel("");
		lblAdrestaurant.setIcon(new ImageIcon(Registro.class.getResource("/Imagen/Titulo.png")));
		lblAdrestaurant.setBounds(86, 33, 684, 93);
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
				lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombreUsuario.setForeground(new Color(255, 153, 51));
				lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombreUsuario.setBounds(98, 145, 320, 22);
				panel.add(lblNombreUsuario);
				
				textNomUser = new JTextField();
				textNomUser.setColumns(10);
				textNomUser.setBounds(423, 145, 197, 22);
				panel.add(textNomUser);
				textNomUser.addKeyListener(keyLis);
				textNomUser.setBorder(borde);
				textNomUser.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textNomUser.setBorder(borde);
						textNomUser.setText("");
					}
				});
				
				
				JLabel lblContrasea = new JLabel(messages.getString("Pass"));
				lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
				lblContrasea.setForeground(new Color(255, 153, 51));
				lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblContrasea.setBounds(98, 178, 320, 22);
				panel.add(lblContrasea);
				
				JLabel lblEmail = new JLabel(messages.getString("Email"));
				lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
				lblEmail.setForeground(new Color(255, 153, 0));
				lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblEmail.setBounds(98, 211, 320, 22);
				panel.add(lblEmail);
				
				textEmail = new JTextField();
				textEmail.setColumns(10);
				textEmail.setBounds(423, 211, 197, 22);
				panel.add(textEmail);
				textEmail.addKeyListener(keyLis);
				textEmail.setBorder(borde);
				textEmail.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textEmail.setBorder(borde);
						textEmail.setText("");
					}
				});
				
				textNombre = new JTextField();
				textNombre.setColumns(10);
				textNombre.setBounds(423, 46, 197, 22);
				panel.add(textNombre);
				textNombre.addKeyListener(keyLis);
				textNombre.setBorder(borde);
				textNombre.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textNombre.setBorder(borde);
						textNombre.setText("");
					}
				});
				
				JLabel lblNombre = new JLabel(messages.getString("Nombre"));
				lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombre.setForeground(new Color(255, 153, 0));
				lblNombre.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombre.setBounds(98, 46, 320, 22);
				panel.add(lblNombre);
				
				textApellido1 = new JTextField();
				textApellido1.setColumns(10);
				textApellido1.setBounds(423, 79, 197, 22);
				panel.add(textApellido1);
				textApellido1.addKeyListener(keyLis);
				textApellido1.setBorder(borde);
				textApellido1.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textApellido1.setBorder(borde);
						textApellido1.setText("");
					}
				});
				
				JLabel lblPrimerApellido = new JLabel(messages.getString("PA"));
				lblPrimerApellido.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPrimerApellido.setForeground(new Color(255, 153, 51));
				lblPrimerApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPrimerApellido.setBounds(98, 79, 320, 22);
				panel.add(lblPrimerApellido);
				
				textApellido2 = new JTextField();
				textApellido2.setColumns(10);
				textApellido2.setBounds(423, 112, 197, 22);
				panel.add(textApellido2);
				textApellido2.addKeyListener(keyLis);
				textApellido2.setBorder(borde);
				textApellido2.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textApellido2.setBorder(borde);
						textApellido2.setText("");
					}
				});
				
				JLabel lblSegundoApellido = new JLabel(messages.getString("SA"));
				lblSegundoApellido.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSegundoApellido.setForeground(new Color(255, 153, 0));
				lblSegundoApellido.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblSegundoApellido.setBounds(98, 112, 320, 22);
				panel.add(lblSegundoApellido);
				
				/**
				 * Bot�n Registrarse del cliente. Al accionarse llama a comprobarDatos().
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
				passUser.setBorder(borde);
				passUser.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						passUser.setBorder(borde);
						passUser.setText("");
					}
				});
				
				JLabel lblTelfono = new JLabel(messages.getString("Telefono"));
				lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTelfono.setForeground(new Color(255, 153, 0));
				lblTelfono.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblTelfono.setBounds(98, 244, 320, 22);
				panel.add(lblTelfono);
				
				textTelefono = new JTextField();
				textTelefono.setBounds(423, 244, 197, 22);
				panel.add(textTelefono);
				textTelefono.setColumns(10);
				textTelefono.addKeyListener(keyLis);
				textTelefono.setBorder(borde);
				textTelefono.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textTelefono.setBorder(borde);
						textTelefono.setText("");
					}
				});
	
				
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
				comboTipoRest.setModel(new DefaultComboBoxModel(new String[] {messages.getString("Tipo1"),messages.getString("Chino"),messages.getString("Japones"), messages.getString("Mexicano"), messages.getString("Italiano"),messages.getString("Espa�ol"),messages.getString("Aleman"), messages.getString("Americano")}));
				comboTipoRest.setBounds(219, 94, 197, 22);
				panel.add(comboTipoRest);
				comboTipoRest.addKeyListener(keyLis);
				comboTipoRest.setBorder(borde);
						
				JLabel lblNombreUsuario = new JLabel(messages.getString("NU"));
				lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombreUsuario.setForeground(new Color(255, 153, 51));
				lblNombreUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombreUsuario.setBounds(0, 212, 213, 22);
				panel.add(lblNombreUsuario);
					
				textNomUserRest = new JTextField();
				textNomUserRest.setColumns(10);
				textNomUserRest.setBounds(219, 213, 197, 22);
				panel.add(textNomUserRest);
				textNomUserRest.addKeyListener(keyLis);
				textNomUserRest.setBorder(borde);
				textNomUserRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textNomUserRest.setBorder(borde);
						textNomUserRest.setText("");
					}
				});
				
				JLabel lblContrasea = new JLabel(messages.getString("Pass"));
				lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
				lblContrasea.setForeground(new Color(255, 153, 51));
				lblContrasea.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblContrasea.setBounds(361, 212, 220, 22);
				panel.add(lblContrasea);
				
				JLabel lblEmail = new JLabel(messages.getString("Email"));
				lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
				lblEmail.setForeground(new Color(255, 153, 0));
				lblEmail.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblEmail.setBounds(0, 246, 213, 22);
				panel.add(lblEmail);
				
				textEmailRest = new JTextField();
				textEmailRest.setColumns(10);
				textEmailRest.setBounds(219, 246, 197, 22);
				panel.add(textEmailRest);
				textEmailRest.addKeyListener(keyLis);
				textEmailRest.setBorder(borde);
				textEmailRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textEmailRest.setBorder(borde);
						textEmailRest.setText("");
					}
				});
				
				textNombreRest = new JTextField();
				textNombreRest.setColumns(10);
				textNombreRest.setBounds(219, 28, 197, 22);
				panel.add(textNombreRest);
				textNombreRest.addKeyListener(keyLis);
				textNombreRest.setBorder(borde);
				textNombreRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textNombreRest.setBorder(borde);
						textNombreRest.setText("");
					}
				});
				
				JLabel lblNombre_1 = new JLabel(messages.getString("Nombre"));
				lblNombre_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombre_1.setForeground(new Color(255, 153, 0));
				lblNombre_1.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblNombre_1.setBounds(0, 27, 213, 22);
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
				lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
				lblProvincia.setForeground(new Color(255, 153, 51));
				lblProvincia.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblProvincia.setBounds(431, 60, 200, 22);
				panel.add(lblProvincia);
				
				textProvinciaRest = new JTextField();
				textProvinciaRest.setColumns(10);
				textProvinciaRest.setBounds(641, 61, 197, 22);
				panel.add(textProvinciaRest);
				textProvinciaRest.addKeyListener(keyLis);
				textProvinciaRest.setBorder(borde);
				textProvinciaRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textProvinciaRest.setBorder(borde);
						textProvinciaRest.setText("");
					}
				});
				
				JLabel lblPais = new JLabel(messages.getString("CP"));
				lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPais.setForeground(new Color(255, 153, 51));
				lblPais.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPais.setBounds(431, 93, 200, 22);
				panel.add(lblPais);
				
				textCodPostRest = new JTextField();
				textCodPostRest.setColumns(10);
				textCodPostRest.setBounds(641, 94, 197, 22);
				panel.add(textCodPostRest);
				textCodPostRest.addKeyListener(keyLis);
				textCodPostRest.setBorder(borde);
				textCodPostRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textCodPostRest.setBorder(borde);
						textCodPostRest.setText("");
					}
				});
				
				JLabel lblPoblacion = new JLabel(messages.getString("Poblacion"));
				lblPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPoblacion.setForeground(new Color(255, 153, 0));
				lblPoblacion.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblPoblacion.setBounds(431, 27, 200, 22);
				panel.add(lblPoblacion);
				
				textPoblacionRest = new JTextField();
				textPoblacionRest.setColumns(10);
				textPoblacionRest.setBounds(641, 28, 197, 22);
				panel.add(textPoblacionRest);
				textPoblacionRest.addKeyListener(keyLis);
				textPoblacionRest.setBorder(borde);
				textPoblacionRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textPoblacionRest.setBorder(borde);
						textPoblacionRest.setText("");
					}
				});
				
				textDireccionRest = new JTextField();
				textDireccionRest.setColumns(10);
				textDireccionRest.setBounds(219, 61, 197, 22);
				panel.add(textDireccionRest);
				textDireccionRest.addKeyListener(keyLis);
				textDireccionRest.setBorder(borde);
				textDireccionRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textDireccionRest.setBorder(borde);
						textDireccionRest.setText("");
					}
				});
				
				JLabel lblDireccin = new JLabel(messages.getString("Direccion"));
				lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDireccin.setForeground(new Color(255, 153, 51));
				lblDireccin.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblDireccin.setBounds(0, 60, 213, 22);
				panel.add(lblDireccin);
				
				JLabel lblTipo = new JLabel (messages.getString("Tipo"));
				lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTipo.setForeground(new Color(255, 153, 0));
				lblTipo.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblTipo.setBounds(0, 93, 213, 22);
				panel.add(lblTipo);
				
				pwdContraRest = new JPasswordField();
				pwdContraRest.setBounds(599, 213, 197, 20);
				panel.add(pwdContraRest);
				pwdContraRest.addKeyListener(keyLis);
				pwdContraRest.setBorder(borde);
				pwdContraRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						pwdContraRest.setBorder(borde);
						pwdContraRest.setText("");
					}
				});
				
				
				
				JLabel lblAptoParaliticos = new JLabel(messages.getString("AP"));
				lblAptoParaliticos.setHorizontalAlignment(SwingConstants.RIGHT);
				lblAptoParaliticos.setForeground(new Color(255, 153, 0));
				lblAptoParaliticos.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblAptoParaliticos.setBounds(0, 127, 213, 22);
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
				lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTelefono.setForeground(new Color(255, 153, 51));
				lblTelefono.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
				lblTelefono.setBounds(361, 246, 220, 22);
				panel.add(lblTelefono);
				
				textTelefonoRest = new JTextField();
				textTelefonoRest.setColumns(10);
				textTelefonoRest.setBounds(599, 248, 197, 22);
				panel.add(textTelefonoRest);
				textTelefonoRest.setBorder(borde);
				textTelefonoRest.addFocusListener(new FocusListener(){
					
					@Override
					public void focusLost(FocusEvent arg0) {
		
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						textTelefonoRest.setBorder(borde);
						textTelefonoRest.setText("");
					}
				});
				
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
	
//	private static void addPopup(Component component, final JPopupMenu popup) {
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			private void showMenu(MouseEvent e) {
//				popup.show(e.getComponent(), e.getX(), e.getY());
//			}
//		});
//	}
	/**
	 * Comprueba los datos de registro del cliente. Si lo son abre la pantalla RegistroCompleto.
	 *  Si son incorrectos abre la ventana ErrorRegistro. 
	 */
	public void comprobarDatosCliente(){
		ArrayList <String> mensajesError = new ArrayList <String>();
		
		//Comprobamos el n�mero de tel�fono
		String textoIntroducido=this.textTelefono.getText();	
		Pattern pat = Pattern.compile("[0-9]{9}");
	    Matcher mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorTELF"));
	    	this.textTelefono.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
		//Comprobamos el nombre
	    textoIntroducido = this.textNombre.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBRE"));
	    	this.textNombre.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el primer apellido
	    textoIntroducido = this.textApellido1.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("Error1APELLIDO"));
	    	this.textApellido1.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el segundo apellido
	    textoIntroducido = this.textApellido2.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("Error2APELLIDO"));
	    	this.textApellido2.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el nombre de usuario
	    textoIntroducido = this.textNomUser.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBREUSUARIO")); 
	    	this.textNomUser.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el email
	    textoIntroducido = this.textEmail.getText();	
		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorEMAIL")); 
	    	this.textEmail.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Si hay errores, abre la pantalla ErrorRegistro y le pasa el array de errores. Si est� correcto
	    if(mensajesError.size()>0){
	    	JDialog aviso = new ErrorRegistro(mensajesError, this.registro, messages);
	    	aviso.setVisible(true);
	    	frame.setEnabled(false);
	    }else{
			RegistroCompleto regCom=new RegistroCompleto(messages);
			Cliente c = new Cliente(this.textNombre.getText(), this.textApellido1.getText(), this.textApellido2.getText(), 
					this.textNomUser.getText(), this.passUser.getPassword(), this.textTelefono.getText(), this.textEmail.getText());
			//frame.dispose();
		}
	}
	
	/**
	 * Comprueba los datos de registro del restaurante. Si lo son abre la pantalla RegistroCompleto.
	 *  Si son incorrectos abre la ventana ErrorRegistro. 
	 */	
	public void comprobarDatosRestaurante(){
		ArrayList <String> mensajesError = new ArrayList <String>();
		
		//Comprobamos el n�mero de tel�fono
		String textoIntroducido=this.textTelefonoRest.getText();	
		Pattern pat = Pattern.compile("[0-9]{9}");
	    Matcher mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorTELF")); 
	    	this.textTelefonoRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el nombre
	    textoIntroducido = this.textNombreRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBRE")); 
	    	this.textNombreRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el nombre de usuario
	    textoIntroducido = this.textNomUserRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorNOMBREUSUARIO")); 
	    	this.textNomUserRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el email
	    textoIntroducido = this.textEmailRest.getText();	
		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorEMAIL")); 
	    	this.textEmailRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos la direccion
	    textoIntroducido = this.textDireccionRest.getText();	
		pat = Pattern.compile("[a-zA-Z0-9]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorDIRECCION")); 
	    	this.textDireccionRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos la Poblacion
	    textoIntroducido = this.textPoblacionRest.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorPOBLACION")); 
	    	this.textPoblacionRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos la Provincia
	    textoIntroducido = this.textProvinciaRest.getText();	
		pat = Pattern.compile("[a-zA-Z]+");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorPROVINCIA")); 
	    	this.textProvinciaRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Comprobamos el codigo postal
	    textoIntroducido = this.textCodPostRest.getText();	
		pat = Pattern.compile("[0-9]{5}");
	    mat = pat.matcher(textoIntroducido);
	    if (!mat.matches()){
	    	mensajesError.add(messages.getString("ErrorCP")); 
	    	this.textCodPostRest.setBorder(BorderFactory.createBevelBorder(1, (Color.RED), (Color.RED)));
	    } 
	    
	    //Si hay errores, abre la pantalla ErrorRegistro y le pasa el array de errores.
	    if(mensajesError.size()>0){
	    	JDialog aviso = new ErrorRegistro(mensajesError, this.registro, messages);
	    	aviso.setVisible(true);
	    	frame.setEnabled(false);
	    }else{
			RegistroCompleto regCom=new RegistroCompleto(messages);
			//frame.dispose();
		}
	}
	
	/**
	 * Activa la pantalla registro de nuevo, despu�s de leer los mensajes de error.
	 */
	public void activaRegistro(){
		frame.setEnabled(true);
	}
}
	
