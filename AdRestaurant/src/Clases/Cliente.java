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
	private char[] contrase�a;
	private String telefono;
	private String email;
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private Consulta conexionConsulta;
	
	public Cliente(String usua, Consulta c){
		this.usuario=usua;
		this.conexionConsulta=c;
		this.conexion=conexionConsulta.getConexion();
		loginCliente();
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String usuario, char[] contrase�a, String telefono, String email, Consulta c){
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido;
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.telefono=telefono;
		this.email=email;
		this.conexionConsulta=c;
		this.conexion=conexionConsulta.getConexion();
		insertarCliente();
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

	public char[] getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(char[] contrase�a) {
		this.contrase�a = contrase�a;
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
	
	public String getUsuario(){
		return this.usuario;
	}
	/**
	 * Si la contrase�a tambi�n es correcta, selecciona todos los datos del usuario y crea una instancia de Cliente con ellos.
	 */
	public void loginCliente(){
		this.consulta = "SELECT * FROM Clientes WHERE usuario=?;";
		try {
			this.stmt = this.conexion.prepareStatement(this.consulta);
			this.stmt.setString(1, this.usuario);
			resultadoConsulta = stmt.executeQuery();					
			while(resultadoConsulta.next()==true){
				this.nombre=resultadoConsulta.getString("nombre");
				this.primerApellido=resultadoConsulta.getString("primerApellido");
				this.segundoApellido=resultadoConsulta.getString("segundoApellido");
				this.telefono=resultadoConsulta.getString("telefono");
				this.email=resultadoConsulta.getString("email");
				this.usuario=resultadoConsulta.getString("usuario");
				this.codigoCliente=resultadoConsulta.getInt("codigoCliente");
				this.contrase�a=resultadoConsulta.getString("pass").toCharArray();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	public void conectar(){
//		//Cargamos el driver
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//		}catch(ClassNotFoundException cnfe){
//			cnfe.printStackTrace();
//		}
//				
//		//Abrimos una conexi�n
//		this.conexion=null;
//		try {
//			//Ponemos la conexi�n en autoCommit, para que ejecute las sentencias autom�ticamente sin necesidad de usar commit.
//			//Si est� desactivado, las sentencias no ser�n efectivas, sino que se quedar�n en un punto de guardado intermedio.
//			String user = "adrestaurant";
//			this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143:3306/adrestaurant", user, "adrestaurant");
//			this.conexion.setAutoCommit(true);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void prepararConsulta(){ 
//		//Inicializamos la variable que contendr� el resultado
//		this.resultadoConsulta=null;
//	
//		//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
//		this.stmt=null;
//	}
	
	public void insertarCliente(){
		//Escribimos la consulta SQL en la variable consulta
		this.consulta = "INSERT INTO Clientes (Nombre, primerApellido, segundoApellido, usuario, email, telefono, pass)"
				+ " VALUES (?,?,?,?,?,?,?);";
		try{
			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
			this.stmt = conexion.prepareStatement(this.consulta);
			
			//Asignamos los campos del cliente a insertar con los campos a rellenar en las tablas (los "?").
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.primerApellido);
			stmt.setString(3, this.segundoApellido);
			stmt.setString(4, this.usuario);
			stmt.setString(5, this.email);
			stmt.setInt(6, Integer.valueOf(this.telefono));
			//En contrase�a hay que pasarlo a String y borrar el contenido de la variable de clase por seguridad.
			stmt.setString(7, String.copyValueOf(this.contrase�a));
			for(int i=0; i<contrase�a.length; i++){
				this.contrase�a[i]=0;
			}
			
			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualizaci�n y nos dir� las columnas afectadas).
			resultadoActualizacionBD = stmt.executeUpdate();
			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void actualizar(){
		loginCliente();
	}

	public Consulta getConexionConsulta() {
		return conexionConsulta;
	}

	public void setConexionConsulta(Consulta conexionConsulta) {
		this.conexionConsulta = conexionConsulta;
	}
}

