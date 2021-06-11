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
@Table(name="hotel")
public class hotel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="nom", nullable = true, unique=false, length=50)
	private String nom;
	
	@Column(name="adresse", nullable = true, unique=false, length=150)
	private String adresse;
	
	@Column(name="telephone", nullable = true, unique=false)
	private int telephone;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="hotel_id")
	private Set<chambre> chambres;

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="directeur_id")
	private directeur directeur;


	public hotel() {
		super();
	}


	public hotel(String nom, String adresse, int telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
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


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public Set<chambre> getChambres() {
		return chambres;
	}


	public void setChambres(Set<chambre> chambres) {
		this.chambres = chambres;
	}


	public directeur getDirecteur() {
		return directeur;
	}


	public void setDirecteur(directeur directeur) {
		this.directeur = directeur;
	}
	
	
}
