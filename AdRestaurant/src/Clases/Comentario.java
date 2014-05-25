package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Consulta;

public class Comentario {
	
	Restaurante rest;
	Cliente user;
	String hora;
	String fechaCreacion;
	String txtComentario;
	
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private Consulta conexionConsulta;
	
	//Comentario ya creado, recepción de datos
	
	/*public Comentario(String rest, String user,String fechaCrea,String comentario){
		rest=this.rest;
		user=this.user;
		fechaCrea=this.fechaCreacion;
		comentario=this.txtComentario;
		
		//consultar hora fechaReserva verificación realizacion
	}*/
	
	//Reserva no creada. Para creacion.
	
	public Comentario(Restaurante rest, Cliente user, String comentari, Consulta c){
		this.rest=rest;
		this.user=user;
		this.txtComentario=comentari;
		
		//Creacion de la consulta 
		this.conexionConsulta=c;
		this.conexion=conexionConsulta.getConexion();
		this.insertarComentario();
	}	
	
	public void insertarComentario(){
		//Escribimos la consulta SQL en la variable consulta
		this.consulta = "INSERT INTO comentarios (Codigo_Restaurante, Codigo_Cliente, hora, fechaCreacion,txtComentario)"
				+ " VALUES (?,?,CURTIME(),CURDATE(),?);";
		try{
			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
			this.stmt = conexion.prepareStatement(this.consulta);
			
			//Asignamos los campos de la reserva a insertar con los campos a rellenar en las tablas (los "?").
			stmt.setInt(1, rest.getCodigoRestaurante());
			stmt.setInt(2, user.getCodigoCliente());
			stmt.setString(3, this.txtComentario);
			
			
			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
			resultadoActualizacionBD = stmt.executeUpdate();
			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//GETTERS
	
	public Restaurante getrest(){
		return this.rest;
	}
	public Cliente getUsuario(){
		return this.user;
	}
	public String getHora(){
		return this.hora;
	}
	public String getFechaCrea(){
		return this.fechaCreacion;
	}
	//SETTERS CON ACTUALIZACION
	
	public void setrest(Restaurante rest){
		this.rest=rest;
		this.actualizacionComentario();
	}
	public void setUsuario(Cliente user){
		this.user=user;
		this.actualizacionComentario();
	}
	public void setHora( String horaReser){
		this.hora=horaReser;
		this.actualizacionComentario();
	}
	public void setFechaCrea( String fechaCrea){
		this.fechaCreacion=fechaCrea;
		this.actualizacionComentario();
	}
	
	public void actualizacionComentario(){
		//Actualizacion de los datos de la consulta
	
	}

	public Consulta getConexionConsulta() {
		return conexionConsulta;
	}

	public void setConexionConsulta(Consulta conexionConsulta) {
		this.conexionConsulta = conexionConsulta;
	}
	
	
}
