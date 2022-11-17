package org.simplilearn;

import org.simplilearn.entities.Admin;
import org.simplilearn.service.Adminservice;
import org.simplilearn.service.Adminserviceimpl;

public class TestAdmin {

	public static void main(String[] args) {
		
		//Creating admin
		Adminservice service=new Adminserviceimpl();
		Admin admin=new Admin();
		admin.setAdminId("j1234");
		admin.setPassword("qwertyuiop");
        service.createNewAdmin(admin);
       
		
		
		//Deleting admin
      /*  Adminservice service=new Adminserviceimpl();
		service.removeAdmin("j1234");
		*/ 
		
		
		
		
		//Changing password
		/*	Adminservice service=new Adminserviceimpl();
		if(service.changePassword("j1234", "qwerty")) {
		System.out.println("password changed successfully");	
		}
		
		*/
		
	}

}
