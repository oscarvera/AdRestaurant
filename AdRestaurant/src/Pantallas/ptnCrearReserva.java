package Pantallas;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Clases.Cliente;
import Clases.Reserva;
import Clases.Restaurante;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SpinnerNumberModel;
public class ptnCrearReserva extends JFrame {

	private JFrame frame;
	Cliente clie;
	Restaurante rest;
	static Locale currentLocale;
	static ResourceBundle messages;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 *  Create the frame. 
	 */
	public ptnCrearReserva(final Cliente clie, final Restaurante rest, final ResourceBundle messages) {
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
		panel.setBounds(0, 94, 895, 186);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		
		JLabel lblReservaEn = new JLabel(messages.getString("ReservaEn"));
		lblReservaEn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReservaEn.setForeground(Color.LIGHT_GRAY);
		lblReservaEn.setFont(new Font("Fira Sans OT", Font.PLAIN, 23));
		lblReservaEn.setBounds(10, 62, 233, 22);
		panel.add(lblReservaEn);
		
		JLabel textRestaurante = new JLabel(rest.getNombre());
		textRestaurante.setHorizontalAlignment(SwingConstants.LEFT);
		textRestaurante.setForeground(new Color(255, 153, 0));
		textRestaurante.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));
		textRestaurante.setBounds(256, 48, 606, 41);
		panel.add(textRestaurante);
		
		JLabel lblRealizada = new JLabel(messages.getString("RealizadaPor"));
		lblRealizada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRealizada.setForeground(Color.LIGHT_GRAY);
		lblRealizada.setFont(new Font("Fira Sans OT", Font.PLAIN, 23));
		lblRealizada.setBounds(10, 114, 233, 22);
		panel.add(lblRealizada);
		
		JLabel textCliente = new JLabel(clie.getNombre()+" "+clie.getPrimerApellido()+" "+clie.getSegundoApellido());
		textCliente.setHorizontalAlignment(SwingConstants.LEFT);
		textCliente.setForeground(new Color(255, 153, 0));
		textCliente.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));
		textCliente.setBounds(256, 100, 629, 41);
		panel.add(textCliente);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(498, 23, 229, 74);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBienvenido = new JLabel(messages.getString("NuevaReserva"));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBienvenido.setBackground(Color.YELLOW);
		lblBienvenido.setBounds(379, 23, 119, 74);
		frame.getContentPane().add(lblBienvenido);
		
		JButton btnCerrarsesion = new JButton(messages.getString("CerrarSesion"));
		btnCerrarsesion.setFocusable(false);
		btnCerrarsesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarsesion.setForeground(Color.WHITE);
		btnCerrarsesion.setBackground(new Color(255, 153, 51));
		btnCerrarsesion.setBounds(757, 50, 128, 23);
		frame.getContentPane().add(btnCerrarsesion);
		
		JButton btnMenuPrincipal = new JButton(messages.getString("VolverMenuPrincipal"));
		btnMenuPrincipal.setFocusable(false);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente menuclie=new MenuCliente(clie, messages);
 				frame.dispose();
			}
		});
		btnMenuPrincipal.setForeground(Color.WHITE);
		btnMenuPrincipal.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnMenuPrincipal.setBackground(new Color(255, 153, 0));
		btnMenuPrincipal.setBounds(39, 605, 171, 23);
		frame.getContentPane().add(btnMenuPrincipal);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(617, 334, 242, 202);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPersonas = new JLabel(messages.getString("Personas"));
		lblPersonas.setBounds(12, 52, 218, 22);
		lblPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonas.setForeground(Color.LIGHT_GRAY);
		lblPersonas.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		panel_3.add(lblPersonas);
		
		final JSpinner Personas = new JSpinner();
		Personas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		Personas.setBounds(97, 85, 47, 34);
		panel_3.add(Personas);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(326, 334, 242, 202);
		frame.getContentPane().add(panel_11);
		
		JLabel lblHora = new JLabel(messages.getString("Hora"));
		lblHora.setBounds(12, 56, 218, 22);
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(Color.LIGHT_GRAY);
		lblHora.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		final JSpinner Hora_hora = new JSpinner();
		Hora_hora.setModel(new SpinnerNumberModel(new Byte((byte) 0), null, new Byte((byte) 23), new Byte((byte) 1)));
		Hora_hora.setBounds(60, 89, 47, 34);
		
		final JSpinner Hora_minutos = new JSpinner();
		Hora_minutos.setModel(new SpinnerNumberModel(new Byte((byte) 0), null, new Byte((byte) 55), new Byte((byte) 5)));
		Hora_minutos.setBounds(130, 89, 47, 34);
		panel_11.setLayout(null);
		panel_11.add(lblHora);
		panel_11.add(Hora_hora);
		panel_11.add(Hora_minutos);
		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 23));
		lblNewLabel.setBounds(111, 89, 19, 34);
		panel_11.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(32, 334, 242, 202);
		frame.getContentPane().add(panel_2);
		
		JLabel lblFecha = new JLabel(messages.getString("Fecha"));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.LIGHT_GRAY);
		lblFecha.setFont(new Font("Fira Sans OT", Font.PLAIN, 21));
		
		final JSpinner Fecha_dia = new JSpinner();
		Fecha_dia.setModel(new SpinnerNumberModel(new Byte((byte) 1), new Byte((byte) 1), new Byte((byte) 31), new Byte((byte) 1)));
		
		final JSpinner Fecha_mes = new JSpinner();
		Fecha_mes.setModel(new SpinnerNumberModel(new Byte((byte) 1), new Byte((byte) 1), new Byte((byte) 12), new Byte((byte) 1)));
		
		final JSpinner Feha_Año = new JSpinner();
		Feha_Año.setModel(new SpinnerNumberModel(new Integer(2014), new Integer(2014), null, new Integer(1)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(45)
					.addComponent(Fecha_dia, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Fecha_mes, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Feha_Año, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(12)
					.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(lblFecha)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(Fecha_dia, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(Fecha_mes, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addComponent(Feha_Año, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(74))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblfecha = new JLabel(messages.getString("1.Fecha"));
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setForeground(new Color(255, 255, 255));
		lblfecha.setFont(new Font("Fira Sans OT", Font.PLAIN, 30));
		lblfecha.setBounds(39, 291, 229, 36);
		frame.getContentPane().add(lblfecha);
		
		JLabel lblhora = new JLabel(messages.getString("2.Hora"));
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setForeground(Color.WHITE);
		lblhora.setFont(new Font("Fira Sans OT", Font.PLAIN, 30));
		lblhora.setBounds(333, 291, 229, 36);
		frame.getContentPane().add(lblhora);
		
		JLabel lblpersonas = new JLabel(messages.getString("3.Personas"));
		lblpersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblpersonas.setForeground(Color.WHITE);
		lblpersonas.setFont(new Font("Fira Sans OT", Font.PLAIN, 30));
		lblpersonas.setBounds(624, 291, 229, 36);
		frame.getContentPane().add(lblpersonas);
		
		JButton btnReservar = new JButton(messages.getString("Reservar"));
		btnReservar.setFocusable(false);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fechaReserva=""+Feha_Año.getValue()+"-"+Fecha_mes.getValue()+"-"+Fecha_dia.getValue();
				String hora=""+Hora_hora.getValue()+":"+Hora_minutos.getValue()+":00";
				int personas=(Integer) Personas.getValue();
				System.out.println(""+Personas.getValue());
				Reserva reserva=new Reserva(rest, clie, fechaReserva, hora, personas, clie.getConexionConsulta());
				ptnReservaCompletada compl=new ptnReservaCompletada(clie, rest, messages);
				frame.dispose();
				//Comprobar campos
				
				//Reserva reser= new Reserva(rest.getNombre(), clie.getNombre(), String.valueOf(spinner.getValue())+String.valueOf(spinner_1.getValue())+String.valueOf(spinner_2.getValue()), String.valueOf(spinner_3.getValue())+String.valueOf(spinner_4.getValue()), "Ahora", String.valueOf(spinner_5.getValue()));
			}
		});
		btnReservar.setForeground(new Color(255, 153, 0));
		btnReservar.setBackground(new Color(255, 255, 255));
		btnReservar.setBounds(275, 560, 344, 36);
		frame.getContentPane().add(btnReservar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ptnCrearReserva.class.getResource("/Imagen/TituloPEQUE.png")));
		label.setBounds(-12, 23, 393, 74);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

