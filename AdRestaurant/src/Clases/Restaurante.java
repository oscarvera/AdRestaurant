package Clases;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

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
	private BufferedImage foto1;
	private BufferedImage foto2;
	private File fotofile1;
	private File fotofile2;
	private String nombreUsuario;
	private char[] contraseña;
	private PreparedStatement stmt;
	private Connection conexion;
	private String consulta;
	private ResultSet resultadoConsulta;
	private int resultadoActualizacionBD;
	private Consulta conexionConsulta;
	
	FileInputStream io2 = null;
	
	//Constructor para el registro de restaurantes en la Base de Datos:
		public Restaurante(String nombreUsuario, char[] contraseña, String nombre, String tipo, String telf, String direccion, 
				String poblacion, String provincia, String codigoPostal, boolean minusvalidoApto, BufferedImage foto1, BufferedImage foto2, Consulta c){
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
			this.conexion=this.conexionConsulta.getConexion();
			insertarRestaurante();
		}
		
		//Constructor para el registro de un restaurante nuevo:
				public Restaurante(String nombreUsuario, char[] contraseña, String nombre, String tipo, String telf, String direccion, 
						String poblacion, String provincia, String codigoPostal, boolean minusvalidoApto, File fotofile1, File fotofile2, Consulta c){
					System.out.println("Estoy aqui");
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
					this.fotofile1=fotofile1;
					this.fotofile2=fotofile2;
					this.conexionConsulta=c;
					this.conexion=this.conexionConsulta.getConexion();
					if(this.fotofile1==null){
						System.out.println("esta nula la imagen");
					}
					insertarRestaurante();
				}
		
		//Constructor para consultar restaurantes:
		
			//Constructor desde lista
			public Restaurante(int codigo, Consulta c){
				this.codigoRestaurante=codigo;
				this.conexionConsulta=c;
				this.conexion=this.conexionConsulta.getConexion();
				loginRestaurante();
			}
			
			//Constructor desde ingreso
			public Restaurante(String nombreUsuario, Consulta c){
				this.nombreUsuario=nombreUsuario;
				this.conexionConsulta=c;
				this.conexion=this.conexionConsulta.getConexion();
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
						//sacamos las imagenes de la base de datos
						//foto1
						Blob blob1 = resultadoConsulta.getBlob("foto1"); //Guardo el Blob de la BD en una variable Blob
						byte[] data1 = blob1.getBytes(1, (int) blob1.length()); //lo trasformo en una variable de bytes
						BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(data1)); //Creo la imagen a partir del array 
						this.foto1= img1; //guardo la imagen
						//foto2
						
						Blob blob2 = resultadoConsulta.getBlob("foto2"); //Guardo el Blob de la BD en una variable Blob
						if(blob2!=null){
						byte[] data2 = blob2.getBytes(1, (int) blob2.length()); //lo trasformo en una variable de bytes
						BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(data2)); //Creo la imagen a partir del array 
						this.foto2= img2; //guardo la imagen*/
						}
						this.nombreUsuario=resultadoConsulta.getString("nombreUsuario");
						this.contraseña=resultadoConsulta.getString("contraseña").toCharArray();
					
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
						//sacamos las imagenes de la base de datos
						//foto1
						Blob blob1 = resultadoConsulta.getBlob("foto1"); //Guardo el Blob de la BD en una variable Blob
						byte[] data1 = blob1.getBytes(1, (int) blob1.length()); //lo trasformo en una variable de bytes
						BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(data1));//Creo la imagen a partir del array 
						this.foto1= img1; //guardo la imagen
						//foto2
						Blob blob2 = resultadoConsulta.getBlob("foto2");//Guardo el Blob de la BD en una variable Blob
						byte[] data2 = blob2.getBytes(1, (int) blob2.length());//lo trasformo en una variable de bytes
						BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(data2));//Creo la imagen a partir del array 
						this.foto2= img2; //guardo la imagen
						this.nombreUsuario=resultadoConsulta.getString("nombreUsuario");
						this.contraseña=resultadoConsulta.getString("contraseña").toCharArray();
					
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
				FileInputStream io1 = null;
				try {
					
					io1 = new FileInputStream(fotofile1);
					if(fotofile2!=null){
					io2 = new FileInputStream(fotofile2);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Esto esta mal");
				}
				
				try{
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
					stmt.setBinaryStream(9, (InputStream)io1, (int)fotofile1.length());
					if(fotofile2!=null){
						stmt.setBinaryStream(10, (InputStream)io2, (int)fotofile2.length());
					}else{
						stmt.setBinaryStream(10, (InputStream)io1, (int)fotofile1.length());
					}
					stmt.setString(11, this.nombreUsuario);
					//En contraseña hay que pasarlo a String y borrar el contenido de la variable de clase por seguridad.
					stmt.setString(12, String.copyValueOf(this.contraseña));
					for(int i=0; i<contraseña.length; i++){
						this.contraseña[i]=0;
					}

					
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

			public BufferedImage getFoto1() {
				return foto1;
			}

			public void setFoto1(BufferedImage foto1) {
				this.foto1 = foto1;
			}

			public BufferedImage getFoto2() {
				return foto2;
			}

			public void setFoto2(BufferedImage foto2) {
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

			public File getFotofile1() {
				return fotofile1;
			}

			public void setFotofile1(File fotofile1) {
				this.fotofile1 = fotofile1;
			}

			public File getFotofile2() {
				return fotofile2;
			}

			public void setFotofile2(File fotofile2) {
				this.fotofile2 = fotofile2;
			}			
			
}
			
			
	
	
