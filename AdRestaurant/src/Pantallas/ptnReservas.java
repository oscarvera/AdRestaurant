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

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.MatteBorder;

import Clases.Cliente;

public class ptnReservas extends JFrame {
	Cliente clie=new Cliente("Prueba");
	private JFrame frame;
	private JTextField textNombreRest;
	private JTextField textFecha;
	JPanel panel_1;
	
	private JButton btnXFecha;
	private JButton btnXNombre;
	private JButton btnXCP;
	private JButton btnXTipo;
	
public ptnReservas(){
	initialize();
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
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 86, 889, 481);
		frame.getContentPane().add(panel);
		
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 0, 4, (Color) new Color(255, 153, 51)));
		panel_1.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addGap(11))
		);
		
		JList list = new JList();
		list.setBorder(null);
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Aqui", "los ", "restaurantes", "listados", "todos", "y", "cada", "uno", "de", "ellos", "asdd", "asg", "asg", "asdg", "asdg", "asdg", "asdg", "asd", "gas", "dg", "asg", "asd", "g", "asd", "g", "asdg", "as", "dg", "asdg", "s", "dgas", "dg", "asdg", "as", "dg", "asd", "g", "asdg", "asdg", "as", "dg", "aqui", "acaba"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(10, 274, 187, 43);
		btnBuscar.setForeground(new Color(255, 153, 0));
		btnBuscar.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnBuscar.setBackground(Color.WHITE);
		

		
		
		
		//KEYLIST Y FOCUS LISTENERS DE LOS CAMPOS
		
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
				if(textNombreRest.getText().compareTo("Nombre Restaurante")==0||textNombreRest.getText().isEmpty()){
					textNombreRest.setText("Nombre Restaurante");
					textNombreRest.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXNombre);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textNombreRest.getText().compareTo("Nombre Restaurante")==0||textNombreRest.getText().isEmpty()){
					textNombreRest.setText("");
					textNombreRest.setForeground(new Color(255, 153, 51));
					}
			}
		};
		
		//DIRECION
		
		KeyListener keylisDireccion=new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				panel_1.add(btnXFecha);
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
				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
					textFecha.setText("Fecha");
					textFecha.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXFecha);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textFecha.getText().compareTo("Fecha")==0||textFecha.getText().isEmpty()){
					textFecha.setText("");
					textFecha.setForeground(new Color(255, 153, 51));
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
				
				
				
				
		
				
		
		textNombreRest = new JTextField();
		textNombreRest.setBackground(new Color(255, 255, 255));
		textNombreRest.setBounds(10, 145, 165, 46);
		textNombreRest.setText("Nombre Restaurante");
		textNombreRest.setForeground(Color.LIGHT_GRAY);
		textNombreRest.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textNombreRest.setColumns(10);
		textNombreRest.addFocusListener(focusNombre);
		textNombreRest.addKeyListener(keylisNombre);
		textNombreRest.setBorder(null);
		
		
		
		
		textFecha = new JTextField();
		textFecha.setBounds(10, 197, 165, 46);
		textFecha.setText("Fecha");
		textFecha.setForeground(Color.LIGHT_GRAY);
		textFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textFecha.setColumns(10);
		textFecha.addKeyListener(keylisDireccion);
		textFecha.addFocusListener(focusDireccion);
		textFecha.setBorder(null);
		panel_1.setLayout(null);
		
		btnXNombre = new JButton("");
		btnXNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombreRest.setText("Nombre");
				textNombreRest.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXNombre);
				panel_1.repaint();
			}
		});
		btnXNombre.setBounds(175, 145, 22, 46);//175, 28, 22, 46
		btnXNombre.setBackground(Color.WHITE);
		btnXNombre.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXNombre.setBorder(null);
		
		
		
		
		panel_1.add(textNombreRest);
		panel_1.add(textFecha);
		panel_1.add(btnBuscar);
		
		btnXFecha = new JButton("");
		btnXFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFecha.setText("Direcci�n");
				textFecha.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXFecha);
				panel_1.repaint();
				
			}
		});
		btnXFecha.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXFecha.setBorder(null);
		btnXFecha.setBackground(Color.WHITE);
		btnXFecha.setBounds(175, 145, 165, 46);
		
		
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(22, 1, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT", Font.PLAIN, 20));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(553, 11, 110, 64);
		frame.getContentPane().add(lblnomUser);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salir salir=new Salir(clie);
				frame.dispose();
			}
		});
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 153, 51));
		btnSalir.setBounds(823, 35, 66, 23);
		frame.getContentPane().add(btnSalir);
		
		JLabel lblBuscarRestaurante = new JLabel("Buscar Restaurante");
		lblBuscarRestaurante.setForeground(Color.WHITE);
		lblBuscarRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBuscarRestaurante.setBackground(Color.YELLOW);
		lblBuscarRestaurante.setBounds(392, 12, 162, 64);
		frame.getContentPane().add(lblBuscarRestaurante);
		
		JButton btnMenuPrincipal = new JButton("Volver al men\u00FA principal");
		btnMenuPrincipal.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente menuclie=new MenuCliente(clie);
				frame.dispose();
			}
		});
		btnMenuPrincipal.setBackground(new Color(255, 153, 0));
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.setBounds(22, 578, 171, 23);
		frame.getContentPane().add(btnMenuPrincipal);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingreso ingreso=new Ingreso();
				frame.dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(255, 153, 51));
		btnCerrarSesion.setBounds(685, 35, 128, 23);
		frame.getContentPane().add(btnCerrarSesion);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
}
}

