package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.hotel;
import com.Delattre_JavaEval.HibernateUtil;

public class hotelService implements Serializable {
	
	public boolean create(hotel c,Session s) 
	{
		s.save(c); //INSERT INTO hotel(nom,prenom) VALUES (c.getNom(),c.getPrenom())


		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		hotel c = s.get(hotel.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		hotel c = s.get(hotel.class, id);
		s.update(c); // UPDATE hotel SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public hotel findById(Session s,int id) 
	{
		
		hotel c = s.get(hotel.class, id); //SELECT * FROM hotel where id = id;
		return c;
	}
	
	public List<hotel> findAll(Session s) 
	{
		Query q = s.createQuery("from hotel");
		List<hotel> listeCom  = q.list(); //SELECT * FROM hotel where id = id;
		return listeCom;
	}

}



