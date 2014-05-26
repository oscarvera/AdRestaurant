package Clases;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Consulta;


public class Restaurante {
	
	private int codigoRestaurante;
	private String nombre;
	private String tipo;
	private String telefono;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codigoPostal;
	private boolean minusvalidoApto;
	//De momento las imagenes van con este tipo, hasta que no esté claro, todo lo de imagenes está comentado.
	private File foto1;
	private File foto2;
	private String nombreUsuario;
	private char[] contraseña;
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private Consulta conexionConsulta;
	
	//Constructor para el registro de un nuevo restaurante:
		public Restaurante(String nombreUsuario, char[] contraseña, String nombre, String tipo, String telf, String direccion, 
				String poblacion, String provincia, String codigoPostal, boolean minusvalidoApto, Consulta c){
			 //BufferedImage foto1, BufferedImage foto2
			this.nombreUsuario=nombreUsuario;
			this.contraseña=contraseña;
			this.nombre=nombre;
			this.tipo=tipo;
			this.telefono=telf;
			this.direccion=direccion;
			this.poblacion=poblacion;
			this.provincia=provincia;
			this.codigoPostal=codigoPostal;
			this.minusvalidoApto=minusvalidoApto;
			this.foto1=foto1;
			this.foto2=foto2;
			this.conexionConsulta=c;
			this.conexion=conexionConsulta.getConexion();
			insertarRestaurante();
		}
		
		//Constructor para consultar restaurantes:
		
			//Constructor desde lista
			public Restaurante(int codigo, Consulta c){
				this.codigoRestaurante=codigo;
				this.conexionConsulta=c;
				this.conexion=conexionConsulta.getConexion();
				loginRestaurante();
			}
			
			//Constructor desde ingreso
			public Restaurante(String nombreUsuario, Consulta c){
				this.nombreUsuario=nombreUsuario;
				this.conexionConsulta=c;
				this.conexion=conexionConsulta.getConexion();
				loginRestauranteIngreso();
			}

			
			/**
			 * Si la contraseña también es correcta, selecciona todos los datos del usuario y crea una instancia de Restaurante con ellos.
			 */
			public void loginRestaurante(){
				this.consulta = "SELECT * FROM restaurantes WHERE codigoRestaurante=?;";
				try {
					this.stmt = conexion.prepareStatement(this.consulta);
					this.stmt.setInt(1,this.codigoRestaurante);
					resultadoConsulta = stmt.executeQuery();					
					while(resultadoConsulta.next()==true){
						
						this.nombre=resultadoConsulta.getString("Nombre");
						this.direccion=resultadoConsulta.getString("direccion");
						this.poblacion=resultadoConsulta.getString("poblacion");
						this.provincia=resultadoConsulta.getString("provincia");
						this.codigoPostal=resultadoConsulta.getString("codigoPostal");
						this.telefono=resultadoConsulta.getString("telefono");
						this.tipo=resultadoConsulta.getString("tipo");			
						this.minusvalidoApto=resultadoConsulta.getBoolean("minusvalido_Apto");
						this.foto1=(File) resultadoConsulta.getBlob("foto1");
						this.foto2=(File) resultadoConsulta.getBlob("foto2");
						this.nombreUsuario=resultadoConsulta.getString("nombreUsuario");
						this.contraseña=resultadoConsulta.getString("contraseña").toCharArray();
					
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
			public void loginRestauranteIngreso(){
				this.consulta = "SELECT * FROM restaurantes WHERE nombreUsuario=?;";
				try {
					this.stmt = conexion.prepareStatement(this.consulta);
					this.stmt.setString(1, this.nombreUsuario);
					System.out.println(""+this.nombreUsuario);
					resultadoConsulta = stmt.executeQuery();					
					while(resultadoConsulta.next()==true){
						
						this.codigoRestaurante=resultadoConsulta.getInt("codigoRestaurante");
						this.nombre=resultadoConsulta.getString("Nombre");
						this.direccion=resultadoConsulta.getString("direccion");
						this.poblacion=resultadoConsulta.getString("poblacion");
						this.provincia=resultadoConsulta.getString("provincia");
						this.codigoPostal=resultadoConsulta.getString("codigoPostal");
						this.telefono=resultadoConsulta.getString("telefono");
						this.tipo=resultadoConsulta.getString("tipo");			
						this.minusvalidoApto=resultadoConsulta.getBoolean("minusvalido_Apto");
						this.foto1=(File) resultadoConsulta.getBlob("foto1");
						this.foto2=(File) resultadoConsulta.getBlob("foto2");
						this.nombreUsuario=resultadoConsulta.getString("nombreUsuario");
						this.contraseña=resultadoConsulta.getString("contraseña").toCharArray();
					
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
//			public void conectar(){
//				//Cargamos el driver
//				try{
//					Class.forName("com.mysql.jdbc.Driver");
//				}catch(ClassNotFoundException cnfe){
//					cnfe.printStackTrace();
//				}
//						
//				//Abrimos una conexión
//				this.conexion=null;
//				try {
//					//Ponemos la conexión en autoCommit, para que ejecute las sentencias automáticamente sin necesidad de usar commit.
//					//Si está desactivado, las sentencias no serán efectivas, sino que se quedarán en un punto de guardado intermedio.
//					String user = "adrestaurant";
//					this.conexion = DriverManager.getConnection("jdbc:mysql://84.126.12.143/adrestaurant", user, "adrestaurant");
//					conexion.setAutoCommit(true);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			public void prepararConsulta(){ 
//				//Inicializamos la variable que contendrá el resultado
//				this.resultadoConsulta=null;
//			
//				//Inicializamos el PreparedStatement para manejar la consulta (mejor que el Statement normal)
//				this.stmt=null;
//			}
			
			public void insertarRestaurante(){
				try{
				FileInputStream io1 = new FileInputStream(foto1);
				FileInputStream io2 = new FileInputStream(foto2);
				//Escribimos la consulta SQL en la variable consulta -->De momento, las fotos se quedan fuera:
				this.consulta = "INSERT INTO restaurantes (Nombre,direccion,poblacion,provincia,codigoPostal,Telefono,tipo,Minusvalido_Apto,foto1,foto2,nombreUsuario,contraseña)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";  
					try{
					//Asignamos la consulta a nuestro PreparedStatement. De esta forma precompila la consulta antes de conectar incluso.
					this.stmt = conexion.prepareStatement(this.consulta);
					
					//Asignamos los campos del cliente a insertar con los campos a rellenar en las tablas (los "?").
					stmt.setString(1, this.nombre);
					stmt.setString(2, this.direccion);
					stmt.setString(3, this.poblacion);
					stmt.setString(4, this.provincia);
					stmt.setInt(5, Integer.valueOf(this.codigoPostal));
					stmt.setInt(6, Integer.valueOf(this.telefono));
					stmt.setString(7, this.tipo);
					stmt.setBoolean(8, this.minusvalidoApto);
					stmt.setBinaryStream(9, (InputStream)io1, (int)foto1.length());
					stmt.setBinaryStream(10, (InputStream)io2, (int)foto2.length());
					stmt.setString(11, this.nombreUsuario);
					//En contraseña hay que pasarlo a String y borrar el contenido de la variable de clase por seguridad.
					stmt.setString(12, String.copyValueOf(this.contraseña));
					for(int i=0; i<contraseña.length; i++){
						this.contraseña[i]=0;
					}
	;
					
					//Ejecutamos la consulta y la guardamos en un entero (ya que es de actualización y nos dirá las columnas afectadas).
					resultadoActualizacionBD = stmt.executeUpdate();
					System.out.println("Se han actualizado "+resultadoActualizacionBD+" registros.");
					
					}catch(SQLException e){
					e.printStackTrace();
					}
				
				}catch(Exception ex) {
				System.out.println(ex.getMessage());
				}
				
			}
			
			/**
			 * GETTERS Y SETTERS
			 * @return
			 */
			public int getCodigoRestaurante() {
				return codigoRestaurante;
			}

			public void setCodigoRestaurante(int codigoRestaurante) {
				this.codigoRestaurante = codigoRestaurante;
			}

			public char[] getContraseña() {
				return contraseña;
			}

			public void setContraseña(char[] contraseña) {
				this.contraseña = contraseña;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getTipo() {
				return tipo;
			}

			public void setTipo(String tipo) {
				this.tipo = tipo;
			}

			public String getTelefono() {
				return telefono;
			}

			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}

			public String getDireccion() {
				return direccion;
			}

			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			public String getPoblacion() {
				return poblacion;
			}

			public void setPoblacion(String poblacion) {
				this.poblacion = poblacion;
			}

			public String getProvincia() {
				return provincia;
			}

			public void setProvincia(String provincia) {
				this.provincia = provincia;
			}

			public String getCodigoPostal() {
				return codigoPostal;
			}

			public void setCodigoPostal(String codigoPostal) {
				this.codigoPostal = codigoPostal;
			}

			public boolean getMinusvalidoApto() {
				return minusvalidoApto;
			}

			public void setMinusvalidoApto(boolean minusvalidoApto) {
				this.minusvalidoApto = minusvalidoApto;
			}

			public File getFoto1() {
				return foto1;
			}

			public void setFoto1(File foto1) {
				this.foto1 = foto1;
			}

			public File getFoto2() {
				return foto2;
			}

			public void setFoto2(File foto2) {
				this.foto2 = foto2;
			}
			
			public String getNombreUsuario() {
				return nombreUsuario;
			}

			public void setNombreUsuario(String nombreUsuario) {
				this.nombreUsuario = nombreUsuario;
			}

			public Consulta getConexionConsulta() {
				return conexionConsulta;
			}

			public void setConexionConsulta(Consulta conexionConsulta) {
				this.conexionConsulta = conexionConsulta;
			}
			

			
			
}
			
			
	
	