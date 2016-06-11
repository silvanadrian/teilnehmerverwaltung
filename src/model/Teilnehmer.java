package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "\"teilnehmer\"")
public class Teilnehmer {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;
	@ManyToOne
	private Firma firma;
	private String adresse;
}
