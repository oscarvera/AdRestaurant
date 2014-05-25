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
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	int resultadoActualizacionBD;
	private ErrorRegistro err;
	boolean esRest;

	public Consulta(ResourceBundle messages){
		this.messages=messages;
		conectar();
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
		
		//Inicializamos la variable que contendr� el resultado
			this.resultadoConsulta=null;

		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
			this.stmt=null;
	}
	
	/**
	 * Cierra la conexi�n
	 */
	public void cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Envia si es un restaurante o no.
	 * @return
	 */
	public boolean esRestaurante(){
		return esRest;
	}
	

	public boolean loginCliente(String user, char[] contrase�a){
		//Primero se comprueba el usuario.
		
		try{
			/*consulta si es un usuario*/
			this.consulta = "SELECT usuario FROM Clientes WHERE usuario=?";
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
				if(resultadoConsulta.next()){/*El usuario existe pero la contrase�a no es correcta*/
					err=new ErrorRegistro("La contrase�a es incorrecta",this.messages);
					return true;
				}
			}else{/*Buscarmos el usuario en restaurante, ya que en cliente no existe*/
					
					this.consulta = "SELECT nombreUsuario FROM Restaurantes WHERE nombreUsuario=? AND contrase�a=?";
					this.stmt = conexion.prepareStatement(this.consulta);
					this.stmt.setString(2, String.copyValueOf(contrase�a));
					this.stmt.setString(1, user);
					resultadoConsulta = stmt.executeQuery();
					
					if(resultadoConsulta.next()){/*Entra si existe y la contrase�a es correcta*/
						esRest=true;
						return true;
					}else{
						err=new ErrorRegistro("El usuario o contrase�a incorrecto",this.messages);
						err.setVisible(true);
						return false;
					}		
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Hola");
			return false;			
		}
		return false;

		
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
	
	public Consulta getconsulta(){
		return this;
	}
}
