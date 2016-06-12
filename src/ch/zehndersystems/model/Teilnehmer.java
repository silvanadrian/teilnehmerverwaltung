package ch.zehndersystems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.ManyToOne;


@Entity
@Table(name = "\"teilnehmer\"")
public class Teilnehmer {
	@Id
	@GeneratedValue
	private long id;
	private StringProperty name;
	private StringProperty email;
	@ManyToOne
	private Firma firma;
	
	/**
	 * Default Constructor
	 */
	public Teilnehmer(){
		this(null,null);
	}
	
	public Teilnehmer(String name, String email) {
		this.name = new SimpleStringProperty(name);
		this.email = new SimpleStringProperty(email);
	}

	public StringProperty getNameProperty() {
		return name;
	}
	
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty getEmailProperty() {
		return email;
	}
	
	public String getEmail(){
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

}
