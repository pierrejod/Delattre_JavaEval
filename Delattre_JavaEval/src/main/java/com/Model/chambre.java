package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="chambre")
public class chambre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="num_chambre", nullable = true, unique=false)
	private int num_chambre;
	
	@Column(name="superficie", nullable = false, unique=false)
	private double superficie;
	
	@Column(name="type", nullable = true, unique=false, length=50)
	private String type;
	
	@Column(name="etage", nullable = true, unique=false)
	private int etage;
	
	
	@ManyToOne
	private hotel hotel;


	public chambre() {
		super();
	}


	public chambre(int num_chambre, double superficie, String type, int etage) {
		super();
		this.num_chambre = num_chambre;
		this.superficie = superficie;
		this.type = type;
		this.etage = etage;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNum_chambre() {
		return num_chambre;
	}


	public void setNum_chambre(int num_chambre) {
		this.num_chambre = num_chambre;
	}


	public double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getEtage() {
		return etage;
	}


	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	
}
