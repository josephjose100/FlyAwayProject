package org.simplilearn.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.simplilearn.entities.Admin;
import org.simplilearn.entities.Flight;

public class HibConfig {

	public static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/db2");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Flight.class);
		configuration.addAnnotatedClass(Admin.class);
		SessionFactory factory=configuration.buildSessionFactory();
		return factory;
	}
	
	
}
