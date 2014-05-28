package Pantallas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JTextArea;

public class InfoComentario extends JPanel{
	
	private JLabel etiquetaUsuario;
	private JLabel etiquetaFecha;
	private JTextArea textoComentario; 
	private JTextPane textPane;
	
	/**
	 * Constructor para los comentarios que ve el restaurante
	 * @param usuario
	 * @param fechaRes
	 * @param coment
	 */
	public InfoComentario(String usuario, String fechaRes, String coment){
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		
		this.etiquetaUsuario = new JLabel(usuario);
		etiquetaUsuario.setForeground(new Color(255,153,0));
		etiquetaUsuario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		this.etiquetaFecha = new JLabel(fechaRes);
		etiquetaFecha.setForeground(new Color(255,153,0));
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		this.textoComentario = new JTextArea();
		textoComentario.setEditable(false);
		textoComentario.setText("'"+coment+"'");
		textoComentario.setLineWrap(true);
		textoComentario.setWrapStyleWord(true);
		textoComentario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 14));
		textoComentario.setForeground(new Color(255,153,0));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textoComentario, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(etiquetaUsuario)
							.addPreferredGap(ComponentPlacement.RELATED, 628, Short.MAX_VALUE)
							.addComponent(etiquetaFecha)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(etiquetaUsuario)
						.addComponent(etiquetaFecha))
					.addGap(18)
					.addComponent(textoComentario, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Constructor para los comentarios que ve el cliente
	 * @param usuario
	 * @param fechaRes
	 * @param coment
	 */
	public InfoComentario(String nombreRestaurante, String fechaRes, String coment, int a){
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		
		this.etiquetaUsuario = new JLabel(nombreRestaurante);
		etiquetaUsuario.setForeground(new Color(255,153,0));
		etiquetaUsuario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		this.etiquetaFecha = new JLabel(fechaRes);
		etiquetaFecha.setForeground(new Color(255,153,0));
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		this.textoComentario = new JTextArea();
		textoComentario.setEditable(false);
		textoComentario.setText("'"+coment+"'");
		textoComentario.setLineWrap(true);
		textoComentario.setWrapStyleWord(true);
		textoComentario.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 14));
		textoComentario.setForeground(new Color(255,153,0));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textoComentario, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(etiquetaUsuario)
							.addPreferredGap(ComponentPlacement.RELATED, 628, Short.MAX_VALUE)
							.addComponent(etiquetaFecha)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(etiquetaUsuario)
						.addComponent(etiquetaFecha))
					.addGap(18)
					.addComponent(textoComentario, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Cambia a color blanco las letras cuando se selecciona el panel y el fondo cambia a naranja.
	 */
	public void colorBlanco(){
		this.etiquetaFecha.setForeground(new Color(255, 255, 255));
		this.etiquetaUsuario.setForeground(new Color(255, 255, 255));
		this.textoComentario.setBackground(new Color(255,153,0));		
		this.textoComentario.setForeground(new Color(255, 255, 255));
	}
	
	/**
	 * Cambia a color naranja las letras cuando el fondo es blanco.
	 */
	public void colorNaranja(){
		this.etiquetaFecha.setForeground(new Color(255,153,0));
		this.etiquetaUsuario.setForeground(new Color(255,153,0));
		this.textoComentario.setBackground(new Color(255, 255, 255));
		this.textoComentario.setForeground(new Color(255,153,0));
	}
}
