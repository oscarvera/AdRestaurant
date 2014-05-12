package Clases;

public class Comentario {
	
	String nombreRestaurante;
	String usuarioComentario;
	String fechaReserva;
	String hora;
	String fechaCreacion;
	int personas;
	Boolean verificacion;
	Boolean realizacion;
	
	//Reserva ya creada. Para consulta
	
	public Comentario(String nomRest, String user,String fechaCrea){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
		fechaCrea=this.fechaCreacion;
		
		//consultar hora fechaReserva verificación realizacion
	}
	
	//Reserva no creada. Para creacion.
	
	public Comentario(String nomRest, String user, String fechaReserva, String hora, String fechaCrea, int personas){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
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
		return this.usuarioComentario;
	}
	public String getfechaReserva(){
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
		this.actualizacionComentario();
	}
	public void setUsuario(String user){
		this.usuarioComentario=user;
		this.actualizacionComentario();
	}
	public void setfechaReserva(String fechaReser){
		this.fechaReserva=fechaReser;
		this.actualizacionComentario();
	}
	public void setHora( String horaReser){
		this.hora=horaReser;
		this.actualizacionComentario();
	}
	public void setFechaCrea( String fechaCrea){
		this.fechaCreacion=fechaCrea;
		this.actualizacionComentario();
	}
	public void setPersonas(int personasReser){
		this.personas=personasReser;
		this.actualizacionComentario();
	}
	public void setVerificacion(boolean verif){
		this.verificacion=verif;
		this.actualizacionComentario();
	}
	public void setRealizacion(boolean realiza){
		this.realizacion=realiza;
		this.actualizacionComentario();
	}
	
	public void actualizacionComentario(){
		//Actualizacion de los datos de la consulta
	
	}
	
	
}
