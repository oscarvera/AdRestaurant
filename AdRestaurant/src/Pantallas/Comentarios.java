package Pantallas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import Clases.Cliente;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Comentarios extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	Cliente clie;
	static Locale currentLocale;
    static ResourceBundle messages;
    
    private DefaultListModel<InfoComentario> modelo_lista_comentarios = new DefaultListModel<InfoComentario>();
    private JList<InfoComentario> lista_comentarios = new JList<InfoComentario>(modelo_lista_comentarios);
    private ConstructorDeCeldaComentarios celda = new ConstructorDeCeldaComentarios();
	private PreparedStatement stmt;
	private String consulta;
	private Connection conexion;
	private ResultSet resultadoConsulta;

	/**
	 *  Create the frame.
	 */
	public Comentarios( final Cliente clie, final ResourceBundle messages) {
		this.messages=messages;
		this.clie=clie;
		this.conexion=this.clie.getConexionConsulta().getConexion();
		mostrarComentarios();
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 86, 895, 481);
		frame.getContentPane().add(panel);
		
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
				Salir salir=new Salir(messages, clie);

			}
		});
		
		/**
		 * Panel deslizante de la lista comentarios
		 */
		lista_comentarios.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 11));
		JScrollPane scrollComentarios = new JScrollPane();
		scrollComentarios.setBorder(null);
		
		/**
		 * Lista de comentarios hechos por el cliente.
		 */
		this.lista_comentarios.setCellRenderer(celda);
		this.lista_comentarios.setFocusable(false);		
		scrollComentarios.setViewportView(this.lista_comentarios);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollComentarios, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollComentarios, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(489, 21, 245, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblTusComentarios = new JLabel(messages.getString("TusComentarios"));
		lblTusComentarios.setForeground(Color.WHITE);
		lblTusComentarios.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblTusComentarios.setBackground(Color.YELLOW);
		lblTusComentarios.setBounds(379, 21, 140, 64);
		frame.getContentPane().add(lblTusComentarios);
		
		JButton btnMenuPrincipal = new JButton(messages.getString("VolverMenuPrincipal"));
		btnMenuPrincipal.setFocusable(false);
		btnMenuPrincipal.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente mencli=new MenuCliente(clie, messages);
				frame.dispose();
			}
		});
		btnMenuPrincipal.setBackground(new Color(255, 153, 0));
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.setBounds(10, 612, 171, 23);
		frame.getContentPane().add(btnMenuPrincipal);
		
		JButton btnCerrarSesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso= new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(255, 153, 51));
		btnCerrarSesion.setBounds(744, 43, 128, 23);
		frame.getContentPane().add(btnCerrarSesion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Comentarios.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-24, 21, 393, 74);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void mostrarComentarios(){
		this.consulta="SELECT fechaCreacion, txtComentario FROM Comentarios WHERE Codigo_Cliente="+this.clie.getCodigoCliente()+";";
 		try {
			this.stmt = conexion.prepareStatement(this.consulta);
			//this.stmt.setInt(1, this.clie.getCodigoCliente());
			this.resultadoConsulta = this.stmt.executeQuery();
			this.modelo_lista_comentarios.clear();
			System.out.println("Consulta:"+this.consulta);
			while(resultadoConsulta.next()){
				this.modelo_lista_comentarios.addElement(new InfoComentario(this.clie.getUsuario(), resultadoConsulta.getString("fechaCreacion"), resultadoConsulta.getString("txtComentario")));
				System.out.print(resultadoConsulta.getString(1)+resultadoConsulta.getString(2));
			}	
		} catch (SQLException e) {
			System.out.println("Consulta:"+this.consulta);
			e.printStackTrace();
		}
	}
}
