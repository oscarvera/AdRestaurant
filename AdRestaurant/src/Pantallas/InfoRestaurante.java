package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class InfoRestaurante extends JPanel  {

	
	/**
	 * Create the panel.
	 */
	public InfoRestaurante(String nombre, String direccion, String poblacion, String tipo) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.GRAY);
		
		JLabel etiqueta_nombre = new JLabel(nombre);
		etiqueta_nombre.setForeground(Color.ORANGE);
		etiqueta_nombre.setBackground(Color.ORANGE);
		
		JLabel etiqueta_tipo = new JLabel(tipo);
		etiqueta_tipo.setForeground(Color.ORANGE);
		
		JLabel etiqueta_poblacion= new JLabel(poblacion);
		etiqueta_poblacion.setForeground(Color.ORANGE);
		
		JLabel etiqueta_direccion = new JLabel(direccion);
		etiqueta_direccion.setForeground(Color.ORANGE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(etiqueta_tipo)
						.addComponent(etiqueta_nombre))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(etiqueta_poblacion)
						.addComponent(etiqueta_direccion))
					.addGap(60))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(etiqueta_nombre)
						.addComponent(etiqueta_direccion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(etiqueta_tipo)
						.addComponent(etiqueta_poblacion))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	
}
