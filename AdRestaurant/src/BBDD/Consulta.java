package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Pantallas.ErrorRegistro;

public class Consulta {

	private ResourceBundle messages;
	private PreparedStatement stmt;
	static Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	int resultadoActualizacionBD;
	private ErrorRegistro err;

	public Consulta(ResourceBundle messages){
		this.messages=messages;
		conectar();
		prepararConsulta();
	}	

	/**
	 * Conecta con el driver JDBC.
	 */
	public void conectar(){
		//Cargamos el driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}

		//Abrimos una conexi�n
		this.conexion=null;
		try {
			String user = "adrestaurant";
			this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143:3306/adrestaurant", user, "adrestaurant");

			//Ponemos la conexi�n en autoCommit, para que ejecute las sentencias autom�ticamente sin necesidad de usar commit.
			//Si est� desactivado, las sentencias no ser�n efectivas, sino que se quedar�n en un punto de guardado intermedio.
			this.conexion.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Inicializa las variables necesarias para una nueva consulta.
	 */
	public void prepararConsulta(){ 
		//Inicializamos la variable que contendr� el resultado
		this.resultadoConsulta=null;

		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
		this.stmt=null;
	}

//	/**
//	 * A�ade un cliente a la base de datos. Recibe los par�metros de una instancia/objeto Cliente.
//	 */
//	public void insertarCliente(String nombre, String primerApellido, String segundoApellido, String usuario, String email, String telefono, char[] contrase�a){
//		//Escribimos la consulta SQL en la variable consulta
//		this.consulta = "INSERT INTO Clientes (Nombre, primerApellido, segundoApellido, usuario, email, telefono, contrase�a)"
//				+ " VALUES (?,?,?,?,?,?,?);";
//		try{
//			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
//			this.stmt = conexion.prepareStatement(this.consulta);
//
//			//Asignamos los campos del cliente a insertar con los campos a rellenar en las tablas (los "?").
//			stmt.setString(1, nombre);
//			stmt.setString(2, primerApellido);
//			stmt.setString(3, segundoApellido);
//			stmt.setString(4, usuario);
//			stmt.setString(5, email);
//			stmt.setInt(6, Integer.valueOf(telefono));
//			stmt.setString(7, String.copyValueOf(contrase�a));			
//
//			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualizaci�n y nos dir� las columnas afectadas).
//			resultadoActualizacionBD = stmt.executeUpdate();
//			//Comprobar que se ha actualizado alg�n registro con un mensaje.
//			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
//
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}


	public boolean loginCliente(String user, char[] contrase�a){
		//Primero se comprueba el usuario.
		this.consulta = "SELECT usuario FROM Clientes WHERE usuario=?";
		try{
			this.stmt = conexion.prepareStatement(this.consulta);
			this.stmt.setString(1, user);
			resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()){
				//Cuando el usuario es correcto comprobamos la contrase�a.
				this.consulta = "SELECT contrase�a FROM Clientes WHERE contrase�a=? AND usuario=?";
				this.stmt = conexion.prepareStatement(this.consulta);
				this.stmt.setString(1, String.copyValueOf(contrase�a));
				this.stmt.setString(2, user);
				resultadoConsulta = stmt.executeQuery();
				if(resultadoConsulta.next()){
					return true;
				}else{
					err=new ErrorRegistro("La contrase�a es incorrecta",this.messages);
					return false;
				}
			}
			else {
				err=new ErrorRegistro("El usuario no existe",this.messages);
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Hola");
			return false;
			
			
		}

		
		//		//Comprobamos la contrase�a.
		//		this.consulta = "SELECT contrase�a FROM Cientes";
		//		try{
		//			this.stmt = conexion.prepareStatement(this.consulta);
		//			resultadoConsulta = stmt.executeQuery();
		//		}catch(SQLException e){
		//			e.printStackTrace();
		//			new ErrorRegistro("El usuario no existe");
		//		}
	}
	public ErrorRegistro error(){
		return err;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
