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
import javax.swing.ImageIcon;

public class InfoReserva extends JPanel{
	
	private JLabel etiquetaNombre;
	private JLabel etiquetaFecha;
	private JLabel etiquetaHora;
	private JLabel etiquetaPersonas;
	private JLabel etiquetaVerificado;

	private boolean realizado;
	private boolean verificado;
	private JLabel lblVerificacion;
	private JLabel lblRealizado;
	
	private int codigoUsuRest;
	private int codigoUsuClie;
	String usuario;
	String fecha;
	String hora;
	int personas;
	int codigoUsuario;
	private JLabel lblPersonas;
	private JLabel lblVerificado;
	private JLabel lblRealizado_1;
	private JLabel etiquetaRealizacion;
	
	/**
	 * @wbp.parser.constructor
	 */
	public InfoReserva(String usuario, String fecha, String hora, int pers, int codigoUs, boolean realizado, boolean verificado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuClie=codigoUs;
		
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
		
		this.etiquetaVerificado = new JLabel("");
		if(verificado){
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
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
		
		JLabel etiquetaRealizacion = new JLabel("");
		if(realizado){
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
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
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuRest=codigoRes;
		
		this.etiquetaNombre = new JLabel(nomrest);	
		etiquetaNombre.setBounds(12, 13, 79, 17);
		etiquetaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaNombre.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaNombre.setForeground(new Color(255,153,0));
		
		this.etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setBounds(92, 41, 82, 17);
		etiquetaFecha.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaFecha.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaFecha.setForeground(new Color(255,153,0));
		
		this.etiquetaHora = new JLabel(hora);
		etiquetaHora.setBounds(92, 69, 91, 17);
		etiquetaHora.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaHora.setForeground(new Color(255,153,0));
		
		this.etiquetaPersonas = new JLabel(String.valueOf(pers));
		etiquetaPersonas.setBounds(260, 59, 25, 17);
		etiquetaPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaPersonas.setForeground(new Color(255,153,0));
		
		this.etiquetaVerificado = new JLabel("");
		if(verificado){
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		
		etiquetaVerificado.setBounds(373, 27, 38, 34);
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(32, 41, 82, 17);
		lblDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDia.setForeground(new Color(255, 153, 0));
		lblDia.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(28, 69, 82, 17);
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(new Color(255, 153, 0));
		lblHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		setLayout(null);
		add(etiquetaNombre);
		add(lblHora);
		add(etiquetaHora);
		add(lblDia);
		add(etiquetaFecha);
		add(etiquetaPersonas);
		add(etiquetaVerificado);
		
		lblPersonas = new JLabel("Personas:");
		lblPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonas.setForeground(new Color(255, 153, 0));
		lblPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblPersonas.setBounds(181, 59, 82, 17);
		add(lblPersonas);
		
		lblVerificado = new JLabel("Verificado:");
		lblVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerificado.setForeground(new Color(255, 153, 0));
		lblVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblVerificado.setBounds(278, 41, 97, 17);
		add(lblVerificado);
		
		lblRealizado_1 = new JLabel("Realizado:");
		lblRealizado_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRealizado_1.setForeground(new Color(255, 153, 0));
		lblRealizado_1.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		lblRealizado_1.setBounds(278, 69, 104, 17);
		add(lblRealizado_1);
		
		etiquetaRealizacion = new JLabel("");
		if(realizado){
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		
		etiquetaRealizacion.setBounds(373, 59, 38, 40);
		add(etiquetaRealizacion);
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