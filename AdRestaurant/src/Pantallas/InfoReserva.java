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

import com.mysql.jdbc.Messages;

public class InfoReserva extends JPanel{
	
	private JLabel etiquetaNombre;
	private JLabel etiquetaFecha;
	private JLabel etiquetaHora;
	private JLabel etiquetaPersonas;
	private JLabel etiquetaVerificado;
	JLabel lblDia;
	JLabel lblHora;
	
	

	private boolean realizado;
	private boolean verificado;

	private JLabel lblRealizado;
	
	private int codigoUsuRest;
	private int codigoUsuClie;
	String usuario;
	String fecha;
	String hora;
	int personas;
	private JLabel lblPersonas;
	private JLabel lblVerificado;
	private JLabel etiquetaRealizacion;
	
	/**
	 * @wbp.parser.constructor
	 */
	public InfoReserva(String usuario, String fecha, String hora, int pers, int codigoUs, boolean realizado, boolean verificado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuClie=codigoUs;
		this.usuario=usuario;
		this.fecha=fecha;
		this.hora=hora;
		this.personas=pers;
		
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
		
		this.etiquetaVerificado = new JLabel("");
		if(verificado){
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		
		etiquetaRealizacion = new JLabel("");
		if(realizado){
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		etiquetaRealizacion.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaRealizacion.setForeground(new Color(255, 153, 0));
		etiquetaRealizacion.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblDia = new JLabel("Dia:");
		lblDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDia.setForeground(new Color(255, 153, 0));
		lblDia.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(new Color(255, 153, 0));
		lblHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblPersonas = new JLabel("Personas");
		lblPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonas.setForeground(new Color(255, 153, 0));
		lblPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblVerificado = new JLabel("Verificado:");
		lblVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerificado.setForeground(new Color(255, 153, 0));
		lblVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblRealizado = new JLabel("Realizado:");
		
		lblRealizado.setHorizontalAlignment(SwingConstants.LEFT);
		lblRealizado.setForeground(new Color(255, 153, 0));
		lblRealizado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(etiquetaPersonas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(211)
							.addComponent(lblVerificado, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(211)
							.addComponent(lblRealizado, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(lblPersonas, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(etiquetaVerificado, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(etiquetaRealizacion, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(etiquetaNombre, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(etiquetaNombre)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDia)
							.addGap(11)
							.addComponent(lblHora))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(etiquetaPersonas))
						.addComponent(etiquetaFecha)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(etiquetaHora))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblRealizado))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblPersonas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(etiquetaVerificado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblVerificado, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(etiquetaRealizacion, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		setLayout(groupLayout);
	}
	
	public InfoReserva(int codigoRes, String nomrest, String fecha, String hora, int pers, boolean realizado, boolean verificado){
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		
		this.codigoUsuRest=codigoRes;
		this.realizado=realizado;
		this.verificado=verificado;
		this.codigoUsuRest=codigoRes;
		this.usuario=nomrest;
		this.fecha=fecha;
		this.hora=hora;
		this.personas=pers;
		
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
		
		this.etiquetaVerificado = new JLabel("");
		if(verificado){
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaVerificado.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		etiquetaVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		etiquetaVerificado.setForeground(new Color(255,153,0));
		
		lblDia = new JLabel("Dia:");
		lblDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDia.setForeground(new Color(255, 153, 0));
		lblDia.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(new Color(255, 153, 0));
		lblHora.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblPersonas = new JLabel("Personas:");
		lblPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonas.setForeground(new Color(255, 153, 0));
		lblPersonas.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblVerificado = new JLabel("Verificado:");
		lblVerificado.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerificado.setForeground(new Color(255, 153, 0));
		lblVerificado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		lblRealizado = new JLabel("Realizado:");
		lblRealizado.setHorizontalAlignment(SwingConstants.LEFT);
		lblRealizado.setForeground(new Color(255, 153, 0));
		lblRealizado.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 16));
		
		etiquetaRealizacion = new JLabel("");
		if(realizado){
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_si.png")));
		}else{
			etiquetaRealizacion.setIcon(new ImageIcon(InfoReserva.class.getResource("/Imagen/Check_no.png")));
		}
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(64)
									.addComponent(etiquetaHora, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblRealizado, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblVerificado, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(etiquetaPersonas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(113)
									.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(113)
									.addComponent(etiquetaRealizacion, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(etiquetaFecha, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(lblPersonas, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(etiquetaNombre, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblRealizado))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblVerificado))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(etiquetaPersonas))
						.addComponent(etiquetaVerificado, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(etiquetaRealizacion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(etiquetaNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblDia)
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHora)
								.addComponent(etiquetaHora)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(etiquetaFecha))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblPersonas))))
		);
		setLayout(groupLayout);
	}
	
	public void fondoNaranja(){
		this.etiquetaNombre.setForeground(new Color(255, 153, 0));
		this.etiquetaFecha.setForeground(new Color(255, 153, 0));
		this.etiquetaHora.setForeground(new Color(255, 153, 0));
		this.etiquetaPersonas.setForeground(new Color(255, 153, 0));
		this.etiquetaVerificado.setForeground(new Color(255, 153, 0));
		this.etiquetaRealizacion.setForeground(new Color(255, 153, 0));
		this.lblDia.setForeground(new Color(255, 153, 0));
		this.lblHora.setForeground(new Color(255, 153, 0));
		this.lblPersonas.setForeground(new Color(255, 153, 0));
		this.lblVerificado.setForeground(new Color(255, 153, 0));
		this.lblRealizado.setForeground(new Color(255, 153, 0));
	}

	public void fondoBlanco() {
		this.etiquetaNombre.setForeground(new Color(255, 255, 255));
		this.etiquetaFecha.setForeground(new Color(255, 255, 255));
		this.etiquetaHora.setForeground(new Color(255, 255, 255));
		this.etiquetaPersonas.setForeground(new Color(255, 255, 255));
		this.etiquetaVerificado.setForeground(new Color(255, 255, 255));
		this.etiquetaVerificado.setForeground(new Color(255, 255, 255));
		this.lblDia.setForeground(new Color(255, 255, 255));
		this.lblHora.setForeground(new Color(255, 255, 255));
		this.lblPersonas.setForeground(new Color(255, 255, 255));
		this.lblVerificado.setForeground(new Color(255, 255, 255));
		this.lblRealizado.setForeground(new Color(255, 255, 255));
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
		return codigoUsuClie;
	}	
}