package Pantallas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

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

public class Comentarios extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	Cliente clie;
	static Locale currentLocale;
    static ResourceBundle messages;

	/**
	 * Create the frame.
	 */
	public Comentarios( final Cliente clie, final ResourceBundle messages) {
		this.messages=messages;
		this.clie=clie;
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
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panel_1.setLayout(null);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("AdRestaurant");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Francois One", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(31, 11, 371, 74);
		frame.getContentPane().add(label);
		
		JLabel lblnomUser = new JLabel(clie.getNombre());
		lblnomUser.setForeground(Color.WHITE);
		lblnomUser.setFont(new Font("Fira Sans OT Light", Font.ITALIC, 17));
		lblnomUser.setBackground(Color.YELLOW);
		lblnomUser.setBounds(623, 21, 128, 64);
		frame.getContentPane().add(lblnomUser);
		
		JLabel lblTusComentarios = new JLabel(messages.getString("TusComentarios"));
		lblTusComentarios.setForeground(Color.WHITE);
		lblTusComentarios.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblTusComentarios.setBackground(Color.YELLOW);
		lblTusComentarios.setBounds(379, 21, 140, 64);
		frame.getContentPane().add(lblTusComentarios);
		
		JButton btnMenuPrincipal = new JButton(messages.getString("VolverMenuPrincipal"));
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
		frame.setBounds(100, 100, 895, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
