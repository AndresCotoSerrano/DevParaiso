package retoprogramathon2018.devparaiso.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Table(name = "Kids")
public class Kids {

	@Id
	private String idNumber;
	private String name;
	private int age;
	private String genre;
	private String ethnic;
	private String kin;
	private Attendant attendant;
	private Record record;

	public Kids(String name, String idNumber, int age, String genre, Record record, String ethnic, String kin,
			Attendant attendant) {
		this.name = name;
		this.idNumber = idNumber;
		this.age = age;
		this.genre = genre;
		this.record = record;
		this.ethnic = ethnic;
		this.kin = kin;
		this.attendant = attendant;

	}

	public Attendant getAttendant() {
		return attendant;
	}

	public void setAttendant(Attendant attendant) {
		this.attendant = attendant;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getidNumber() {
		return idNumber;
	}

	public void setidNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record Record) {
		this.record = Record;
	}

	public String getethnic() {
		return ethnic;
	}

	public void setethnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getkin() {
		return kin;
	}

	public void setkin(String kin) {
		this.kin = kin;
	}

}
