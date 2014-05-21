package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comentario {
	
	String nombreRestaurante;
	String usuarioComentario;
	String hora;
	String fechaCreacion;
	String textComentario;
	
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	
	//Comentario ya creado, recepción de datos
	
	public Comentario(String nomRest, String user,String fechaCrea,String comentario){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
		fechaCrea=this.fechaCreacion;
		comentario=this.textComentario;
		
		//consultar hora fechaReserva verificación realizacion
	}
	
	//Reserva no creada. Para creacion.
	
	public Comentario(String nomRest, String user, String fechaReserva, String hora, String fechaCrea, int personas){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
		hora=this.hora;
		fechaCrea=this.fechaCreacion;
		
		//Creacion de la consulta 
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
			String user = "root";
			this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/addrestaurant", user, "baloncesto");
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
				+ " VALUES (?,?,?,?,?,?,?,?);";
		try{
			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
			this.stmt = conexion.prepareStatement(this.consulta);
			
			//Asignamos los campos de la reserva a insertar con los campos a rellenar en las tablas (los "?").
			stmt.setInt(1, rest.getCodigoRestaurante());
			stmt.setInt(2, usuarioReserva.getCodigoCliente());
			stmt.setString(3, this.fechaReserva);
			stmt.setString(4, this.hora);
			stmt.setString(5, this.fechaCreacion);
			stmt.setInt(6, this.personas);
			stmt.setInt(7, 0);
			stmt.setInt(8, 0);
			
			
			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
			resultadoActualizacionBD = stmt.executeUpdate();
			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//GETTERS
	
	public String getNomRest(){
		return this.nombreRestaurante;
	}
	public String getUsuario(){
		return this.usuarioComentario;
	}
	public String getHora(){
		return this.hora;
	}
	public String getFechaCrea(){
		return this.fechaCreacion;
	}
	//SETTERS CON ACTUALIZACION
	
	public void setNomRest(String nomRest){
		this.nombreRestaurante=nomRest;
		this.actualizacionComentario();
	}
	public void setUsuario(String user){
		this.usuarioComentario=user;
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
	
	
}
