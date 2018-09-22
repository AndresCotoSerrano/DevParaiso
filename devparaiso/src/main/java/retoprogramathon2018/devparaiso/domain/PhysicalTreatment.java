package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "PhysicalTreatment")
public class PhysicalTreatment {

	private int idPhysicalTreatment;
	private String description;
	
	public PhysicalTreatment(String description,int id) {
		this.description = description;
		this.idPhysicalTreatment=id;
	}
	
	public int getIdPhysicalTreatment() {
		return idPhysicalTreatment;
	}

	public void setIdPhysicalTreatment(int idPhysicalTreatment) {
		this.idPhysicalTreatment = idPhysicalTreatment;
	}

	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}

	
}
