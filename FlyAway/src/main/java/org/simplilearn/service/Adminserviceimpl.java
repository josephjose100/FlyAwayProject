package org.simplilearn.service;

import org.simplilearn.dao.Admindao;
import org.simplilearn.dao.Admindaoimpl;
import org.simplilearn.entities.Admin;

public class Adminserviceimpl implements Adminservice {

	Admindao dao=new Admindaoimpl();
	
	
	public void createNewAdmin(Admin admin) {
		dao.insert(admin);
		
	}

	
	public void removeAdmin(String adminId) {
		dao.delete(adminId);
		
	}

	
	public boolean changePassword(String adminId, String password) {
		return dao.update(adminId, password);
		
	}


	
	public Admin validateAdmin(String adminId, String password) {
		
		return dao.getAdmin(adminId, password);
	}

	
	

}
