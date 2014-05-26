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
	private JLabel lblVerificacion;
	private JLabel lblRealizado;
	
	String usuario;
	String fecha;
	String hora;
	int personas;
	int codigoUsuario;
	
	/**
	 * @wbp.parser.constructor
	 */
	public InfoReserva(String usuario, String fecha, String hora, int pers, int codigoUs, boolean realizado, boolean verificado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuRest=codigoUs;
		
		this.etiquetaNombre = new JLabel(usuario);	
		etiquetaNombre.setBounds(12, 11, 75, 17);
		etiquetaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaNombre.setForeground(new Color(255,153,0));
		
		this.etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setBounds(72, 39, 105, 17);
		etiquetaFecha.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaFecha.setForeground(new Color(255,153,0));
		
		this.etiquetaHora = new JLabel(hora);
		etiquetaHora.setBounds(72, 67, 105, 17);
		etiquetaHora.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaHora.setForeground(new Color(255,153,0));
		
		this.etiquetaPersonas = new JLabel(String.valueOf(pers));
		etiquetaPersonas.setBounds(252, 52, 33, 17);
		etiquetaPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaPersonas.setForeground(new Color(255,153,0));
		
		this.etiquetaVerificado = new JLabel(String.valueOf(verificado));
		etiquetaVerificado.setBounds(375, 40, 49, 14);
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		setLayout(null);
		add(etiquetaNombre);
		add(etiquetaHora);
		add(etiquetaFecha);
		add(etiquetaPersonas);
		add(etiquetaVerificado);
		
		JLabel etiquetaRealizacion = new JLabel("false");
		etiquetaRealizacion.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaRealizacion.setForeground(new Color(255, 153, 0));
		etiquetaRealizacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaRealizacion.setBounds(375, 68, 49, 14);
		add(etiquetaRealizacion);
		
		JLabel lblFecha = new JLabel("Dia:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(new Color(255, 153, 0));
		lblFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblFecha.setBounds(22, 39, 49, 17);
		add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(new Color(255, 153, 0));
		lblHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblHora.setBounds(22, 67, 49, 17);
		add(lblHora);
		
		JLabel lblPersonas = new JLabel("Personas:");
		lblPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonas.setForeground(new Color(255, 153, 0));
		lblPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblPersonas.setBounds(167, 52, 92, 17);
		add(lblPersonas);
		
		lblVerificacion = new JLabel("Verificado:");
		lblVerificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerificacion.setForeground(new Color(255, 153, 0));
		lblVerificacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblVerificacion.setBounds(283, 39, 92, 17);
		add(lblVerificacion);
		
		lblRealizado = new JLabel("Realizado:");
		lblRealizado.setHorizontalAlignment(SwingConstants.LEFT);
		lblRealizado.setForeground(new Color(255, 153, 0));
		lblRealizado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblRealizado.setBounds(283, 67, 92, 17);
		add(lblRealizado);
	}
	
	public InfoReserva(int codigoRes, String nomrest, String fecha, String hora, int pers, boolean realizado, boolean verificado){
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
	
	//GETTERS
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public String getHora(){
		return hora;
	}
	
	public int getPersonas(){
		return personas;
	}
	
	public int getCodigoUsuario(){
		return codigoUsuario;
	}	
}