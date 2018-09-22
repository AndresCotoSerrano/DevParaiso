package retoprogramathon2018.devparaiso.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;


@Repository
@Table(name = "MenorDeEdad")
public class MenorDeEdad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int idMenor;
	private String nombre;
	private String cedula;
	private int edad;
	private String genero;
	private Antecedentes antecedentes;
	private String etnia;
	private String parentesco;
	
	
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
