package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Cliente;
import BBDD.Consulta;
import com.mysql.jdbc.Messages;

public class Ingreso extends JPanel{


	private JFrame frame;
	private JTextField textLabelUser;
	private JPasswordField textLabelPass;
	private JButton btnIngresar;
	private JButton btnRegistrar;
	private JLabel lblBienvenid;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JLabel lblNoregistrado;
	
	static Locale currentLocale;
    static ResourceBundle messages;
	
	public static String language;
	public static String country;
	
	

	/**
	 *  Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso window = new Ingreso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 String language;
	      String country;

	      if (args.length != 2) {
	          language = new String("es");
	          country = new String("ES");
	      } else {
	          language = new String(args[0]);
	          country = new String(args[1]);
	      }

	      

	      currentLocale = new Locale(language, country);

	      messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
	}

	

	/**
	 * Create the application.
	 */
	public Ingreso() {
		
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
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		//Control currentLocale = null;
		//messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);


		final JLabel lblBienvenid = new JLabel(Messages.getString("BIENVENID@"));
		lblBienvenid.setBounds(334, 193, 227, 64);
		lblBienvenid.setForeground(new Color(255, 255, 255));
		lblBienvenid.setBackground(new Color(255, 255, 0));
		lblBienvenid.setFont(new Font("Fira Sans OT", Font.PLAIN, 22));
		frame.getContentPane().add(lblBienvenid);

		final JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblUsuario.setBounds(169, 276, 160, 22);
		frame.getContentPane().add(lblUsuario);

		textLabelUser = new JTextField();
		textLabelUser.setToolTipText("Por Favor, introduzca su Nombre de Usuario");
		textLabelUser.setColumns(10);
		textLabelUser.setBounds(334, 270, 227, 37);
		frame.getContentPane().add(textLabelUser);
		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!textLabelUser.getText().isEmpty()&&!textLabelPass.getText().isEmpty()){
				btnIngresar.setEnabled(true);
			}else{
				btnIngresar.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
		textLabelUser.addKeyListener(kl);

		final JLabel lblPass = new JLabel("  CONTRASE\u00D1A:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPass.setBounds(107, 327, 222, 22);
		frame.getContentPane().add(lblPass);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 514, 895, 93);
		frame.getContentPane().add(panel);

		btnRegistrar = new JButton("REGISTRATE");
		btnRegistrar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnRegistrar.setToolTipText("Facil y rápido, REGISTRATE AHORA!");
		btnRegistrar.setBackground(new Color(255, 153, 51));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro regCli=new Registro(messages);
				frame.dispose();

			}
		});
		
		final JLabel lblNoregistrado = new JLabel("\u00BFNo est\u00E1s Registrado?");
		lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoregistrado.setForeground(new Color(255,153,0));
		lblNoregistrado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 34));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNoregistrado, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(239))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNoregistrado, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setForeground(new Color(255, 153, 51));
		btnIngresar.setFont(new Font("Fira Sans OT", Font.PLAIN, 12));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consulta consulta = new Consulta();
				consulta.loginCliente(textLabelUser.getText(), textLabelPass.getPassword());
				final Cliente clie;
				clie=new Clases.Cliente(textLabelUser.getText());
				MenuCliente menuclie=new MenuCliente(clie, messages);
				frame.dispose();

			}
		});
		btnIngresar.setBounds(334, 374, 227, 37);
		btnIngresar.setEnabled(false);
		frame.getContentPane().add(btnIngresar);


		textLabelPass = new JPasswordField();
		textLabelPass.setToolTipText("Por favor, introduzca su Contraseña");
		textLabelPass.setBounds(334, 321, 227, 37);
		frame.getContentPane().add(textLabelPass);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_1);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap(870, Short.MAX_VALUE)
					.addComponent(cerrarImage, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(cerrarImage, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
		);
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

		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel.setBounds(107, 72, 680, 110);
		frame.getContentPane().add(lblNewLabel);
		

		
		JLabel lblIngles = new JLabel("English");
		lblIngles.setForeground(Color.WHITE);
		lblIngles.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblIngles.setBounds(107, 606, 80, 40);
		frame.getContentPane().add(lblIngles);
		
		lblIngles.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("WELCOME!");
				lblUsuario.setText("USER:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("PASSWORD:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Please, introduce your Username");
				textLabelPass.setToolTipText("Please, introduce your Password");
				btnIngresar.setText("SIGN IN");
				btnRegistrar.setText("REGISTER");
				btnRegistrar.setToolTipText("Fast and easy, REGISTER NOW!");
				lblNoregistrado.setText("Not Registered yet?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language ="en";
		        country ="US";
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);

			}
		});
		
		JLabel lblCastellano = new JLabel("Espa\u00F1ol");
		lblCastellano.setForeground(Color.WHITE);
		lblCastellano.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblCastellano.setBounds(197, 606, 80, 40);
		frame.getContentPane().add(lblCastellano);
		
		lblCastellano.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("BIENVENID@!");
				lblUsuario.setText("USUARIO:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("CONTRASEÑA:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Por favor, introduzca su Nombre de Usuario");
				textLabelPass.setToolTipText("Por favor, introduzca su Contraseña");
				btnIngresar.setText("INGRESAR");
				btnRegistrar.setText("REGISTRATE");
				btnRegistrar.setToolTipText("Facil y rápido, REGISTRATE AHORA!");
				lblNoregistrado.setText("¿No estás Registrado?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language="es";
		        country="ES";
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);

			}
		});
		
		JLabel lblCatalan = new JLabel("Catalán");
		lblCatalan.setForeground(Color.WHITE);
		lblCatalan.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblCatalan.setBounds(287, 606, 80, 40);
		frame.getContentPane().add(lblCatalan);
		
		lblCatalan.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("BENVINGUT!");
				lblUsuario.setText("USUARI:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("CONTRASENYA:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Per favor, introdueixi el seu nom d'Usuari");
				textLabelPass.setToolTipText("Per favor, introdueixi la seva Contrasenya");
				btnIngresar.setText("INGRESSA");
				btnRegistrar.setText("REGISTRA'T");
				btnRegistrar.setToolTipText("Fàcil y ràpid, REGISTRA'T ARA");
				lblNoregistrado.setText("No estás Registrat?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language ="ca";
		        country = "ES";
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);

			}
		});
		
		JLabel lblFrances = new JLabel("Fran\u00E7ais");
		lblFrances.setForeground(Color.WHITE);
		lblFrances.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblFrances.setBounds(377, 606, 80, 40);
		frame.getContentPane().add(lblFrances);
		
		lblFrances.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("BIENVENUE!");
				lblUsuario.setText("UTILISATEUR:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("MOT DE PASSE:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("S'il vous plaît, introduire votre nom d'utilisateur");
				textLabelPass.setToolTipText("S'il vous plaît, introduisez votre mot de passe");
				btnIngresar.setText("CONNECTER");
				btnRegistrar.setText("INSCRIVEZ-VOUS");
				btnRegistrar.setToolTipText("Rapide et facile, INSCRIVEZ-VOUS!");
				lblNoregistrado.setText("Pas encore inscrit?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language ="fr";
		        country = "FR";
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
			}
		});
		
		JLabel lblAleman = new JLabel("Deutsch");
		lblAleman.setForeground(Color.WHITE);
		lblAleman.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblAleman.setBounds(467, 606, 80, 40);
		frame.getContentPane().add(lblAleman);
		
		lblAleman.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("WILLKOMMEN!");
				lblUsuario.setText("USER:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("PASSWORT:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Bitte, einführen Sie Ihren Benutzernamen");
				textLabelPass.setToolTipText("Bitte, einführen Sie Ihr Passwort");
				btnIngresar.setText("ANMELDEN");
				btnRegistrar.setText("REGISTRIEREN");
				btnRegistrar.setToolTipText("Schnell und einfach, JETZT REGISTRIEREN!");
				lblNoregistrado.setText("Noch nicht registriert?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language="de";
		        country="DE";
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
			}
		});
		
		
		
		JLabel lblItaliano = new JLabel("Italiano");
		lblItaliano.setForeground(Color.WHITE);
		lblItaliano.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblItaliano.setBounds(557, 606, 80, 40);
		frame.getContentPane().add(lblItaliano);
		
		lblItaliano.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("BENVENUTO!");
				lblUsuario.setText("UTENTE:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("CHIAVE DI IDENTIFICAZIONE:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Per favore, introduca il suo nome utente");
				textLabelPass.setToolTipText("Per favore introduca la sua chiave di identificazione");
				btnIngresar.setText("REGISTRARSI");
				btnRegistrar.setText("ISCRIVERE");
				btnRegistrar.setToolTipText("Veloce e facile, REGISTRARE ORA!");
				lblNoregistrado.setText("Non ancora registrato?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language = "it";
		        country = "IT";
		        
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
			}
		});
		
		JLabel lblSueco = new JLabel("Svenska");
		lblSueco.setForeground(Color.WHITE);
		lblSueco.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblSueco.setBounds(649, 606, 80, 40);
		frame.getContentPane().add(lblSueco);
		frame.setVisible(true);
		
		lblSueco.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("VÄLKOMMEN!");
				lblUsuario.setText("ANVÄNDARE:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("LÖSENORD:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Skriv ditt användarnamn");
				textLabelPass.setToolTipText("Skriv ditt lösenord");
				btnIngresar.setText("LOGGA IN");
				btnRegistrar.setText("REGISTRERA");
				btnRegistrar.setToolTipText("Snabbt och lätt, REGISTRERA NU!");
				lblNoregistrado.setText("Inte registrerad än?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language = "sv";
		        country = "SE";
		        
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);

			}
		});
		
		JLabel lblPolaco = new JLabel("Polski");
		lblPolaco.setForeground(Color.WHITE);
		lblPolaco.setFont(new Font("Fira Sans OT", Font.BOLD, 13));
		lblPolaco.setBounds(739, 606, 80, 40);
		frame.getContentPane().add(lblPolaco);
		frame.setVisible(true);
		
		lblPolaco.addMouseListener(new MouseListener() {

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
				lblBienvenid.setText("WITAM!");
				lblUsuario.setText("UZYTKOWNIK:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPass.setText("HASTO:");
				lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
				textLabelUser.setToolTipText("Prosze, podaj swoja nazwe uzythownika");
				textLabelPass.setToolTipText("Prosze, podaj swoje hasto");
				btnIngresar.setText("ZALOGUJ SIE");
				btnRegistrar.setText("ZAREJESTRUJ SIE");
				btnRegistrar.setToolTipText("Szybko i prosto, ZAREJESTRUJ SIE TERAZ!");
				lblNoregistrado.setText("Jeszcze nie zarejestronwany?");
				lblNoregistrado.setHorizontalAlignment(SwingConstants.RIGHT);
				language = "pl";
		        country = "PL";
		        
		        currentLocale = new Locale(language, country);

			    messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);

			}
		});
				
		textLabelPass.addKeyListener(kl);
}
/*//Getters y Setters para variables language y country
	public String getlanguage() {
		return language;
	}
	public String getcountry() {
		return country;
	}

	public void setlanguage(String language) {
		this.language = language;
	}
	public void setcountry(String country) {
		this.country = country;
	}*/
}