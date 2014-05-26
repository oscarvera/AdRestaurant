package Pantallas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import Clases.Cliente;
import Clases.Restaurante;

import java.awt.Color;
import java.awt.Font;

public class InfoReserva extends JPanel{
	
	private JLabel etiquetaNombre;
	private JLabel etiquetaFecha;
	private JLabel etiquetaHora;
	private JLabel etiquetaPersonas;
	private JLabel etiquetaVerificado;
	private int codigoUsuRest;
	private boolean realizado;
	private boolean verificado;
	
	public InfoReserva(String usuario, String fecha, String hora, int pers, boolean verificado, int codigoUs, boolean realizado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuRest=codigoUs;
		
		this.etiquetaNombre = new JLabel(usuario);	
		etiquetaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaNombre.setForeground(new Color(255,153,0));
		
		this.etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaFecha.setForeground(new Color(255,153,0));
		
		this.etiquetaHora = new JLabel(hora);
		etiquetaHora.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaHora.setForeground(new Color(255,153,0));
		
		this.etiquetaPersonas = new JLabel(String.valueOf(pers));
		etiquetaPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaPersonas.setForeground(new Color(255,153,0));
		
		this.etiquetaVerificado = new JLabel(String.valueOf(verificado));
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(etiquetaNombre)
							.addContainerGap(194, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(etiquetaPersonas, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(19))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(etiquetaNombre)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiquetaPersonas)
						.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);	
	}
	
	public InfoReserva(String nomrest, String fecha, String hora, int pers, int codigoRes, boolean realizado, boolean verificado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.codigoUsuRest=codigoRes;
		
		this.etiquetaNombre = new JLabel(nomrest);	
		etiquetaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaNombre.setForeground(new Color(255,153,0));
		
		this.etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaFecha.setForeground(new Color(255,153,0));
		
		this.etiquetaHora = new JLabel(hora);
		etiquetaHora.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaHora.setForeground(new Color(255,153,0));
		
		this.etiquetaPersonas = new JLabel(String.valueOf(pers));
		etiquetaPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaPersonas.setForeground(new Color(255,153,0));
		
		this.etiquetaVerificado = new JLabel(String.valueOf(verificado));
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(etiquetaNombre)
							.addContainerGap(194, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(etiquetaPersonas, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(19))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(etiquetaNombre)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiquetaPersonas)
						.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);	
	}
	
	public void fondoNaranja(){
		this.etiquetaNombre.setForeground(new Color(255, 153, 0));
		this.etiquetaFecha.setForeground(new Color(255, 153, 0));
		this.etiquetaHora.setForeground(new Color(255, 153, 0));
		this.etiquetaPersonas.setForeground(new Color(255, 153, 0));
		this.etiquetaVerificado.setForeground(new Color(255, 153, 0));
	}

	public void fondoBlanco() {
		this.etiquetaNombre.setForeground(new Color(255, 255, 255));
		this.etiquetaFecha.setForeground(new Color(255, 255, 255));
		this.etiquetaHora.setForeground(new Color(255, 255, 255));
		this.etiquetaPersonas.setForeground(new Color(255, 255, 255));
		this.etiquetaVerificado.setForeground(new Color(255, 255, 255));
	}
}
