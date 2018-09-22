package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Tratamiento")
public class Treatment {

	private Medicines medicines;
	private PhysicalTreatment physicalTreatment;

	public Treatment(Medicines medicines, PhysicalTreatment physicalTreatment) {

		this.medicines = medicines;
		this.physicalTreatment = physicalTreatment;
	}

	public Medicines getMedicines() {
		return medicines;
	}

	public void setMedicines(Medicines medicines) {
		this.medicines = medicines;
	}

	public PhysicalTreatment getPhysicalTreatment() {
		return physicalTreatment;
	}

	public void setpPhysicalTreatment(PhysicalTreatment physicalTreatment) {
		this.physicalTreatment = physicalTreatment;
	}

}
