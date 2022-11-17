package org.simplilearn.service;

import org.simplilearn.entities.Admin;

public interface Adminservice {

	void createNewAdmin(Admin admin);
	void removeAdmin(String adminId);
	boolean changePassword(String adminId,String password);
	Admin validateAdmin(String adminId,String password);
	
	
}
