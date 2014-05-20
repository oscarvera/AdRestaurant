package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Consulta;

public class Cliente {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private int codigoCliente;
	private String usuario;
	private char[] contraseña;
	private String telefono;
	private String email;
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private Consulta cons;
	
	public Cliente(String nombre){
		this.nombre=nombre;
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String usuario, char[] contraseña, String telefono, String email){
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido;
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.telefono=telefono;
		this.email=email;
		this.cons = new Consulta();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public char[] getContraseña() {
		return contraseña;
	}

	public void setContraseña(char[] contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	/**
	 * Inserta un nuevo cliente en la BD a traves de Consulta.
	 */
	public void insertarCliente(){
		Consulta c = new Consulta();
		c.insertarCliente(nombre, primerApellido, segundoApellido, usuario, email, telefono, contraseña);
	}
	
//	public void conectar(){
//		//Cargamos el driver
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//		}catch(ClassNotFoundException cnfe){
//			cnfe.printStackTrace();
//		}
//				
//		//Abrimos una conexión
//		this.conexion=null;
//		try {
//			String user = "root";
//			this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/addrestaurant", user, "serphp");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void prepararConsulta(){ 
//		//Inicializamos la variable que contendrá el resultado
//		this.resultadoConsulta=null;
//	
//		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
//		this.stmt=null;
//	}
//	

	
//	public void insertarCliente(){
//		//Escribimos la consulta SQL en la variable consulta
//		this.consulta = "INSERT INTO Clientes (Nombre, primerApellido, segundoApellido, usuario, email, telefono, contraseña)"
//				+ " VALUES (?,?,?,?,?,?,?);";
//		try{
//			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
//			this.stmt = conexion.prepareStatement(this.consulta);
//			
//			//Asignamos los campos del cliente a insertar con los campos a rellenar en las tablas (los "?").
//			stmt.setString(1, this.nombre);
//			stmt.setString(2, this.primerApellido);
//			stmt.setString(3, this.segundoApellido);
//			stmt.setString(4, this.usuario);
//			stmt.setString(5, this.email);
//			stmt.setInt(6, Integer.valueOf(this.telefono));
//			//En contraseña hay que pasarlo a String y borrar el contenido de la variable de clase por seguridad.
//			stmt.setString(7, String.copyValueOf(this.contraseña));
//			for(int i=0; i<contraseña.length; i++){
//				this.contraseña[i]=0;
//			}
//			
//			//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
//			//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
//			conexion.setAutoCommit(true);
//			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
//			resultadoActualizacionBD = stmt.executeUpdate();
//			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
}

