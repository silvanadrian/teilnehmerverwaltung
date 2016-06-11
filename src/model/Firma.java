package model;

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
}
