package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Antecedentes")
public class Antecedentes {

	public Tratamiento tratamiento;
	public Enfermedad enfermedades;
	
	
	public Antecedentes(Tratamiento tratamiento, Enfermedad enfermedades) {
		super();
		this.tratamiento = tratamiento;
		this.enfermedades = enfermedades;
	}


	public Tratamiento getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}


	public Enfermedad getEnfermedades() {
		return enfermedades;
	}


	public void setEnfermedades(Enfermedad enfermedades) {
		this.enfermedades = enfermedades;
	}
	
	
	
}
