package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "PhysicalTreatment")
public class PhysicalTreatment {

	private int idPhysicalTreatment;
	private String descriptionPhysicalTreatment;
	
	public PhysicalTreatment(String descriptionPhysicalTreatment,int idPhysicalTreatment) {
		this.descriptionPhysicalTreatment = descriptionPhysicalTreatment;
		this.idPhysicalTreatment=idPhysicalTreatment;
	}
	
	public int getIdPhysicalTreatment() {
		return idPhysicalTreatment;
	}

	public void setIdPhysicalTreatment(int idPhysicalTreatment) {
		this.idPhysicalTreatment = idPhysicalTreatment;
	}

	public String getDescriptionPhysicalTreatment() {
		return descriptionPhysicalTreatment;
	}
	public void setDescriptionPhysicalTreatment(String descriptioPhysicalTreatmentn) {
		this.descriptionPhysicalTreatment = descriptioPhysicalTreatmentn;
	}

	
}
