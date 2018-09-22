package retoprogramathon2018.devparaiso.domain;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Table(name = "Disease")
public class Disease {
	
	private String descriptionDisease;
	private int idDisease;

	public Disease(String descriptionDisease,int idDisease) {
		this.descriptionDisease = descriptionDisease;
		this.idDisease= idDisease;
	}

	
	public int getIdDisease() {
		return idDisease;
	}


	public void setIdDisease(int idDisease) {
		this.idDisease = idDisease;
	}


	public String getDescriptionDisease() {
		return descriptionDisease;
	}

	public void setDescriptionDisease(String descriptionDisease) {
		this.descriptionDisease = descriptionDisease;
	}
	
	

}
