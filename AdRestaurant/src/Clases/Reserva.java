package Clases;

public class Reserva {
	
	String nombreRestaurante;
	String usuarioReserva;
	String fechaReserva;
	String hora;
	String fechaCreacion;
	int personas;
	Boolean verificacion;
	Boolean realizacion;
	
	//Reserva ya creada. Para consulta
	
	public Reserva(String nomRest, String user,String fechaCrea){
		nomRest=this.nombreRestaurante;
		user=this.usuarioReserva;
		fechaCrea=this.fechaCreacion;
		
		//consultar hora fechaReserva verificación realizacion
	}
	
	//Reserva no creada. Para creacion.
	
	public Reserva(String nomRest, String user, String fechaReserva, String hora, String fechaCrea, int personas){
		nomRest=this.nombreRestaurante;
		user=this.usuarioReserva;
		fechaReserva=this.fechaReserva;
		hora=this.hora;
		fechaCrea=this.fechaCreacion;
		personas=this.personas;
		this.verificacion=false;
		this.realizacion=false;
		
		//creacion de la consulta
	}
	
	//GETTERS
	
	public String getNomRest(){
		return this.nombreRestaurante;
	}
	public String getUsuario(){
		return this.usuarioReserva;
	}
	public String getFechaReserva(){
		return this.fechaReserva;
	}
	public String getHora(){
		return this.hora;
	}
	public String getFechaCrea(){
		return this.fechaCreacion;
	}
	public int getPersonas(){
		return this.personas;
	}
	public boolean getVerificacion(){
		return this.verificacion;
	}
	public boolean getRealizacion(){
		return this.realizacion;
	}
	
	//SETTERS CON ACTUALIZACION
	
	public void setNomRest(String nomRest){
		this.nombreRestaurante=nomRest;
		this.actualizacionReserva();
	}
	public void setUsuario(String user){
		this.usuarioReserva=user;
		this.actualizacionReserva();
	}
	public void setFechaReserva(String fechaReser){
		this.fechaReserva=fechaReser;
		this.actualizacionReserva();
	}
	public void setHora( String horaReser){
		this.hora=horaReser;
		this.actualizacionReserva();
	}
	public void setFechaCrea( String fechaCrea){
		this.fechaCreacion=fechaCrea;
		this.actualizacionReserva();
	}
	public void setPersonas(int personasReser){
		this.personas=personasReser;
		this.actualizacionReserva();
	}
	public void setVerificacion(boolean verif){
		this.verificacion=verif;
		this.actualizacionReserva();
	}
	public void setRealizacion(boolean realiza){
		this.realizacion=realiza;
		this.actualizacionReserva();
	}
	
	public void actualizacionReserva(){
		//Actualizacion de los datos de la consulta
	
	}
	
	
}
