package ch.zehndersystems.model;



import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Teilnehmer {

	private long id;
	private StringProperty firstname;
	private StringProperty lastname;
	private StringProperty telephone;
	private StringProperty email;
	private SimpleObjectProperty<Firma> firma;
	
	/**
	 * Default Constructor
	 */
	public Teilnehmer(){
		this(null,null,null,null, null);
	}
	
	public Teilnehmer(String firstname, String lastname, String telephone, String email, Firma firma) {
		this.firstname = new SimpleStringProperty(firstname);
		this.lastname = new SimpleStringProperty(lastname);
		this.telephone = new SimpleStringProperty(telephone);
		this.email = new SimpleStringProperty(email);
		this.firma = new SimpleObjectProperty<>(firma);
	}

	public StringProperty getFirstnameProperty() {
		return firstname;
	}
	
	public String getFirstname() {
		return firstname.get();
	}

	public void setFirstname(String name) {
		this.firstname.set(name);
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
	
	public String getLastname() {
		return lastname.get();
	}
	
	public void setLastname(String lastname) {
		this.lastname.set(lastname);
	}

	public StringProperty getLastnameProperty() {
		return lastname;
	}

	public void setLastname(StringProperty lastname) {
		this.lastname = lastname;
	}
	
	public String getTelephone() {
		return telephone.get();
	}
	
	public void setTelephone(String telephone) {
		this.telephone.set(telephone);
	}

	public StringProperty getTelephoneProperty() {
		return telephone;
	}

	public void setTelephone(StringProperty telephone) {
		this.telephone = telephone;
	}

	public Firma getFirma() {
		return firma.get();
	}

	public void setFirma(Firma firma) {
		this.firma.set(firma);
	}
	
	public SimpleObjectProperty<Firma> getFirmaProperty() {
		return firma;
	}
	
	public void setFirmaProperty(SimpleObjectProperty<Firma> firma) {
		this.firma = firma;
	}
	

}
