package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hcl.model.Employee;

public class HibernateUtil {

	public static Session getSession() {
			SessionFactory factory = null;
			Session session = null;

			Configuration configuration = null;
			try {
				configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(Employee.class);
				factory = configuration.buildSessionFactory();
				session = factory.getCurrentSession();
				return session;
			} catch (Exception ex) {
				return null;
			}
	}
}
