package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "PhysicalTreatment")
public class PhysicalTreatment {

	private String description;
	
	public PhysicalTreatment(String description) {
		this.description = description;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}

	
}
