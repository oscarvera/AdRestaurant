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

		//Abrimos una conexión
		this.conexion=null;
		try {
			String user = "adrestaurant";
			this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143:3306/adrestaurant", user, "adrestaurant");
			//this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/adrestaurant", "root", "tonphp");
			//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
			//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
			this.conexion.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Inicializamos la variable que contendrá el resultado
			this.resultadoConsulta=null;

		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
			this.stmt=null;
	}
	
	/**
	 * Cierra la conexión
	 */
	public void cerrarConexion(){
		try {
			this.conexion.close();
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
	
	/**
	 * Devuelve true si el usuario y la contraseña existen en la BD para el ingreso.
	 * Primero comprueba el usuario y la contraseña de la tabla cliente y luego en la de restaurantes
	 * @param user
	 * @param contraseña
	 * @return
	 */
	public boolean loginCliente(String user, char[] contraseña){
		//Primero se comprueba el usuario.
		
		try{
			/*consulta si es un usuario*/
			this.consulta = "SELECT usuario FROM Clientes WHERE usuario=? AND contraseña=?";
			this.stmt = conexion.prepareStatement(this.consulta);
			this.stmt.setString(1, user);
			this.stmt.setString(2, String.copyValueOf(contraseña));
			resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()){
				/*//Cuando el usuario es correcto comprobamos la contraseña.
				this.consulta = "SELECT usuario FROM Clientes WHERE  usuario=?";
				this.stmt = conexion.prepareStatement(this.consulta);
				//this.stmt.setString(1, String.copyValueOf(contraseña));
				this.stmt.setString(1, user);
				resultadoConsulta = stmt.executeQuery();
				if(resultadoConsulta.next()){/*El usuario existe pero la contraseña no es correcta*/
					return true;
				/*}else{
					err=new ErrorRegistro("El usuario es incorrecto",this.messages);
				}*/
			}else{/*Buscarmos el usuario en restaurante, ya que en cliente no existe*/
					
					this.consulta = "SELECT nombreUsuario FROM Restaurantes WHERE nombreUsuario=? AND contraseña=?";
					this.stmt = conexion.prepareStatement(this.consulta);
					this.stmt.setString(2, String.copyValueOf(contraseña));
					this.stmt.setString(1, user);
					resultadoConsulta = stmt.executeQuery();
					
					if(resultadoConsulta.next()){/*Entra si existe y la contraseña es correcta*/
						esRest=true;
						return true;
					}else{
						err=new ErrorRegistro("El usuario o contraseña incorrecto",this.messages);
						err.setVisible(true);
						return false;
					}		
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Hola");
			return false;			
		}

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
