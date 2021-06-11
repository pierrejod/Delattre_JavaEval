package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.chambre;
import com.Delattre_JavaEval.HibernateUtil;

public class chambreService implements Serializable {
	
	public boolean create(chambre c,Session s) 
	{
		s.save(c); //INSERT INTO chambre(nom,prenom) VALUES (c.getNom(),c.getPrenom())


		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		chambre c = s.get(chambre.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		chambre c = s.get(chambre.class, id);
		s.update(c); // UPDATE chambre SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public chambre findById(Session s,int id) 
	{
		
		chambre c = s.get(chambre.class, id); //SELECT * FROM chambre where id = id;
		return c;
	}
	
	public List<chambre> findAll(Session s) 
	{
		Query q = s.createQuery("from chambre");
		List<chambre> listeCom  = q.list(); //SELECT * FROM chambre where id = id;
		return listeCom;
	}

}



