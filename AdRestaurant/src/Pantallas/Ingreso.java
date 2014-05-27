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
import Clases.Restaurante;
import BBDD.Consulta;

import com.mysql.jdbc.Messages;

public class Ingreso extends JPanel{

	private static JFrame frame;
	private JTextField textLabelUser;
	private JPasswordField textLabelPass;
	private JButton btnIngresar;
	private JButton btnRegistrar;
	private JLabel lblBienvenid;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JLabel lblNoregistrado;
	private Consulta consulta;

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
		frame.setVisible(true);
		botonesIngreso();
		lblIdiomas();
		botonX();
	}

	/**
	 * Todos los botones de la pantalla Ingreso
	 */
	public void botonesIngreso(){
		lblBienvenid = new JLabel(messages.getString("WLCOME"));
		lblBienvenid.setBounds(334, 193, 227, 64);
		lblBienvenid.setForeground(new Color(255, 255, 255));
		lblBienvenid.setBackground(new Color(255, 255, 0));
		lblBienvenid.setFont(new Font("Fira Sans OT", Font.PLAIN, 22));
		frame.getContentPane().add(lblBienvenid);

		lblUsuario = new JLabel(messages.getString("USER"));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblUsuario.setBounds(169, 276, 160, 22);
		frame.getContentPane().add(lblUsuario);

		textLabelUser = new JTextField();
		textLabelUser.setToolTipText(messages.getString("introduzcausuario"));
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
				   if (e.getKeyCode()==KeyEvent.VK_ENTER){
			            btnIngresar.doClick();
			        }
			}
		};
		textLabelUser.addKeyListener(kl);

		lblPass = new JLabel(messages.getString("Pass1"));
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Fira Sans OT Light", Font.BOLD, 18));
		lblPass.setBounds(107, 327, 222, 22);
		frame.getContentPane().add(lblPass);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 514, 895, 93);
		frame.getContentPane().add(panel);

		btnRegistrar = new JButton(messages.getString("Registrate"));
		btnRegistrar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnRegistrar.setToolTipText(messages.getString("fastandeasy"));
		btnRegistrar.setBackground(new Color(255, 153, 51));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro regCli=new Registro(messages, consulta);
				frame.dispose();
				regCli.setConsulta(consulta);
			}
		});

		lblNoregistrado = new JLabel(messages.getString("NOREG"));
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
		this.consulta = new Consulta(messages);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pasamos el usuario y la contraseña a Consulta para que los compruebe
				if(consulta.loginCliente(textLabelUser.getText(), textLabelPass.getPassword())&&(consulta.esRestaurante()==false)){
					Cliente clie;
					clie=new Clases.Cliente(textLabelUser.getText(), consulta);
					MenuCliente menuclie=new MenuCliente(clie, messages);
					frame.dispose();
				}else{
					System.out.println(""+consulta.esRestaurante());
					if(consulta.esRestaurante()){
						Restaurante rest=new Restaurante(textLabelUser.getText(), consulta);
						System.out.println(""+rest.getNombre());
						ptnMenuRestaurante menuRest=new ptnMenuRestaurante(rest, messages);
						frame.dispose();
					}/*else{
						ErrorRegistro err=consulta.error();
						err.setVisible(true);
					}*/

				}
			}
		});
		btnIngresar.setBounds(334, 374, 227, 37);
		btnIngresar.setEnabled(false);
		frame.getContentPane().add(btnIngresar);


		textLabelPass = new JPasswordField();
		textLabelPass.setToolTipText(messages.getString("introduzcacontra"));
		textLabelPass.setBounds(334, 321, 227, 37);
		frame.getContentPane().add(textLabelPass);
		textLabelPass.addKeyListener(kl);



		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/Titulo.png")));
		lblNewLabel.setBounds(107, 72, 680, 110);
		frame.getContentPane().add(lblNewLabel);
	}
	/**
	 *Botón X para Salir de la aplicación con pequeño JPanel Blanco
	 */
	public void botonX(){
		JPanel panel_111 = new JPanel();
		panel_111.setBackground(Color.WHITE);
		panel_111.setBounds(0, 0, 895, 22);
		frame.getContentPane().add(panel_111);

		JLabel cerrarImage = new JLabel("");
		cerrarImage.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagen/botonX.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_111);
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
				Salir salir=new Salir(messages, consulta);

			}
		});

		panel_111.setLayout(gl_panel_1);
		panel_111.setVisible(true);
	}

	/**
	 * All lblIdiomas to be able to change language with ResourceBundle messages
	 */
	public void lblIdiomas(){
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
				currentLocale = new Locale("en_US");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);

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
				currentLocale = new Locale("es_ES");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);

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
				currentLocale = new Locale("ca_ES");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);

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
				currentLocale = new Locale("fr_FR");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);
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
				currentLocale = new Locale("de_DE");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);
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
				currentLocale = new Locale("it_IT");
				messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
				actualizarIdioma(messages);
			}
		});
	}

	/**
	 * A separate method to refresh and set the lbls of Ingreso in the correct language
	 */
	public void actualizarIdioma(ResourceBundle messages){
		lblBienvenid.setText(messages.getString("WLCOME"));
		lblUsuario.setText(messages.getString("USER"));
		lblPass.setText(messages.getString("Pass1"));
		textLabelUser.setToolTipText(messages.getString("introduzcausuario"));
		textLabelPass.setToolTipText(messages.getString("introduzcacontra"));
		btnIngresar.setText(messages.getString("Ingresar"));
		btnRegistrar.setText(messages.getString("Registrate"));
		btnRegistrar.setToolTipText(messages.getString("fastandeasy"));
		lblNoregistrado.setText(messages.getString("NOREG"));
	}
}