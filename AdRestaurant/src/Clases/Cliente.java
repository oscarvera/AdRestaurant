package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
	String nombre;
	String primerApellido;
	String segundoApellido;
	int codigoCliente;
	String usuario;
	char[] contraseña;
	String telefono;
	String email;
	PreparedStatement stmt;
	Connection conexion;
	String consulta;
	ResultSet resultadoConsulta;
	int resultadoActualizacionBD;
	
	public Cliente(String nombre){
		this.nombre=nombre;
		conectar();
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String usuario, char[] contraseña, String telefono, String email){
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido;
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.telefono=telefono;
		this.email=email;
		conectar();
		prepararConsulta();
		insertarCliente();
	}
	
	public Cliente(String usuario, String contraseña){
		conectar();
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
			String user = "root";
			this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/addrestaurant", user, "serphp");
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
	
	public void insertarCliente(){
		//Escribimos la consulta SQL en la variable consulta
		this.consulta = "INSERT INTO Clientes (Nombre, primerApellido, segundoApellido, usuario, email, telefono)"
				+ " VALUES (?,?,?,?,?,?);";
		try{
			//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
			this.stmt = conexion.prepareStatement(this.consulta);
			//Asignamos los campos del cliente a insertar con los campos a rellenar en las tablas (los "?").
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.primerApellido);
			stmt.setString(3, this.segundoApellido);
			stmt.setString(4, this.usuario);
			stmt.setString(5, this.email);
			stmt.setString(6, this.telefono);
			//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
			//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
			conexion.setAutoCommit(true);
			//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
			resultadoActualizacionBD = stmt.executeUpdate();
			System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
				
//				try {
//					
//					int souMinim=1000;
//					 this.consulta1 = "UPDATE PERSONAL set esueldo=25002 where dept='PHIL'";
//					 this.consulta2 = "SELECT enombre,esueldo FROM PERSONAL where esueldo>=?";
//					
//					stmt = connexio.createStatement();
//					// OPCIO2: Amb un PreparedStatement
//					   stmt2 = connexio.prepareStatement(consulta2);
//					   stmt2.setInt(1, souMinim);
//					
//					   //OPCIO2: Executem la consulta
//					   ResultSet r=stmt2.executeQuery();
//					   if(r!=null){
//						   System.out.println("AMB UN PREPARED STATEMENT");
//							while(r.next()){
//								//System.out.println(resultatConsulta.getString(1));
//								System.out.print(r.getString(1));
//								System.out.println("\t"+r.getString(2));
//								//System.out.println("\t"+resultatConsulta.getString("cargo"));
//							}
//						} 
//				}				   			   
//					//Executem la consulta
//					connexio.setAutoCommit(false);
//					int regModif=stmt.executeUpdate(consulta1);
//					System.out.println("S'han actualitzat "+regModif+" registres.");
//					//connexio.commit();
//					connexio.rollback();
//					//A partir d'ací obtindré els resultats de la consulta
//					/*if(resultatConsulta!=null){
//						System.out.println("AMB UN STATEMENT");
//						while(resultatConsulta.next()){
//							//System.out.println(resultatConsulta.getString(1));
//							System.out.print(resultatConsulta.getString("Enombre"));
//							System.out.println("\t"+resultatConsulta.getString("Esueldo"));
//							//System.out.println("\t"+resultatConsulta.getString("cargo"));
//						}
//					}
//					*/
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				// Tanquem la connexió
//				
//			}

	}

