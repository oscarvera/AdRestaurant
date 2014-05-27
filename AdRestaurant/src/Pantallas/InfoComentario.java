package Pantallas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class InfoComentario extends JPanel{
	
	private JLabel etiquetaUsuario;
	private JLabel etiquetaFecha;
	private JLabel etiquetaTextoComentario;
	
	public InfoComentario(String usuario, String fechaRes, String coment){
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		
		JLabel etiquetaUsuario = new JLabel(usuario);
		JLabel etiquetaFecha = new JLabel(fechaRes);
		JLabel etiquetaTextoComentario = new JLabel(coment);
		
		etiquetaTextoComentario.setVerticalAlignment(SwingConstants.TOP);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		popupMenu.add(coment);
		
		JTextPane textPane = new JTextPane();
		popupMenu.add(textPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(etiquetaUsuario)
							.addGap(105)
							.addComponent(etiquetaFecha))
						.addComponent(etiquetaTextoComentario, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(etiquetaUsuario)
						.addComponent(etiquetaFecha))
					.addGap(6)
					.addComponent(etiquetaTextoComentario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
