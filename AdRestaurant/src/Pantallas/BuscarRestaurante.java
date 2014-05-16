package Pantallas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Clases.Cliente;

public class BuscarRestaurante extends JFrame{
	Cliente clie;
	private JFrame frame;
	private JTextField textCP;
	private JTextField textNombre;
	private JTextField textDireccion;
	JPanel panel_1;
	JComboBox comboTipo;
	
	private JButton btnXDireccion;
	private JButton btnXNombre;
	private JButton btnXCP;
	private JButton btnXTipo;

	/**
	 * Create the application.
	 */
	//Constructor. Recibe un objeto cliente.
	public BuscarRestaurante(Cliente clie ) {
		this.clie=clie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 97, 895, 488);
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
		btnBuscar.setBounds(10, 241, 187, 43);
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
				if(textNombre.getText().compareTo("Nombre")==0||textNombre.getText().isEmpty()){
					textNombre.setText("Nombre");
					textNombre.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXNombre);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textNombre.getText().compareTo("Nombre")==0||textNombre.getText().isEmpty()){
					textNombre.setText("");
					textNombre.setForeground(new Color(255, 153, 51));
					}
			}
		};
		
		//DIRECION
		
		KeyListener keylisDireccion=new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				panel_1.add(btnXDireccion);
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
				if(textDireccion.getText().compareTo("Dirección")==0||textDireccion.getText().isEmpty()){
					textDireccion.setText("Dirección");
					textDireccion.setForeground(Color.LIGHT_GRAY);
					panel_1.remove(btnXDireccion);
					panel_1.repaint();
					}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textDireccion.getText().compareTo("Dirección")==0||textDireccion.getText().isEmpty()){
					textDireccion.setText("");
					textDireccion.setForeground(new Color(255, 153, 51));
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
				
				FocusListener focusCP=new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent arg0) {
						if(textCP.getText().compareTo("Código Postal")==0||textCP.getText().isEmpty()){
							textCP.setText("Código Postal");
							textCP.setForeground(Color.LIGHT_GRAY);
							panel_1.remove(btnXCP);
							panel_1.repaint();
							}
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						if(textCP.getText().compareTo("Código Postal")==0||textCP.getText().isEmpty()){
							textCP.setText("");
							textCP.setForeground(new Color(255, 153, 51));
							}
					}
				};
				
				
		//Tipo	
				ItemListener itemLisTipo= new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						if(comboTipo.getSelectedItem().toString()=="Tipo"){
							comboTipo.setForeground(Color.LIGHT_GRAY);
							panel_1.remove(btnXTipo);
							panel_1.repaint();
							}else{
								comboTipo.setForeground(new Color(255, 153, 51));
								panel_1.add(btnXTipo);
								panel_1.repaint();
								
							}
						
					}
				};
				
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(255, 255, 255));
		textNombre.setBounds(10, 28, 165, 46);
		textNombre.setText("Nombre");
		textNombre.setForeground(Color.LIGHT_GRAY);
		textNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textNombre.setColumns(10);
		textNombre.addFocusListener(focusNombre);
		textNombre.addKeyListener(keylisNombre);
		textNombre.setBorder(null);
		
		
		
		
		textDireccion = new JTextField();
		textDireccion.setBounds(10, 80, 165, 46);
		textDireccion.setText("Direcci\u00F3n");
		textDireccion.setForeground(Color.LIGHT_GRAY);
		textDireccion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textDireccion.setColumns(10);
		textDireccion.addKeyListener(keylisDireccion);
		textDireccion.addFocusListener(focusDireccion);
		textDireccion.setBorder(null);
		
		textCP = new JTextField();
		textCP.setBounds(10, 132, 165, 46);
		textCP.setText("C\u00F3digo Postal");
		textCP.setForeground(Color.LIGHT_GRAY);
		textCP.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textCP.setColumns(10);
		textCP.addKeyListener(keylisCP);
		textCP.addFocusListener(focusCP);
		textCP.setBorder(null);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "Chino", "Japon\u00E9s", "Mexicano", "Italiano", "Espa\u00F1ol", "Alem\u00E1n", "Estadounidense"}));
		comboTipo.setBounds(10, 184, 165, 46);
		comboTipo.setForeground(Color.LIGHT_GRAY);
		comboTipo.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		comboTipo.setBackground(Color.WHITE);
		comboTipo.setBorder(null);
		comboTipo.addItemListener(itemLisTipo);
		
		
		JLabel lblOtrasBusquedas = new JLabel("Otras b\u00FAsquedas");
		lblOtrasBusquedas.setBounds(10, 285, 190, 64);
		lblOtrasBusquedas.setForeground(new Color(255, 153, 51));
		lblOtrasBusquedas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblOtrasBusquedas.setBackground(Color.YELLOW);
		
		JButton btnMejorValorado = new JButton("Mejor Valorado");
		btnMejorValorado.setBounds(20, 351, 165, 43);
		btnMejorValorado.setForeground(new Color(255, 153, 0));
		btnMejorValorado.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnMejorValorado.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		btnXNombre = new JButton("");
		btnXNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setText("Nombre");
				textNombre.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXNombre);
				panel_1.repaint();
			}
		});
		btnXNombre.setBounds(175, 28, 22, 46);
		btnXNombre.setBackground(Color.WHITE);
		btnXNombre.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXNombre.setBorder(null);
		
		
		
		
		panel_1.add(textNombre);
		panel_1.add(textDireccion);
		panel_1.add(textCP);
		panel_1.add(comboTipo);
		panel_1.add(btnBuscar);
		panel_1.add(btnMejorValorado);
		panel_1.add(lblOtrasBusquedas);
		
		JButton btnNuevos = new JButton("Nuevos");
		btnNuevos.setForeground(new Color(255, 153, 0));
		btnNuevos.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnNuevos.setBackground(Color.WHITE);
		btnNuevos.setBounds(20, 403, 165, 43);
		panel_1.add(btnNuevos);
		
		btnXDireccion = new JButton("");
		btnXDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textDireccion.setText("Dirección");
				textDireccion.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXDireccion);
				panel_1.repaint();
				
			}
		});
		btnXDireccion.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXDireccion.setBorder(null);
		btnXDireccion.setBackground(Color.WHITE);
		btnXDireccion.setBounds(175, 80, 22, 46);
		
		
		btnXCP = new JButton("");
		btnXCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCP.setText("Código Postal");
				textCP.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXCP);
				panel_1.repaint();
			}
		});
		btnXCP.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXCP.setBorder(null);
		btnXCP.setBackground(Color.WHITE);
		btnXCP.setBounds(175, 132, 22, 46);
		
		
		btnXTipo = new JButton("");
		btnXTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboTipo.setSelectedIndex(0);
				comboTipo.setForeground(Color.LIGHT_GRAY);
				panel_1.requestFocus();
				panel_1.remove(btnXTipo);
				panel_1.repaint();
			}
		});
		btnXTipo.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Imagen/botonX.png")));
		btnXTipo.setBorder(null);
		btnXTipo.setBackground(Color.WHITE);
		btnXTipo.setBounds(175, 184, 22, 46);
		
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(24, 12, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(637, 22, 110, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblBuscarRestaurante = new JLabel("Buscar Restaurante");
		lblBuscarRestaurante.setForeground(Color.WHITE);
		lblBuscarRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBuscarRestaurante.setBackground(Color.YELLOW);
		lblBuscarRestaurante.setBounds(380, 22, 162, 64);
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
		btnMenuPrincipal.setBounds(24, 601, 171, 23);
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
		btnCerrarSesion.setBounds(757, 44, 128, 23);
		frame.getContentPane().add(btnCerrarSesion);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
