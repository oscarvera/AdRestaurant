package Clases;
import java.awt.image.BufferedImage;


public class Restaurante {
	
	int codigoRestaurante;
	String password;
	String nombre;
	String tipo;
	int telefono;
	String direccion;
	String poblacion;
	String provincia;
	String codigoPostal;
	boolean minusvalidoApto;
	BufferedImage foto1;
	BufferedImage foto2;
	
	//Constructor para el registro de un nuevo restaurante:
		public Restaurante(String password, String nombre, String tipo, int telefono, String direccion, 
				String poblacion, String provincia, String codigoPostal, boolean minusvalidoApto){
			 //BufferedImage foto1, BufferedImage foto2
			this.password=password;
			this.nombre=nombre;
			this.tipo=tipo;
			this.telefono=telefono;
			this.direccion=direccion;
			this.poblacion=poblacion;
			this.provincia=provincia;
			this.codigoPostal=codigoPostal;
			this.minusvalidoApto=minusvalidoApto;
			//foto1=this.foto1;
			//foto2=this.foto2;
		}
		
		//Constructor para consultar restaurantes:
			public Restaurante(String nombre, String tipo,  
					String poblacion){
			
				nombre=this.nombre;
				tipo=this.tipo;
				poblacion=this.poblacion;
				
			}
	
	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}
	
	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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
	
	
}
