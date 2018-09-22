package retoprogramathon2018.devparaiso.domain;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Table(name = "Medicines")
public class Medicines {
	
	private Date date;
	private String duration;
	
	
	public Medicines(Date date, String duration) {
		this.date = date;
		this.duration = duration;
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
