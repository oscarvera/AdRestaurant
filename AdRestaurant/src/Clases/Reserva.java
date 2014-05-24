package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reserva {
	
	int codReserva;
	Restaurante rest;
	Cliente usuarioReserva;
	String fechaReserva;
	String hora;
	String fechaCreacion;
	int personas;
	Boolean verificacion;
	Boolean realizacion;
	
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	
	//Reserva ya creada. Para consulta
	
	public Reserva(Restaurante nomRest, Cliente user,String fechaCrea){
		this.rest=nomRest;
		this.usuarioReserva=user;
		this.fechaCreacion=fechaCrea;
		
		this.conectar();
		this.prepararConsulta();
		this.recibirReserva();
		//consultar hora fechaReserva verificación realizacion
	}
	
	//Reserva no creada. Para creacion.
	
	public Reserva(Restaurante Rest, Cliente user, String fechaReserva, String hora, int personas){
		this.rest=Rest;
		this.usuarioReserva=user;
		this.fechaReserva=fechaReserva;
		this.hora=hora;
		this.personas=personas;
		this.verificacion=false;
		this.realizacion=false;
		
		//creacion de la consulta
		

		this.conectar();
		this.prepararConsulta();
		this.insertarReserva();
	}
	
	public void recibirReserva(){
		this.consulta = "SELECT * FROM reserva WHERE Codigo_Restaurante=? AND Codigo_Cliente=? AND fechaReserva=?;";
		try {
			this.stmt = conexion.prepareStatement(this.consulta);
			this.stmt.setInt(1, rest.getCodigoRestaurante());
			this.stmt.setInt(2, usuarioReserva.getCodigoCliente());
			this.stmt.setString(3, this.fechaCreacion);
			resultadoConsulta = stmt.executeQuery();					
			while(resultadoConsulta.next()==true){
				this.hora=String.valueOf(resultadoConsulta.getInt("hora"));
				this.fechaReserva=resultadoConsulta.getString("fechaReserva");
				this.personas=resultadoConsulta.getInt("personas");
				if(resultadoConsulta.getInt("verificacion")==1){
					this.verificacion=true;
				}else{
					this.verificacion=false;
				}
				if(resultadoConsulta.getInt("realizacion")==1){
					this.verificacion=true;
				}else{
					this.verificacion=false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void conectar(){
		//Cargamos el driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
				
		//Abrimos una conexión
		this.conexion=null;
		try {
			//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
			//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
			String user = "adrestaurant";
			this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143/adrestaurant", user, "adrestaurant");
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void prepararConsulta(){ 
		//Inicializamos la variable que contendrá el resultado
		this.resultadoConsulta=null;
	
		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
		this.stmt=null;
	}
	
	
	public void insertarReserva(){
		//Escribimos la consulta SQL en la variable consulta
		this.consulta = "INSERT INTO reserva (Codigo_Restaurante, Codigo_Cliente, fechaReserva, hora, fechaCreacion, personas, verificacion,realizacion)"
				+ " VALUES (?,?,?,?,CURRENT_TIMESTAMP,?,?,?);";
		try{
			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
			this.stmt = conexion.prepareStatement(this.consulta);
			
			//Asignamos los campos de la reserva a insertar con los campos a rellenar en las tablas (los "?").
			stmt.setInt(1, rest.getCodigoRestaurante());
			stmt.setInt(2, usuarioReserva.getCodigoCliente());
			stmt.setString(3, this.fechaReserva);
			stmt.setString(4, this.hora);
			
			stmt.setInt(5, this.personas);
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			
			
			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
			resultadoActualizacionBD = stmt.executeUpdate();
			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	//GETTERS
	
	public Restaurante getNomRest(){
		return this.rest;
	}
	public Cliente getUsuario(){
		return this.usuarioReserva;
	}
	public String getFechaReserva(){
		return this.fechaReserva;
	}
	public String getHora(){
		return this.hora;
	}
	public String getFechaCrea(){
		return this.fechaCreacion;
	}
	public int getPersonas(){
		return this.personas;
	}
	public boolean getVerificacion(){
		return this.verificacion;
	}
	public boolean getRealizacion(){
		return this.realizacion;
	}
	
	//SETTERS CON ACTUALIZACION
	
	public void setNomRest(Restaurante nomRest){
		this.rest=nomRest;
		this.actualizacionReserva();
	}
	public void setUsuario(Cliente user){
		this.usuarioReserva=user;
		this.actualizacionReserva();
	}
	public void setFechaReserva(String fechaReser){
		this.fechaReserva=fechaReser;
		this.actualizacionReserva();
	}
	public void setHora( String horaReser){
		this.hora=horaReser;
		this.actualizacionReserva();
	}
	public void setFechaCrea( String fechaCrea){
		this.fechaCreacion=fechaCrea;
		this.actualizacionReserva();
	}
	public void setPersonas(int personasReser){
		this.personas=personasReser;
		this.actualizacionReserva();
	}
	public void setVerificacion(boolean verif){
		this.verificacion=verif;
		this.actualizacionReserva();
	}
	public void setRealizacion(boolean realiza){
		this.realizacion=realiza;
		this.actualizacionReserva();
	}
	
	public void actualizacionReserva(){
		//Actualizacion de los datos de la consulta
	
	}
	
	
}
