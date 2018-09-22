package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Record")
public class Record {

	private Treatment Treatment;
	private Disease diseases;
	
	
	public Record(Treatment Treatment, Disease enfermedades) {
		this.Treatment = Treatment;
		this.diseases = enfermedades;
	}


	public Treatment getTreatment() {
		return Treatment;
	}


	public void setTreatment(Treatment Treatment) {
		this.Treatment = Treatment;
	}


	public Disease getEnfermedades() {
		return diseases;
	}


	public void setEnfermedades(Disease enfermedades) {
		this.diseases = enfermedades;
	}
	
	
	
}
