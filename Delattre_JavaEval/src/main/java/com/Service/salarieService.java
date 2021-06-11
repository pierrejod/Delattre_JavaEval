package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.salarie;
import com.Delattre_JavaEval.HibernateUtil;

public class salarieService implements Serializable {
	
	public boolean create(salarie c,Session s) 
	{
		s.save(c); //INSERT INTO salarie(nom,prenom) VALUES (c.getNom(),c.getPrenom())


		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		salarie c = s.get(salarie.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		salarie c = s.get(salarie.class, id);
		s.update(c); // UPDATE salarie SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public salarie findById(Session s,int id) 
	{
		
		salarie c = s.get(salarie.class, id); //SELECT * FROM salarie where id = id;
		return c;
	}
	
	public List<salarie> findAll(Session s) 
	{
		Query q = s.createQuery("from salarie");
		List<salarie> listeCom  = q.list(); //SELECT * FROM salarie where id = id;
		return listeCom;
	}

}


