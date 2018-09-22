package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Disease")
public class Disease {
	
	private String disease;

	public Disease(String enfermedad) {
		this.disease = enfermedad;
	}

	public String getEnfermedad() {
		return disease;
	}

	public void setEnfermedad(String disease) {
		this.disease = disease;
	}
	
	

}
