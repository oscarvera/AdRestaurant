package Pantallas;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Consulta;
import Clases.Cliente;
import Clases.Restaurante;

public class ptnReservasRestaurante extends JFrame {

	private JPanel contentPane;


	private JFrame frame;
	Restaurante rest;
	private JButton btnXFecha;
	private JButton btnXNombre;
	private JButton btnXCP;
	private JButton btnXTipo;

	static Locale currentLocale;
	static ResourceBundle messages;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ptnReservasRestaurante(Restaurante rest) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		initialize();
		this.rest=rest;
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
		botonX();
		botonesptnReservasRestaurante();
	}
	/**
	 *Botón X para Salir de la aplicación con pequeño JPanel Blanco
	 */
	public void botonX(){
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
				Consulta c= rest.getConexionConsulta();
				Salir salir=new Salir(messages, c);

			}
		});
	}

	/**
	 * Todos los botones de la pantalla ptnReservasRestaurante
	 */
	public void botonesptnReservasRestaurante(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 86, 895, 481);
		frame.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
						.addContainerGap())
				);

		DefaultListModel dlm=new DefaultListModel();
		JList list = new JList();
		list.setBorder(new EmptyBorder(21, 10, 10, 10));
		list.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 17));
		list.setValueIsAdjusting(true);
		list.setForeground(new Color(255, 153, 0));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(int i=0;i<50;i++){
			String reserva="<html>Nombre del resetaurante"+i+"<br><table cellpadding='10px'><tr><td><font color=silver>Fecha: </font></td><td><font color=silver> Hora: </font></td><td><font color=silver>Personas: </font></td><td><font color=silver>Verificado: </font></td></tr></table></html>";
			dlm.addElement(reserva);
		}

		list.setModel(dlm);
		scrollPane.setViewportView(list);
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
		label.setIcon(new ImageIcon(ptnBuscarReservas.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-11, 23, 393, 64);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
