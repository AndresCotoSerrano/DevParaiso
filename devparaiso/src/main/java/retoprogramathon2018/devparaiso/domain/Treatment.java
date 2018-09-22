package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Treatment")
public class Treatment {

	private int idTreatment;
	private Medicines medicines;
	private PhysicalTreatment physicalTreatment;

	public Treatment(Medicines medicines, PhysicalTreatment physicalTreatment,int idTreatment) {

		this.medicines = medicines;
		this.physicalTreatment = physicalTreatment;
		this.idTreatment= idTreatment;
	}

	public int getIdTreatment() {
		return idTreatment;
	}

	public void setIdTreatment(int idTreatment) {
		this.idTreatment = idTreatment;
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
