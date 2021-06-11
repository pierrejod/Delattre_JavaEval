package com.Delattre_JavaEval;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Model.chambre;
import com.Model.directeur;
import com.Model.hotel;
import com.Model.salarie;
import com.Service.chambreService;
import com.Service.directeurService;
import com.Service.hotelService;
import com.Service.salarieService;

public class Principale {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		directeurService ds =new directeurService();
		directeur d1 = new directeur("Marc","Dupont");
		directeur d2 = new directeur("Didier","Laporte");
		
		ds.create(d2, session);
		session.saveOrUpdate(d1);

		salarieService sls =new salarieService();
		salarie s1 = new salarie("Bench","Mark",1423.6,2);
		salarie s2 = new salarie("Doe","John",1300.5,1);
		
		sls.create(s1, session);
		sls.create(s2, session);
		
		hotelService hs =new hotelService();
		hotel h1 = new hotel("Ibis","Rue Vendome",1816);
		hotel h2 = new hotel("Sofitel","Rue Marshall",3318);
		
		hs.create(h1, session);
		hs.create(h2, session);
		
		chambreService cs =new chambreService();
		chambre c1 = new chambre(15,14.4,"Familial",2);
		chambre c2 = new chambre(14,16.8,"Suite",1);
		
		cs.create(c1, session);
		cs.create(c2, session);

		h2.setDirecteur(d2);
		

		
		Set<chambre> listec = new HashSet<chambre>();
		listec.add(c1);
		listec.add(c2);
		
		Set<salarie> listes = new HashSet<salarie>();
		listes.add(s1);
		listes.add(s2);
		
		ds.update(session, 2);

		
		
		List<chambre>listech = cs.findAll(session);
		
		for(chambre cham : listech) 
		{
			System.out.println("Num Chambre :"+ cham.getNum_chambre() +" Superficie : "+ cham.getSuperficie() +"Type : "+cham.getType()+"Etage :"+ cham.getEtage());
		}
		

		
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	
	}

}

