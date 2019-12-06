package com.productapp.model.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="productfeatures_table")
public class ProductFeatures {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String  name;
	private String madein;
	private String model;
	private String version;
	
	public ProductFeatures(String name, String madein, String model,
			String version) {
		super();
		this.name = name;
		this.madein = madein;
		this.model = model;
		this.version = version;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "ProductFeatures [id=" + id + ", name=" + name + ", madein="
				+ madein + ", model=" + model + ", version=" + version + "]";
	}

	public ProductFeatures() {
	}


	}