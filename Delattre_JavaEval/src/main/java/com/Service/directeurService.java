package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.directeur;
import com.Delattre_JavaEval.HibernateUtil;

public class directeurService implements Serializable {
	
	public boolean create(directeur c,Session s) 
	{
		s.save(c); //INSERT INTO directeur(nom,prenom) VALUES (c.getNom(),c.getPrenom())


		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		directeur c = s.get(directeur.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		directeur c = s.get(directeur.class, id);
		s.update(c); // UPDATE directeur SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public directeur findById(Session s,int id) 
	{
		
		directeur c = s.get(directeur.class, id); //SELECT * FROM directeur where id = id;
		return c;
	}
	
	public List<directeur> findAll(Session s) 
	{
		Query q = s.createQuery("from directeur");
		List<directeur> listeCom  = q.list(); //SELECT * FROM directeur where id = id;
		return listeCom;
	}

}



