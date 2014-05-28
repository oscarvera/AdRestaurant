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
import java.awt.Font;
import javax.swing.SwingConstants;

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
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0)));
		setBackground(Color.GRAY);
		
		this.codigo=codigo;
		
		this.etiqueta_nombre = new JLabel(nombre);
		etiqueta_nombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiqueta_nombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiqueta_nombre.setForeground(new Color(255,153,0));
		
		this.etiqueta_tipo = new JLabel(tipo);
		etiqueta_tipo.setHorizontalAlignment(SwingConstants.LEFT);
		etiqueta_tipo.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiqueta_tipo.setForeground(new Color(255,153,0));
		
		this.etiqueta_poblacion= new JLabel(poblacion);
		etiqueta_poblacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		etiqueta_poblacion.setForeground(new Color(255,153,0));
		
		this.etiqueta_direccion = new JLabel(direccion);
		etiqueta_direccion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		etiqueta_direccion.setForeground(new Color(255,153,0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(etiqueta_nombre, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(etiqueta_tipo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiqueta_direccion)
						.addComponent(etiqueta_poblacion))
					.addGap(95))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(etiqueta_direccion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(etiqueta_poblacion))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(etiqueta_nombre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(etiqueta_tipo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(0, Short.MAX_VALUE))
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
