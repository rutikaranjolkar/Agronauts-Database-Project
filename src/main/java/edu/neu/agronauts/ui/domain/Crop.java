package edu.neu.agronauts.ui.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crop")
public class Crop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crop_id")
	private long id;

	@Column(name = "crop_name")
	private String name;

	public Crop() {
	}

	public String getName() {
		return name;
	}

	public void setName(String cropName) {
		this.name = cropName;
	}

	public long getId() {
		return id;
	}

	public void setId(long cropID) {
		this.id = cropID;
	}

}
