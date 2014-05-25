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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class InfoRestaurante extends JPanel  {
	private JLabel etiqueta_nombre;
	private JLabel etiqueta_poblacion;
	private JLabel etiqueta_tipo;
	private JLabel etiqueta_direccion;
	private int codigo;
	
	/**
	 * Create the panel.
	 */
	public InfoRestaurante(String nombre, String direccion, String poblacion, String tipo, int codigo) {
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE));
		setBackground(Color.GRAY);
		
		this.codigo=codigo;
		
		this.etiqueta_nombre = new JLabel(nombre);
		etiqueta_nombre.setForeground(Color.ORANGE);
		
		this.etiqueta_tipo = new JLabel(tipo);
		etiqueta_tipo.setForeground(Color.ORANGE);
		
		this.etiqueta_poblacion= new JLabel(poblacion);
		etiqueta_poblacion.setForeground(Color.ORANGE);
		
		this.etiqueta_direccion = new JLabel(direccion);
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
					.addContainerGap())
					//.addContainerGap(194, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	public void fondoBlanco(){
		this.etiqueta_direccion.setForeground(new Color(255, 255, 255));
		this.etiqueta_poblacion.setForeground(new Color(255, 255, 255));
		this.etiqueta_tipo.setForeground(new Color(255, 255, 255));
		this.etiqueta_nombre.setForeground(new Color(255, 255, 255));
	}
	
	public void fondoNaranja(){
		this.etiqueta_direccion.setForeground(new Color(255, 153, 0));
		this.etiqueta_poblacion.setForeground(new Color(255, 153, 0));
		this.etiqueta_tipo.setForeground(new Color(255, 153, 0));
		this.etiqueta_nombre.setForeground(new Color(255, 153, 0));
	}
	
	public void cambiaColor(){
		this.etiqueta_nombre.setForeground(new Color(255, 255, 255));
	}
	
	public InfoRestaurante getInfoRestaurante(){
		return (this);
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
