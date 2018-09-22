package retoprogramathon2018.devparaiso.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MenorDeEdad {
	
		
	public String nombre;
	public String cedula;
	public int edad;
	public String genero;
	public Antecedentes antecedentes;
	public String etnia;
	public String parentesco;
	
	
	public MenorDeEdad(String nombre, String cedula, int edad, String genero, Antecedentes antecedentes, String etnia,
			String parentesco) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
		this.genero = genero;
		this.antecedentes = antecedentes;
		this.etnia = etnia;
		this.parentesco = parentesco;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Antecedentes getAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(Antecedentes antecedentes) {
		this.antecedentes = antecedentes;
	}


	public String getEtnia() {
		return etnia;
	}


	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}


	public String getParentesco() {
		return parentesco;
	}


	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
		

}
