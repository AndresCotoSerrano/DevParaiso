package retoprogramathon2018.devparaiso.domain;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Table(name = "Medicines")
public class Medicines {
	
	private int idMedicines;
	private String name;
	private Date date;
	private String duration;
	
	
	public Medicines(Date date, String duration,String name, int idMedicines) {
		this.name = name;
		this.date = date;
		this.duration = duration;
		this.idMedicines=idMedicines;
	}


	public int getIdMedicines() {
		return idMedicines;
	}


	public void setIdMedicines(int idMedicines) {
		this.idMedicines = idMedicines;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getdate() {
		return date;
	}


	public void setdate(Date date) {
		this.date = date;
	}


	public String getduration() {
		return duration;
	}


	public void setduration(String duration) {
		this.duration = duration;
	}
	
	

}
