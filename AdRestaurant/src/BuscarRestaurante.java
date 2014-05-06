import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class BuscarRestaurante extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarRestaurante window = new BuscarRestaurante();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public BuscarRestaurante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 86, 889, 481);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Aqui", "los ", "restaurantes", "listados", "todos", "y", "cada", "uno", "de", "ellos"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton button = new JButton("BUSCAR");
		button.setBounds(20, 231, 165, 43);
		button.setForeground(new Color(255, 153, 0));
		button.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		button.setBackground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "Chino", "Japon\u00E9s", "Mexicano", "Italiano", "Espa\u00F1ol", "Alem\u00E1n", "Estadounidense"}));
		comboBox.setBounds(10, 184, 187, 41);
		comboBox.setForeground(new Color(255, 153, 0));
		comboBox.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(10, 132, 187, 46);
		textField.setText("C\u00F3digo Postal");
		textField.setForeground(new Color(255, 153, 0));
		textField.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 28, 187, 46);
		textField_1.setText("Nombre");
		textField_1.setForeground(new Color(255, 153, 0));
		textField_1.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 80, 187, 46);
		textField_2.setText("Direcci\u00F3n");
		textField_2.setForeground(new Color(255, 153, 0));
		textField_2.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		textField_2.setColumns(10);
		
		JLabel lblOtrasBusquedas = new JLabel("Otras b\u00FAsquedas");
		lblOtrasBusquedas.setBounds(10, 285, 190, 64);
		lblOtrasBusquedas.setForeground(Color.WHITE);
		lblOtrasBusquedas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblOtrasBusquedas.setBackground(Color.YELLOW);
		
		JButton btnMejorValorado = new JButton("Mejor Valorado");
		btnMejorValorado.setBounds(20, 351, 165, 43);
		btnMejorValorado.setForeground(new Color(255, 153, 0));
		btnMejorValorado.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnMejorValorado.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.add(textField_1);
		panel_1.add(textField_2);
		panel_1.add(textField);
		panel_1.add(comboBox);
		panel_1.add(button);
		panel_1.add(btnMejorValorado);
		panel_1.add(lblOtrasBusquedas);
		
		JButton btnNuevos = new JButton("Nuevos");
		btnNuevos.setForeground(new Color(255, 153, 0));
		btnNuevos.setFont(new Font("Fira Sans OT", Font.PLAIN, 15));
		btnNuevos.setBackground(Color.WHITE);
		btnNuevos.setBounds(20, 403, 165, 43);
		panel_1.add(btnNuevos);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(22, 1, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel("\"Nom user\"");
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT", Font.PLAIN, 20));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(674, 11, 128, 64);
		frame.getContentPane().add(lblnomUser);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main=new Main();
				frame.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 153, 51));
		btnNewButton_1.setBounds(802, 34, 66, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblBuscarRestaurante = new JLabel("Buscar Restaurante");
		lblBuscarRestaurante.setForeground(Color.WHITE);
		lblBuscarRestaurante.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblBuscarRestaurante.setBackground(Color.YELLOW);
		lblBuscarRestaurante.setBounds(378, 11, 190, 64);
		frame.getContentPane().add(lblBuscarRestaurante);
		
		JButton btnNewButton = new JButton("Volver al men\u00FA principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente menuclie=new MenuCliente();
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(22, 578, 171, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
