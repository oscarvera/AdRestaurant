package Clases;

public class Comentario {
	
	String nombreRestaurante;
	String usuarioComentario;
	String hora;
	String fechaCreacion;
	String textComentario;
	
	//Comentario ya creado, recepción de datos
	
	public Comentario(String nomRest, String user,String fechaCrea,String comentario){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
		fechaCrea=this.fechaCreacion;
		comentario=this.textComentario;
		
		//consultar hora fechaReserva verificación realizacion
	}
	
	//Reserva no creada. Para creacion.
	
	public Comentario(String nomRest, String user, String fechaReserva, String hora, String fechaCrea, int personas){
		nomRest=this.nombreRestaurante;
		user=this.usuarioComentario;
		hora=this.hora;
		fechaCrea=this.fechaCreacion;
		
		//Creacion de la consulta 
	}
	
	//GETTERS
	
	public String getNomRest(){
		return this.nombreRestaurante;
	}
	public String getUsuario(){
		return this.usuarioComentario;
	}
	public String getHora(){
		return this.hora;
	}
	public String getFechaCrea(){
		return this.fechaCreacion;
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
	public void setHora( String horaReser){
		this.hora=horaReser;
		this.actualizacionComentario();
	}
	public void setFechaCrea( String fechaCrea){
		this.fechaCreacion=fechaCrea;
		this.actualizacionComentario();
	}
	
	public void actualizacionComentario(){
		//Actualizacion de los datos de la consulta
	
	}
	
	
}
