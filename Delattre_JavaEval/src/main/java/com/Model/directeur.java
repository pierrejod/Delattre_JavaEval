package com.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="directeur")
public class directeur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="nom", nullable = true, unique=false, length=50)
	private String nom;
	
	@Column(name="prenom", nullable = true, unique=false, length=50)
	private String prenom;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="directeur_id")
	private Set<salarie> salaries;
	
	@OneToOne(mappedBy="directeur")
	private hotel hotel;

	public directeur() {
		super();
	}

	public directeur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<salarie> getSalaries() {
		return salaries;
	}

	public void setSalaries(Set<salarie> salaries) {
		this.salaries = salaries;
	}
		
}