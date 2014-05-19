package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Clases.Cliente;
import Clases.Restaurante;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
public class ptnRestaurante extends JFrame {

	private JFrame frame;
	Cliente clie;
	Restaurante rest;
	
	static Locale currentLocale;
    static ResourceBundle messages;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ptnRestaurante(final Cliente clie, final Restaurante rest,final ResourceBundle messages) {
		this.clie=clie;
		this.rest=rest;
		this.messages=messages;
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
		panel.setBounds(0, 94, 895, 529);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel(rest.getNombre());
		lblNewLabel.setBounds(42, 29, 724, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(22, 88, 360, 235);
		lblImagen.setIcon(new ImageIcon(ptnRestaurante.class.getResource("/Imagen/olawu.jpg")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 359, 846, 164);
		
		JLabel lblNewLabel_1 = new JLabel(messages.getString("Comentarios"));
		lblNewLabel_1.setBounds(22, 334, 108, 19);
		lblNewLabel_1.setForeground(new Color(255, 153, 0));
		lblNewLabel_1.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(386, 88, 507, 235);
		panel_1.setBackground(new Color(255, 255, 255));
		
		JButton btnReservar = new JButton(messages.getString("Reservar"));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptnCrearReserva creaReser=new ptnCrearReserva(clie, rest, messages);
				frame.dispose();
			}
		});
		btnReservar.setBounds(745, 29, 108, 36);
		btnReservar.setForeground(new Color(255, 153, 0));
		btnReservar.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnReservar.setBackground(null);
		
		JLabel lbTipo = new JLabel(messages.getString("Tipo"));
		lbTipo.setBounds(72, 28, 47, 22);
		lbTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTipo.setForeground(Color.LIGHT_GRAY);
		lbTipo.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textTipo = new JLabel(rest.getTipo());
		textTipo.setBounds(129, 29, 231, 21);
		textTipo.setForeground(new Color(255, 153, 0));
		textTipo.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel lbTelefono = new JLabel(messages.getString("Telefono"));
		lbTelefono.setBounds(30, 95, 89, 22);
		lbTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefono.setForeground(Color.LIGHT_GRAY);
		lbTelefono.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textTelefono = new JLabel(String.valueOf(rest.getTelefono()));
		textTelefono.setBounds(129, 96, 154, 21);
		textTelefono.setForeground(new Color(255, 153, 0));
		textTelefono.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel lbDireccion = new JLabel(messages.getString("Direccion"));
		lbDireccion.setBounds(23, 62, 96, 22);
		lbDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDireccion.setForeground(Color.LIGHT_GRAY);
		lbDireccion.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textDireccion = new JLabel(rest.getDireccion());
		textDireccion.setBounds(129, 61, 246, 21);
		textDireccion.setForeground(new Color(255, 153, 0));
		textDireccion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel lbPoblacion = new JLabel(messages.getString("Poblacion"));
		lbPoblacion.setBounds(10, 128, 109, 22);
		lbPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPoblacion.setForeground(Color.LIGHT_GRAY);
		lbPoblacion.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textPoblacion = new JLabel(rest.getPoblacion());
		textPoblacion.setBounds(129, 128, 154, 21);
		textPoblacion.setForeground(new Color(255, 153, 0));
		textPoblacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel textProvincia = new JLabel(rest.getProvincia());
		textProvincia.setBounds(382, 129, 125, 21);
		textProvincia.setForeground(new Color(255, 153, 0));
		textProvincia.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel lbProvincia = new JLabel(messages.getString("Provincia"));
		lbProvincia.setBounds(266, 128, 109, 22);
		lbProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProvincia.setForeground(Color.LIGHT_GRAY);
		lbProvincia.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel lbCP = new JLabel(messages.getString("CP"));
		lbCP.setBounds(10, 161, 109, 22);
		lbCP.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCP.setForeground(Color.LIGHT_GRAY);
		lbCP.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textCP = new JLabel(rest.getCodigoPostal());
		textCP.setBounds(129, 160, 125, 21);
		textCP.setForeground(new Color(255, 153, 0));
		textCP.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		
		JLabel lbMinusvalidos = new JLabel(messages.getString("AP"));
		lbMinusvalidos.setBounds(10, 194, 199, 22);
		lbMinusvalidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinusvalidos.setForeground(Color.LIGHT_GRAY);
		lbMinusvalidos.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		JLabel textMinusvalidos= new JLabel(messages.getString("NO"));
		textMinusvalidos.setBounds(219, 192, 212, 21);
		if(rest.getMinusvalidoApto()){
			textMinusvalidos.setText(messages.getString("SI"));
		}else{
			textMinusvalidos.setText(messages.getString("NO"));
		}
		
		
		textMinusvalidos.setForeground(new Color(255, 153, 0));
		textMinusvalidos.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		panel_1.setLayout(null);
		panel_1.add(lbTipo);
		panel_1.add(textTipo);
		panel_1.add(lbTelefono);
		panel_1.add(textTelefono);
		panel_1.add(lbPoblacion);
		panel_1.add(textPoblacion);
		panel_1.add(lbDireccion);
		panel_1.add(textDireccion);
		panel_1.add(lbProvincia);
		panel_1.add(textProvincia);
		panel_1.add(lbCP);
		panel_1.add(textCP);
		panel_1.add(lbMinusvalidos);
		panel_1.add(textMinusvalidos);
		panel.setLayout(null);
		panel.add(btnReservar);
		panel.add(lblImagen);
		panel.add(panel_1);
		panel.add(lblNewLabel_1);
		panel.add(scrollPane);
		panel.add(lblNewLabel);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(599, 18, 128, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblRestaurante = new JLabel(messages.getString("Restaurante"));
		lblRestaurante.setForeground(Color.WHITE);
		lblRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblRestaurante.setBackground(Color.YELLOW);
		lblRestaurante.setBounds(384, 19, 96, 64);
		frame.getContentPane().add(lblRestaurante);
		
		JButton btnCerrarsesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarsesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarsesion.setForeground(Color.WHITE);
		btnCerrarsesion.setBackground(new Color(255, 153, 51));
		btnCerrarsesion.setBounds(737, 40, 128, 23);
		frame.getContentPane().add(btnCerrarsesion);
		
		JButton button = new JButton(messages.getString("VolverMenuPrincipal"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menuclie=new MenuCliente(clie, messages);
 				frame.dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		button.setBackground(new Color(255, 153, 0));
		button.setBounds(31, 623, 171, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ptnRestaurante.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-12, 18, 393, 64);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
}
