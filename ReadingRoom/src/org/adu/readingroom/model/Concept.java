package org.adu.readingroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name="CONCEPTS",
	    uniqueConstraints =  @UniqueConstraint( name = "UK_NAME", columnNames = { "NAME" } )
	)
public class Concept {
	

	@Column(name="ID")
	@Id
	@GeneratedValue	
	private int id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
//	public Concept(String name, String description) {
//		this.name=name;
//		this.description=description;
//	};
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "id: " + id + ", name: " + name + ", description: " + description; 
	}

}
