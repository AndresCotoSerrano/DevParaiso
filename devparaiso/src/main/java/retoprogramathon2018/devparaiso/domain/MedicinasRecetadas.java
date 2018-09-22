package retoprogramathon2018.devparaiso.domain;

import java.util.Date;

public class MedicinasRecetadas {
	
	public Date fecha;
	public String duracion;
	
	
	public MedicinasRecetadas(Date fecha, String duracion) {
		super();
		this.fecha = fecha;
		this.duracion = duracion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	

}
