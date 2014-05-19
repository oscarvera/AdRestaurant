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
	String contraseña;
	String telefono;
	String email;
	Statement stmt;
	Statement stmt2;
	Connection connexio;
	String consulta1;
	String consulta2;
	
	public Cliente(String nombre){
		this.nombre=nombre;
		conectar();
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String usuario, char[] contraseña, String telefono, String email){
		conectar();
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
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
		// Carreguem el Driver
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException cnfe){
					cnfe.printStackTrace();
				}
				
				//Obrim una connexio
				this.connexio=null;
				try {
					String user = "root";
					connexio = DriverManager.getConnection("jdbc:mysql://127.0.0.1/educa", user, "tonphp");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	public void prepararConsulta(){ 
		
		//Creem un Statement per poder fer consultes
		ResultSet resultatConsulta=null;
				
		//OPCIO 2: Amb un PreparedStatement
		PreparedStatement stmt2;
		//this.stmt = connexio.createStatement();
		
		// OPCIO2: Amb un PreparedStatement
		//this.stmt2 = connexio.prepareStatement();
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

