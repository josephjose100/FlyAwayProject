package org.simplilearn.dao;

import org.simplilearn.entities.Admin;

public interface Admindao {

	void insert(Admin admin);
	void delete(String adminId);
	boolean update(String adminId,String password);
	Admin getAdmin(String adminId,String password);
	
}
