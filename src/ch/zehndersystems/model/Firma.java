package ch.zehndersystems.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "\"firma\"")
public class Firma {
	@Id
	@GeneratedValue
	private long id;
	private StringProperty corpName;
	private StringProperty address;
	private StringProperty zipcode;
	private StringProperty city;
	
	public Firma() {
		this(null,null,null,null);
	}
	
	public Firma(String corpname, String address, String zipcode, String city) {
		this.setCorpNameProperty(new SimpleStringProperty(corpname));
		this.setAddressProperty(new SimpleStringProperty(address));
		this.setZipcodeProperty(new SimpleStringProperty(zipcode));
		this.setCityProperty(new SimpleStringProperty(city));
	}

	public String getCorpName() {
		return corpName.get();
	}

	public void setCorpName(String corpname) {
		corpName.set(corpname);
	}
	
	public StringProperty getCorpNameProperty() {
		return corpName;
	}

	public void setCorpNameProperty(StringProperty corpName) {
		this.corpName = corpName;
	}
	
	public String getAddress() {
		return address.get();
	}
	
	public void setAddress(String address) {
		this.address.set(address);
	}

	public StringProperty getAddressProperty() {
		return address;
	}

	public void setAddressProperty(StringProperty address) {
		this.address = address;
	}
	
	public String getZipcode() {
		return zipcode.get();
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode.set(zipcode);
	}

	public StringProperty getZipcodeProperty() {
		return zipcode;
	}

	public void setZipcodeProperty(StringProperty zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getCity() {
		return city.get();
	}
	
	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty getCityProperty() {
		return city;
	}

	public void setCityProperty(StringProperty city) {
		this.city = city;
	}
	
    @Override
    public String toString() {
    	return this.getCorpName();
    }


}
