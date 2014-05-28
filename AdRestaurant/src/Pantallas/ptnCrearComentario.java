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
import Clases.Comentario;
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
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
public class ptnCrearComentario extends JFrame {

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
	public ptnCrearComentario(final Cliente clie, final Restaurante rest, final ResourceBundle messages) {
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
		panel.setBounds(0, 94, 895, 409);
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
		panel.setLayout(null);
		
		JLabel lblReservaEn = new JLabel(messages.getString("ReservaEn"));
		lblReservaEn.setBounds(10, 62, 233, 22);
		lblReservaEn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReservaEn.setForeground(Color.LIGHT_GRAY);
		lblReservaEn.setFont(new Font("Fira Sans OT", Font.PLAIN, 23));
		panel.add(lblReservaEn);
		
		JLabel textRestaurante = new JLabel(rest.getNombre());
		textRestaurante.setBounds(256, 48, 606, 41);
		textRestaurante.setHorizontalAlignment(SwingConstants.LEFT);
		textRestaurante.setForeground(new Color(255, 153, 0));
		textRestaurante.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));
		panel.add(textRestaurante);
		
		JLabel lblRealizada = new JLabel(messages.getString("RealizadaPor"));
		lblRealizada.setBounds(10, 114, 233, 22);
		lblRealizada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRealizada.setForeground(Color.LIGHT_GRAY);
		lblRealizada.setFont(new Font("Fira Sans OT", Font.PLAIN, 23));
		panel.add(lblRealizada);
		
		JLabel textCliente = new JLabel(clie.getNombre()+" "+clie.getPrimerApellido()+" "+clie.getSegundoApellido());
		textCliente.setBounds(256, 100, 629, 41);
		textCliente.setHorizontalAlignment(SwingConstants.LEFT);
		textCliente.setForeground(new Color(255, 153, 0));
		textCliente.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 40));
		panel.add(textCliente);
		
		JLabel lblComentario = new JLabel(messages.getString("Comentario"));
		lblComentario.setForeground(new Color(255, 153, 0));
		lblComentario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 20));
		lblComentario.setBounds(63, 162, 137, 22);
		panel.add(lblComentario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 195, 789, 188);
		panel.add(scrollPane);
		
		final JTextArea textComentario = new JTextArea();
		textComentario.setWrapStyleWord(true);
		textComentario.setLineWrap(true);
		scrollPane.setViewportView(textComentario);
		//AbstractDocument docComentario = (AbstractDocument) textComentario.getDocument();
		
//		kommentarArea.getDocument().addDocumentListener(new DocumentListener {
//		    public void insertUpdate(DocumentEvent event) {
//		        if (kommentarArea.getDocument().getLength() > 255) {
//		            JOptionPane.showMessageDialog(null, "Die Länge der Kommentare ist länger als 255 Zeichern");
//		        }
//		    }
//
//		    public void removeUpdate(DocumentEvent e) {
//		        if (kommentarArea.getDocument().getLength() > 255) {
//		            JOptionPane.showMessageDialog(null, "Die Länge der Kommentare ist länger als 255 Zeichern");
//		        }
//		    }
//
//		    public void changeUpdate(DocumentEvent event) {
//		        if (kommentarArea.getDocument().getLength() > 255) {
//		            JOptionPane.showMessageDialog(null, "Die Länge der Kommentare ist länger als 255 Zeichern");
//		        }
//		    }
//		});
		
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
		
		JButton btnReservar = new JButton(messages.getString("Comentar"));
		btnReservar.setFocusable(false);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comentario comentario=new Comentario(rest, clie,textComentario.getText(), clie.getConexionConsulta());
				ptnComentarioCompletado comple=new ptnComentarioCompletado(clie, rest, messages);
				frame.dispose();
				//Comprobar campos
				
				//Reserva reser= new Reserva(rest.getNombre(), clie.getNombre(), String.valueOf(spinner.getValue())+String.valueOf(spinner_1.getValue())+String.valueOf(spinner_2.getValue()), String.valueOf(spinner_3.getValue())+String.valueOf(spinner_4.getValue()), "Ahora", String.valueOf(spinner_5.getValue()));
			}
		});
		btnReservar.setForeground(new Color(255, 153, 0));
		btnReservar.setBackground(new Color(255, 255, 255));
		btnReservar.setBounds(275, 514, 344, 36);
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

