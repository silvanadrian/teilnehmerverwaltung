package ch.zehndersystems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"firma\"")
public class Firma {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	public Firma() {}
	
	public Firma(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
