package ch.zehndersystems.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"kurs\"")
public class Kurs {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Kursnummer kursnummer;
	//private HashSet<Teilnehmer> teilnehmer = new HashSet<>();
	
	public Kurs() {}
	
	public Kurs(String name, Kursnummer nummer) {
		this.setName(name);
		this.setKursnummer(nummer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kursnummer getKursnummer() {
		return kursnummer;
	}

	public void setKursnummer(Kursnummer kursnummer) {
		this.kursnummer = kursnummer;
	}
}
