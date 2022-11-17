package org.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.config.HibConfig;
import org.simplilearn.entities.Admin;

public class Admindaoimpl implements Admindao {

	private Session getSession() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public void insert(Admin admin) {

		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String adminId) {

		Session session=getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Admin admin=session.get(Admin.class, adminId);
			session.delete(admin);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	
	}

	public boolean update(String adminId, String password) {
        boolean isUpdated=false;
		Session session=getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Admin admin1=session.get(Admin.class,adminId);
			admin1.setPassword(password);
			session.save(admin1);
			tx.commit();
			isUpdated=true;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return isUpdated;
		
	}

	
	public Admin getAdmin(String adminId, String password) {
		
		Session session=getSession();
		Admin admin=session.get(Admin.class, adminId);
		if(admin==null){
			return null;
		}
		if(password.equals(admin.getPassword())) {
		return admin;
		}
		else {
		return null;
		}
	}

}
