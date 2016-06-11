package model;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "\"kurs\"")
public class Kurs {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Kursnummer kursnummer;
	//private HashSet<Teilnehmer> teilnehmer = new HashSet<>();
}
